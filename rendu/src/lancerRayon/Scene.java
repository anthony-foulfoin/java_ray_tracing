package lancerRayon;

import java.awt.Color;
import java.awt.Container;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Cette classe permet de modeliser une scene.
 * Une scene est representee par :
 * - Une lumiere ambiante
 * - Un ensemble de vues
 * - Un ensemble d'objets composant la scene
 * - Un ensemble de sources lumineuses
 *
 */
public class Scene {

	private Color lumiereAmbiante; // La couleur de la lumiere ambiante
	private HashMap<Integer, Vue> vues; // La liste des vues associees a la scene
	private HashMap<Integer, Objet> objets; // La liste des objets associes a la scene
	private HashMap<Integer, Lumiere> lumieres; // La liste des lumieres associees a la scene
	private Rendu rendu; // Le rendu associe a la scene
	
	private static int VUES_IDENTIFIANT = 0;
	private static int OBJETS_IDENTIFIANT = 0;
	private static int LUMIERES_IDENTIFIANT = 0;
	
	/**
	 * Constructeur de la classe Scene
	 * @param lumiereAmbiante la lumiere ambiante de la scene
	 */
	public Scene(Color lumiereAmbiante){
		
		if(lumiereAmbiante == null) {
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		// On initialise le tout 
		this.lumiereAmbiante = lumiereAmbiante;
		this.vues = new HashMap<Integer, Vue>();
		this.objets = new HashMap<Integer, Objet>();
		this.lumieres = new HashMap<Integer, Lumiere>();
		this.rendu = new Rendu(this);
	}
	
	/**
	 * Cette methode permet d'ajouter une vue supplementaire a la scene
	 * @param v la vue que l'on souhaite ajouter
	 * @return un entier permettant d'identifier la vue de maniere unique
	 */
	public int addVue(Vue v){
		
		if(v == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		vues.put(VUES_IDENTIFIANT, v);
		
		VUES_IDENTIFIANT++;
		
		return VUES_IDENTIFIANT-1;
	}
	
	/**
	 * Methode qui doit etre appelee lorsque l'ont souhaite mettre a jour l'image associee a une vue
	 * @param numeroVue Numero de la vue dont on souhaite mettre a jour l'image associee
	 * @param afficheur Le container (JPanel, JFrame) qui affiche l'image calculee. Si le container est renseigne, ce dernier est raffraichi a chaque nouveau calcul de pixel. NULL sinon. 
	 * 
	 */
	public void mettreAJourRendu(int numeroVue, Container afficheur){
		rendu.calculerImage(vues.get(numeroVue), afficheur);
	}
	
	
	/**
	 * Permet d'obtenir une reference sur une vue a partir de son identifiant.
	 * Retourne null si la vue n'existe pas.
	 * @param v l'identifiant de la vue que l'on souhaite obtenir.
	 * @return la Vue correspondant a l'identifiant.
	 */
	public Vue getVue(int v){
		
		return vues.get(v);
		
	}
	
	/**
	 * Cette methode permet de supprimer une vue de la scene courante
	 * @param v l'identifiant de la vue a supprimer
	 */
	public void supprimerVue(int v){
		vues.remove(v);
	}
	
	/**
	 * Cette methode permet d'ajouter une source lumineuse a la scene
	 * @param l la lumiere que l'on souhaite ajouter
	 * @return un entier permettant d'identifier la lumiere de maniere unique
	 */
	public int addLumiere(Lumiere l){
		
		if(l == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		lumieres.put(LUMIERES_IDENTIFIANT, l);
		
		LUMIERES_IDENTIFIANT++;
		
		return LUMIERES_IDENTIFIANT-1;
	}
	
	/**
	 * Permet d'obtenir une rfrence sur une lumiere a partir de son identifiant.
	 * Retourne null si la lumiere n'existe pas.
	 * @param l l'identifiant de la lumiere que l'on souhaite obtenir.
	 * @return la Lumiere correspondant a l'identifiant.
	 */
	public Lumiere getLumiere(int l){
		
		return lumieres.get(l);
		
	}
	
	/**
	 * Cette methode permet de supprimer une lumiere de la scene courante
	 * @param l l'identifiant de la lumiere a supprimer
	 */
	public void supprimerLumiere(int l){
		lumieres.remove(l);
	}
	
	/**
	 * Cette methode permet d'ajouter un objet a la scene
	 * @param o l'objet que l'on souhaite ajouter
	 * @return un entier permettant d'identifier l'objet de maniere unique
	 */
	public int addObjet(Objet o){
		
		if(o == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		objets.put(OBJETS_IDENTIFIANT, o);
		
		OBJETS_IDENTIFIANT++;
		
		return OBJETS_IDENTIFIANT-1;
	}
	
	/**
	 * Permet d'obtenir une rfrence sur un objet a partir de son identifiant.
	 * Retourne null si l'objet n'existe pas.
	 * @param o l'identifiant de l'objet que l'on souhaite obtenir.
	 * @return l'Objet correspondant a l'identifiant.
	 */
	public Objet getObjet(int o){
		
		return objets.get(o);
		
	}
	
	/**
	 * Cette methode permet de supprimer un objet de la scene courante
	 * @param o l'identifiant de l'objet a supprimer
	 */
	public void supprimerObjet(int o){
		objets.remove(o);
	}
	
	// GETTERS et SETTERS

	/**
	 * 
	 * @return une collection contenant l'ensemble des objets de la scene
	 */
	public Collection<Objet> getObjetsValues(){
		return objets.values();
	}
	
	public Set<Integer> getObjetsKeys(){
		return objets.keySet();
	}
	
	/**
	 * 
	 * @return une collection contenant l'ensemble des lumieres de la scene
	 */
	public Collection<Lumiere> getLumieresValues(){
		return lumieres.values();
	}
	
	public Set<Integer> getLumieresKeys(){
		return lumieres.keySet();
	}
	
	/**
	 * 
	 * @return une collection contenant l'ensemble des vues de la scene
	 */
	public Collection<Vue> getVuesValues(){
		return vues.values();
	}

    	/**
	 *
	 * @return une collection contenant l'ensemble des identifiants associes aux vues de la scene
	 */
	public Set<Integer> getVuesKeys(){
		return vues.keySet();
	}
	
	/**
	 * 
	 * @return la lumiere ambiante de la scene
	 */
	public Color getLumiereAmbiante() {
		return lumiereAmbiante;
	}
	
	/**
	 * 
	 * @return le rendu associe a la scene
	 */
	public Rendu getRendu() {
		return rendu;
	}

	/**
	 * Permet de modifier la couleur de la lumiere ambiante
	 * @param lumiereAmbiante la couleur de la lumiere ambiante
	 */
	public void setLumiereAmbiante(Color lumiereAmbiante) {
		
		if(lumiereAmbiante == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.lumiereAmbiante = lumiereAmbiante;
	}
}
