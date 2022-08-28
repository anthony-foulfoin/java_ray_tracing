package lancerRayon;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import util.Point3D;
import util.Vecteur3D;

/**
 * Classe de rendu de l'application.
 * Elle doit etre associee a une scene.
 * Celle-ci permet de mettre a jour l'image associee a une vue et mettre a jour pixel
 * par pixel le container qui affiche l'image
 *
 */
public class Rendu {

	private Scene s; // La scene associee au rendu
	private static double EPSILON = 1E-5;
	
	private int nbThreads; // Nombre de threads de calcul crees
	private boolean imageCalculee; // Passe a true lorsque toute l'image a ete calculee
	private int nbPixelsCalcules; // Indique le nombre de pixels calcules a un instant T
	
	private List<ImageObserver> miseAJourComplete; // Liste des objets dont on doit notifier que l'image a ete totalement calculee
	private HashMap<Integer, ImageObserver> miseAJour; // Liste des objets dont on doit notifier, pour une quantite de pixels calcules donnes, que l'etape a ete franchie.
	
	
	/**
	 * 
	 * @param s La scene associee au rendu
	 */
	protected Rendu(Scene s){
		
		if(s==null){ 
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.s = s;
		this.nbThreads = 0;
		this.imageCalculee = false;
		this.nbPixelsCalcules = 0;
		this.miseAJourComplete = new ArrayList<ImageObserver>();
		this.miseAJour = new HashMap<Integer, ImageObserver>();
	}
	
	/**
	 * Methode principale de la classe qui doit etre appelee pour mettre a jour
	 * une image
	 * @param v la vue dont on souhaite mettre a jour l'image
	 * @param cont Le container qui affiche l'image de la vue. Si le container est non null, alors celui-ci est raffraichi a chaque nouveau calcul de pixel
	 */
	protected void calculerImage(Vue v, Container cont){
		
		if(v == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		Ecran ecran = v.getEcran();
		
		// On recherche le nombre de processeurs utilisables
		int nbProcesseurs = Runtime.getRuntime().availableProcessors();
		imageCalculee = false;
		
		// Forcer le nombre de threads :
		// nbProcesseurs = 4;
		
		nbThreads = nbProcesseurs;
		
		// On divise la hauteur par ce nombre de processeurs
		int hauteurDefaut = (ecran.getHauteur())/nbProcesseurs;
		
		// On initialise nbProcesseurs-1 Threads avec la hauteur par defaut
		for(int i = 0;i<nbProcesseurs-1;i++){
			new CalculVue(ecran.getLargeur(), i*hauteurDefaut+hauteurDefaut, i*hauteurDefaut, cont, v).start();
		}
		// Le n ieme processeur devra calculer une image de hauteur hauteurDefaut + les pixels restants
		new CalculVue(ecran.getLargeur(), (hauteurDefaut+(nbProcesseurs-1)*hauteurDefaut+(ecran.getHauteur()%nbProcesseurs)), (nbProcesseurs-1)*hauteurDefaut, cont, v).start();

	}
	
	/**
	 * 
	 * @return le nombre de pixels qui a ete calcule au moment de l'appel de la methode
	 */
	public int getNbPixelsCalcules(){
		return nbPixelsCalcules;
	}
	
	/**
	 * Cette methode doit etre appelee par les threads de calcul lorsqu'ils ont fini leur tache
	 */
	private synchronized void threadTermine(){
		
		nbThreads --; // Un thread a termine sa tache, on diminue le nombre de threads actifs
		
		// Si tous les threads ont termines leur tache
		if(nbThreads==0) {// L'image a ete entierement calculee
			imageCalculee = true;
			
			// On averti tous les observateurs que l'image a ete entierement calculee
			for (Iterator<ImageObserver> element = miseAJourComplete.iterator();element.hasNext();){
				element.next().notifier();
			}	
			// On reveil le thread qui a ete place en attente de fin de calcul
			this.notifyAll();
		}
	}
	
	/**
	 * Cette methode verifie si un observateur doit etre averti de la progression du calcul de l'image
	 */
	private synchronized void verifierMAJ(){
		
		if(miseAJour.get(nbPixelsCalcules)!=null){
			miseAJour.get(nbPixelsCalcules).notifier();
		}
		
	}
	
	/**
	 * Cette methode permet aux threads de calcul d'incrementer le nombre de pixels calculs a chaque calcul d'un nouveau pixel
	 */
	private synchronized void incNbPixelsCalcules(){
		nbPixelsCalcules++;
	}
	
	/**
	 * Si un observateur souhaite etre averti lorsque l'image a ete entierement calculee,
	 * celui-ci doit etre passe en parametre de cette methode.
	 * 
	 * Il est possible d'associer autant d'observateurs differents que souhaite, les observateurs
	 * deja associes a la methode ne sont pas ecrases.
	 * 
	 * @param maj l'observateur a avertir lorsque toute l'image a ete calculee
	 */
	public void avertirMiseAjourComplete(ImageObserver maj){
		
		if(maj == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		miseAJourComplete.add(maj);
		
	}
	
	/**
	 * Si un observateur souhaite etre averti lorsqu'un certain nombre de pixels a ete calcule,
	 * celui-ci doit etre passe en parametre de cette methode.
	 * 
	 * Par exemple, si un observateur Ob souhaite etre averti lorsque 5000 pixels ont ete calcules,
	 * il suffit d'appeler cette methode : avertirMiseAJour(Ob,5000). Lorsque 5000 pixels auront ete calcules,
	 * la methode notifier() de Ob sera automatiquement invoquee.
	 * 
	 * Attention, en l'etat actuel seul un observateur peut etre averti pour une valeur donnee. (Mais plusieurs
	 * observateur peuvent etre avertis pour des valeurs differentes).
	 * 
	 * Si la methode est invoquee 2 fois avec la meme valeur mais des observateurs differents, le second observateur
	 * ecrasera le premier.
	 * 
	 * @param maj L'observateur a notifier
	 * @param intervalle Nombre de pixels qui doivent avoir ete calcules pour notifier l'observateur
	 */
	public void avertirMiseAjour(ImageObserver maj, int intervalle){
		
		if(maj == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
 		
		miseAJour.put(intervalle, maj);
		
	}
	
	/**
	 * @return un booleen qui indique si l'image a ete entierement calculee depuis le dernier
	 * appel de la methode calculerImage
	 */
	public boolean imageCalculee(){
		return imageCalculee;
	}
	
	/**
	 * Methode du lancer de rayon. Renvoie la couleur associee a un lancer de rayon.
	 * 
	 * La methode doit etre invoquee avec recursivite = 0.
	 * 
	 * @param r le rayon qui est lance
	 * @param recursivite nombre de recursvites deja realisees pour un lancer de rayon donne
	 * @return la couleur associee au lancer de rayon
	 */
	private Color lancerRayon(Rayon r, int recursivite){

		Objet o;
		Point3D inter = new Point3D(0,0,0);
		Color resultat = null;
		
		Color reflexion, refraction, absAmb, absDiff, absSpec;
		
		if(r == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		// On determine l'objet qui possede une intersection avec le rayon
		o = calculerObjetIntersect(r, inter);
		
		// S'il n'y a aucun objet qui intersecte le rayon, la couleur du pixel est celle du
		// fond
		if(o==null){
			resultat = s.getLumiereAmbiante();
		}
		else{
			// On calcul toutes les composantes
			
			reflexion = calculerReflexion(o, r, inter, recursivite);
			refraction = calculerRefraction(o, r, inter, recursivite);
			
			absAmb = calculerAbsorptionAmbiante(o);
			
			absDiff = calculerAbsorptionDiffuse(o, inter);
			absSpec = calculerAbsorptionSpeculaire(o, inter, r);
			
			// On additionne les composantes
			
			resultat = additionnerCouleurs(absAmb, absDiff);
			
			resultat = additionnerCouleurs(resultat, reflexion);
			resultat = additionnerCouleurs(resultat, refraction);
			resultat = additionnerCouleurs(resultat, absSpec);	

		}	
		return resultat;
	}
	
	/**
	 * Cette methode permet d'additionner 2 couleurs
	 * @param c1 La premier couleur a additionner
	 * @param c2 La seconde couleur a additionner
	 * @return la couleur resultante de l'addition
	 */
	private Color additionnerCouleurs(Color c1, Color c2){
		
		float r;
		float v;
		float b;

		if(c1 == null || c2 == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		r = 1-((1-c1.getRed()/255f)*(1-c2.getRed()/255f));
		v = 1-((1-c1.getGreen()/255f)*(1-c2.getGreen()/255f));
		b = 1-((1-c1.getBlue()/255f)*(1-c2.getBlue()/255f));
		
		return new Color(r,v,b);
	}
	
	/**
	 * Methode qui permet de calculer la composante reflexion de la lumiere pour un point donne
	 * @param o l'objet auquel appartient le point a calculer
	 * @param rayon le rayon qui a ete lance pour obtenir l'objet et son point d'intersection
	 * @param inter l'intersection du rayon avec l'objet
	 * @param recursivite le nombre de lancer de rayons deja effectues pour un point donne de l'ecran
	 * @return la couleur de la composante
	 */
	private Color calculerReflexion(Objet o, Rayon rayon, Point3D inter, int recursivite){
		
		float r;
		float v;
		float b;
		Color result;
		Rayon rayonReflechi;
		
		if(o == null || rayon == null || inter == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		if(recursivite == LancerRayon.RECURSIVITE_MAX){
			// Si on a atteint la recusrivite maximale, on renvoie la couleur de fond
			result = s.getLumiereAmbiante();
		}
		else{
			// On obtient le rayon reflechi
			rayonReflechi = o.getRayonReflechi(rayon, inter);

			// On appelle recursivement LancerRayon a partir du rayon reflechi
			result = lancerRayon(rayonReflechi, recursivite+1);
			
			r = o.getMatiere().getReflection().getRed()/255f * result.getRed()/255f;
			v = o.getMatiere().getReflection().getGreen()/255f * result.getGreen()/255f;
			b = o.getMatiere().getReflection().getBlue()/255f * result.getBlue()/255f;
			
			result = new Color(r,v,b);
		}
		
		return result;
	}
	
	/**
	 * Methode qui permet de calculer la composante refraction de la lumiere pour un point donne
	 * @param o l'objet auquel appartient le point a calculer
	 * @param rayon le rayon qui a ete lance pour obtenir l'objet et son point d'intersection
	 * @param inter l'intersection du rayon avec l'objet
	 * @param recursivite le nombre de lancer de rayons deja effectues pour un point donne de l'ecran
	 * @return  la couleur de la composante
	 */
	private Color calculerRefraction(Objet o, Rayon rayon, Point3D inter, int recursivite){
		float r;
		float v;
		float b;
		Color result;
		Rayon rayonTransmis;
		
		if(o == null || rayon == null || inter == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		if(recursivite == LancerRayon.RECURSIVITE_MAX){
			// Si on a atteint la recusrivite maximale, on renvoie la couleur de fond
			result = s.getLumiereAmbiante();
		}
		else{
			// On obtient le rayon refacte
			rayonTransmis = o.getRayonTransmis(rayon, inter);
			
			// On appelle recursivement LancerRayon a partir du rayon refacte
			result = lancerRayon(rayonTransmis, recursivite+1);
			
			r = o.getMatiere().getRefraction().getRed()/255f * result.getRed()/255f;
			v = o.getMatiere().getRefraction().getGreen()/255f * result.getGreen()/255f;
			b = o.getMatiere().getRefraction().getBlue()/255f * result.getBlue()/255f;
			
			result = new Color(r,v,b);
		}
		
		return result;
	}
	
	/**
	 * Cette methode calcul la composante ambiante de la couleur
	 * @param o L'objet associe au point dont on souhaite calculer la composante ambiante
	 * @return la couleur de la composante ambiante associee a cet objet
	 */
	private Color calculerAbsorptionAmbiante(Objet o){
		
		float r;
		float v;
		float b;
		
		if(o == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		r = s.getLumiereAmbiante().getRed()/255.0f;
		v = s.getLumiereAmbiante().getGreen()/255.0f;
		b = s.getLumiereAmbiante().getBlue()/255.0f;
		
		r = r*o.getMatiere().getAbsAmb().getRed()/255.0f;
		v = v*o.getMatiere().getAbsAmb().getGreen()/255.0f;
		b = b*o.getMatiere().getAbsAmb().getBlue()/255.0f;
		
		return new Color(r,v,b);
	}
	
	/**
	 * Cette methode calcul la composante diffuse de la couleur
	 * @param o L'objet associe au point dont on souhaite calculer la composante diffuse pour un point donne
	 * @param p Point de l'objet dont on souhaite calculer la composante diffuse
	 * @return la couleur de la composante diffuse associee a ce point
	 */
	private Color calculerAbsorptionDiffuse(Objet o, Point3D p){
		
		float r = 0;
		float v = 0;
		float b = 0;

		Color c = new Color(0,0,0);
		boolean initialise = false;
		Collection<Lumiere> lumieres;
		Vecteur3D ray;
		Lumiere l;
		double cosinus;
		
		if(o == null || p == null) {
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		// il faut lancer un rayon vers chaque source lumineuse
		// on obtient la liste des sources lumineuses
		lumieres =  s.getLumieresValues();

		// On parcourt la liste des lumieres
		for(Iterator<Lumiere> i = lumieres.iterator();i.hasNext();){
			l = i.next();
			// On regarde si le rayon est intercepte par un objet
			if(sourceLumineuseAccess(p, l)){
				// La source lumineuse n'est pas cachee
				// Elle a une influence sur la couleur de l'objet
				// On construit le vecteur entre le point et la source lumineuse
				Color couleur;
				ray = new Vecteur3D(p, l.getPosition(),p);
				cosinus = o.getNormale(p).getCosinus(ray);
				cosinus = Math.abs(cosinus);
				
				r =  (float) ((o.getMatiere().getAbsDif().getRed()/255f) * (l.getCouleur().getRed()/255f) * cosinus);
				v =  (float) ((o.getMatiere().getAbsDif().getGreen()/255f) * (l.getCouleur().getGreen()/255f) * cosinus);
				b =  (float) ((o.getMatiere().getAbsDif().getBlue()/255f) * (l.getCouleur().getBlue()/255f) * cosinus);
				
				if(!initialise){
					c = new Color(r,v,b);
					initialise = true;
				}
				else{
					couleur = new Color(r,v,b);
					additionnerCouleurs(c, couleur);
				}
			}	
		}
		return c;
	}
	
	/**
	 * Cette methode calcul la composante speculaire de la couleur
	 * @param o L'objet associe au point dont on souhaite calculer la composante speculaire pour un point donne
	 * @param p Point de l'objet dont on souhaite calculer la composante speculaire
	 * @param rayon Le rayon lance
	 * @return la couleur de la composante speculaire associee a ce point
	 */
	private Color calculerAbsorptionSpeculaire(Objet o, Point3D p, Rayon rayon){
		
		if(o == null || p == null | rayon == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}

		float r = 0f;
		float v = 0f;
		float b = 0f;

		Color c = new Color(0,0,0);
		boolean initialise = false;
		Collection<Lumiere> lumieres;
		Vecteur3D ray;
		Lumiere l;
		
		Rayon rayonReflechi = o.getRayonReflechi(rayon, p);
		Color reflectance = o.getMatiere().getSpeculaire();
		double cosinus;
		double brillance = o.getMatiere().getBrillance();

		// il faut lancer un rayon vers chaque source lumineuse
		// on obtient la liste des sources lumineuses
		lumieres = s.getLumieresValues();
		
		// On parcourt la liste des lumieres
		for(Iterator<Lumiere> i = lumieres.iterator();i.hasNext();){
			l = i.next();
			// On regarde si le rayon est intercepte par un objet
			if(sourceLumineuseAccess(p, l)){
				// La source lumineuse n'est pas cachee
				// Elle a une influence sur la couleur de l'objet
				// On construit le vecteur entre le point et la source lumineuse
				Color couleur;
				ray = new Vecteur3D(p, l.getPosition(),p);
				cosinus = rayonReflechi.getVecteur().getCosinus(ray);
				cosinus = Math.abs(cosinus);
			
				r =  (float) ((reflectance.getRed()/255f) * (l.getCouleur().getRed()/255f) * Math.pow(cosinus, brillance));
				v =  (float) ((reflectance.getGreen()/255f) * (l.getCouleur().getGreen()/255f) * Math.pow(cosinus, brillance));
				b =  (float) ((reflectance.getBlue()/255f) * (l.getCouleur().getBlue()/255f) * Math.pow(cosinus, brillance));	
				
				if(!initialise){
					c = new Color(r,v,b);
					initialise = true;
				}
				else{
					couleur = new Color(r,v,b);
					additionnerCouleurs(c,couleur);
				}	
			}
		}
		return c;
	}
	
	/**
	 * Cette methode permet de savoir si une source lumineuse est accessible depuis un point donne (aucun objet entre le point et la source
	 * lumineuse) et renvoie true dans ce cas, false sinon
	 * 
	 * @param p point a partir duquel on souhaite savoir si la source lumineuse l est accessible directement sans intersecter d'objet.
	 * @param l source lumineuse dont on souhaite savoir si elle est accessible
	 * @return true si la source lumineuse est accessible, false sinon
	 */
	private boolean sourceLumineuseAccess(Point3D p, Lumiere l){
		
		if(p == null | l == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		Rayon rayon = new Rayon(new Vecteur3D(p,l.getPosition(),p));
		
		Objet objet = calculerObjetIntersect(rayon, rayon.getVecteur().getNorme());
		
		return objet==null;
		
	}
	
	/**
	 * Cette methode retourne l'objet le plus proche qui intersecte le rayon.
	 * Elle renvoie null si le rayon n'est pas intersecte.
	 * 
	 * Elle renvoie egalement le point d'intersection du rayon avec l'objet.
	 * 
	 * Pour cela un Point doit etre passe en parametre, si un objet intersecte le rayon,
	 * ce point recevra alors la valeur de l'intersection
	 * 
	 * @param r le rayon lance
	 * @param inters Le point qui recevra le point d'intersection
	 * @return l'objet intersecte par le rayon, null sinon
	 */
	private Objet calculerObjetIntersect(Rayon r, Point3D inters){
		
		if(r == null || inters == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}

		Collection<Objet> objets;
		Objet o;
		Objet resultat = null;
		Point3D intersection;
		Vecteur3D vect;
		double norme = -1; // Lorsqu'aucune norme n'a encore ete calculee, norme vaut -1
		double normeTmp = 0;
		
		// On recherche l'objet intersectant le rayon
		// tel que cet objet soit le plus proche de l'origine du rayon
		
		// On obtient la liste des objets de la scene
		objets = s.getObjetsValues();
		
		// On itere sur cette collection
		for(Iterator<Objet> i = objets.iterator();i.hasNext();){
			o = i.next();

			// On regarge s'il y a une intersection avec l'objet courant
			intersection = o.getIntersection(r);
			
			if(intersection!=null){
				// Il y a intersection
				
				// On verifie si le rayon n'a pas intersecte son point de depart
				if(!(Math.abs(intersection.getX()-r.getOrigine().getX())<EPSILON 
						&& Math.abs(intersection.getY()-r.getOrigine().getY())<EPSILON 
						&& Math.abs(intersection.getZ()-r.getOrigine().getZ())<EPSILON) ){
				
					// On prend l'objet le plus proche de la source du rayon
					// On trace un vecteur entre l'origine du rayon et le point d'intersection
					vect = new Vecteur3D(r.getOrigine(),intersection,r.getOrigine());
					
					// On regarde si sa norme est inferieure a la derniere norme calculee
					// Si oui, alors l'objet courant est plus proche que le dernier objet trouve
					normeTmp = vect.getNorme();
					if(normeTmp<norme || norme == -1){
						// L'objet courant est le plus proche trouve jusqu'a maintenant
						norme = normeTmp;
						resultat = o;
						inters.setX(intersection.getX());
						inters.setY(intersection.getY());
						inters.setZ(intersection.getZ());
					}
				}
			}
		}
		
		return resultat;
	}
	
	/**
	 * Cette methode retourne l'objet le plus proche qui intersecte le rayon.
	 * Elle renvoie null si le rayon n'est pas intersecte.
	 * 
	 * Les objets se trouvant au dela de distanceMax par rapport a l'origine du rayon sont ignores 
	 *
	 * @param r le rayon lance 
	 * @param distanceMax distance par rapport a l'origine du rayon au bout de laquelle les obkets sont ignores
	 * @return l'objet intersecte par le rayon, null sinon
	 */
	private Objet calculerObjetIntersect(Rayon r, double distanceMax){
		
		if(r== null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		Collection<Objet> objets = new ArrayList<Objet>(); 
		Objet o;
		Objet resultat = null;
		Point3D inters;
		Vecteur3D vect;
		double norme = -1; // Lorsqu'aucune norme n'a encore ete calculee, norme vaut -1
		double normeTmp = 0;
		// On recherche l'objet intersectant le rayon
		// tel que cet objet soit le plus proche de l'origine du rayon
		
		// On obtient la liste des objets de la scene
		objets = s.getObjetsValues();
		
		// On itere sur cette collection
		for(Iterator<Objet> i = objets.iterator();i.hasNext();){
			o = i.next();
			
			// On regarge s'il y a une intersection avec l'objet courant
			inters = o.getIntersection(r);
			if(inters!=null){
				// Il y a intersection
				
				// On verifie si le rayon n'a pas intersecte son point de depart
				if(!(Math.abs(inters.getX()-r.getOrigine().getX())<EPSILON 
						&& Math.abs(inters.getY()-r.getOrigine().getY())<EPSILON 
						&& Math.abs(inters.getZ()-r.getOrigine().getZ())<EPSILON) ){
					// On prend l'objet le plus proche de la source du rayon
					// On trace un vecteur entre l'origine du rayon et le point d'intersection
					vect = new Vecteur3D(r.getOrigine(),inters,r.getOrigine());
					
					// On regarde si sa norme est inferieure a la derniere norme calculee
					// Si oui, alors l'objet courant est plus proche que le dernier objet trouve
					normeTmp = vect.getNorme();
					
					// La norme doit etre inferieur a la derniere norme min trouve.
					// De plus, elle doit etre inferieur a la distance max a laquelle l'objet
					// peut se trouver de la source du rayon
			
					if((normeTmp<norme && normeTmp<distanceMax) || norme == -1){
						// L'objet courant est le plus proche trouve jusqu'a maintenant
						norme = normeTmp;
						resultat = o;
					}
				}
			}
		}
		return resultat;
	}
	
	/**
	 * Inner class permettant de gerer les threads de calculs.
	 * Les threads de calcul calculent l'image sur une portion donnee.
	 * 
	 */
	private class CalculVue extends Thread{
		
		int largeur, hauteur, start; // Largeur, hauteur a calculer, 
		// et numero de ligne a partir de laquelle commencer les calculs
		
		Container miseAJour; // Container a mettre a jour a chaque nouveau calcul de pixel
		
		Vue v; // Vue associee au calcul
		
		/**
		 * Constructeur du thread
		 * @param largeur Largeur de l'image a calculer par le thread
		 * @param hauteur Hauteur de l'image a calculer par le thread
		 * @param start Numero de la ligne a partir de laquelle le thread doit commencer ses calculs
		 * @param miseAJour Le container a mettre jour a chaque nouveau calcul de pixel
		 * @param v La vue associee au calcul
		 */
		public CalculVue(int largeur, int hauteur, int start, Container miseAJour, Vue v){
				
			if(v == null){
				throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
			}
			
			this.largeur = largeur;
			this.hauteur = hauteur;
			this.miseAJour = miseAJour;
			this.v = v;
			this.start = start;
			
		}
		
		/**
		 * Principale methode de calcul. Cette methode permet de lancer un rayon vers chaque pixel de l'ecran depuis le point de vue.
		 * Elle calcul la couleur associee au pixel de l'ecran et construit l'image au fur et a mesure.
		 * Le container qui affiche l'image est mis a jour a chaque nouveau calcul de pixel.
		 * Elle verifie egalement a chaque nouveau pixel calcule si des notifications doivent etre transmises aux observateurs.
		 */
		public void run(){
			
			Point3D origine;
			Ecran ecran;
			Vecteur3D direction1, direction2;
			Rayon r;
			Color c;
			
			Point3D point;
			// Calcul de l'image associee a la vue
			
			// On recupere les informations
			ecran = v.getEcran();
			origine = ecran.getV1().getOrigine();
			direction1 = ecran.getV1();
			direction2 = ecran.getV2();
			
			// On doit parcourir un par un chaque pixel de l'ecran
			// Pour chaque ligne de pixel
			for(int j = start;j<hauteur;j++){
				// Pour chaque colonne de pixel
				for(int i=0;i<largeur;i++){
					// on obtient le pixel numero (i,j)
					// On recherche ses coordonnees
					
					// On translate le pixel d'origine selon les vecteurs directionnels
					point = new Point3D(origine.getX(),origine.getY(),origine.getZ());
					
					// Translation selon le premier vecteur
					point.setX(point.getX()+i*direction1.getX());
					point.setY(point.getY()+i*direction1.getY());
					point.setZ(point.getZ()+i*direction1.getZ());
					
					// Translation selon le second vecteur
					point.setX(point.getX()+j*direction2.getX());
					point.setY(point.getY()+j*direction2.getY());
					point.setZ(point.getZ()+j*direction2.getZ());
					
					// On possede maintenant le point de l'ecran a visiter
					// On trace un nouveau rayon depuis le point de vue dans la direction du point de l'ecran a visiter
					
					r = new Rayon(new Vecteur3D(v.getPointDeVue().getPosition(), point, v.getPointDeVue().getPosition()));
					
					// On cherche la couleur associee a ce lance de rayon
					c = lancerRayon(r, 0);
					
					// On a obtenu la couleur
					// On construit le pixel de l'image
					
					v.getBufferedImage().setRGB(i, j, c.getRGB());
					
					// On incremente le nombre de pixels calcules
					incNbPixelsCalcules();
					
					// On verifie si des observateurs doivent etre notifies de l'avancement du calcul
					verifierMAJ();
					
					if(miseAJour!=null) miseAJour.repaint();
				}
			}
			// On indique que le thread a termine sa tache
			threadTermine();
		}
	}
}
