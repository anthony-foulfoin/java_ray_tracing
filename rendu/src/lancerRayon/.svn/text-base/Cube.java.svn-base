package lancerRayon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser un cube
 *
 */
public class Cube extends Objet{

	private ArrayList<Facette> listeFacettes;
	private int facetteIntersec;
	private Point3D origine;
	private Vecteur3D vecteur0, vecteur1, vecteur2;
	
	/**
	 * cree un nouveau cube a partir de trois vecteurs deux 
	 * a deux orthogonaux positiones par un point
	 * 
	 * @param m la matiere du plan
	 * @param origine le point d'origine du cube
	 * @param v0 le premier vecteur
	 * @param v1 le second vecteur
	 * @param v2 le troisieme vecteur
	 */
	public Cube(Matiere m, Point3D origine, Vecteur3D v0, Vecteur3D v1, Vecteur3D v2){
		super(m);
		
		if(origine == null || v0 == null || v1 == null || v2 == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		// On verifie que les vecteurs sont orthogonaux 2 a 2
		if(v0.getProduitScalaire(v1)!=0 || v0.getProduitScalaire(v2)!=0 || v1.getProduitScalaire(v2)!=0){
			throw new NonOrthogonalException(MessageErreur.MSG_ERREUR_ORTH);
		}
		
		// On verifie que leur norme est identique
		if(v0.getNorme()!=v1.getNorme() || v0.getNorme()!=v2.getNorme() || v1.getNorme()!=v2.getNorme()){
			throw new NormeIncorrectException(MessageErreur.MSG_ERREUR_NORM_IDENT);
		}
		
		this.listeFacettes = new ArrayList<Facette>(12); 
		this.origine = origine;
		this.vecteur0 = v0;
		this.vecteur1 = v1;
		this.vecteur2 = v2;
		
		Point3D p0 = origine;
		Point3D p1 = new Point3D(origine.getX()+v1.getX(), origine.getY()+v1.getY(), origine.getZ()+v1.getZ());
		Point3D p2 = new Point3D(origine.getX()+v1.getX()+v0.getX(), origine.getY()+v1.getY()+v0.getY(), origine.getZ()+v1.getZ()+v0.getZ());
		Point3D p3 = new Point3D(origine.getX()+v0.getX(), origine.getY()+v0.getY(), origine.getZ()+v0.getZ());
		Point3D p4 = new Point3D(origine.getX()+v2.getX(), origine.getY()+v2.getY(), origine.getZ()+v2.getZ());
		Point3D p5 = new Point3D(origine.getX()+v1.getX()+v2.getX(), origine.getY()+v1.getY()+v2.getY(), origine.getZ()+v1.getZ()+v2.getZ());
		Point3D p6 = new Point3D(origine.getX()+v1.getX()+v0.getX()+v2.getX(), origine.getY()+v1.getY()+v0.getY()+v2.getY(), origine.getZ()+v1.getZ()+v0.getZ()+v2.getZ());
		Point3D p7 = new Point3D(origine.getX()+v0.getX()+v2.getX(), origine.getY()+v0.getY()+v2.getY(), origine.getZ()+v0.getZ()+v2.getZ());
		
		listeFacettes.add(0, new Facette(m, p0, p1, p3));
		listeFacettes.add(1, new Facette(m, p1, p2, p3));
		listeFacettes.add(2, new Facette(m, p0, p3, p4));
		listeFacettes.add(3, new Facette(m, p3, p4, p7));
		listeFacettes.add(4, new Facette(m, p0, p1, p4));
		listeFacettes.add(5, new Facette(m, p1, p4, p5));
		listeFacettes.add(6, new Facette(m, p1, p2, p5));
		listeFacettes.add(7, new Facette(m, p2, p5, p6));
		listeFacettes.add(8, new Facette(m, p2, p3, p6));
		listeFacettes.add(9, new Facette(m, p3, p6, p7));
		listeFacettes.add(10, new Facette(m, p4, p5, p6));
		listeFacettes.add(11, new Facette(m, p4, p6, p7));
	}
	
	/**
	 * retourne le point d'intersection entre le rayon r et cet objet
	 * si il existe
	 * 
	 * @param r le rayon incident
	 * @return le point d'intersection ou null s'il n'existe pas
	 */
	public Point3D getIntersection(Rayon r){
		
		if ( r == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		List<Point3D> listeIntersec = new ArrayList<Point3D>();
		
		//recherche de tous les points d'intersections
		for(Iterator<Facette> i = this.listeFacettes.iterator(); i.hasNext();){
			Point3D pInter = i.next().getIntersection(r);
			if(pInter!=null){
				//liste des points d'intersection
				listeIntersec.add(pInter); 
			}
		}
		
		Point3D pointPlusProche = null;
		
		//si il y a des points d'intersection
		if(listeIntersec.size()>0){
			
			double norme = -1;
			double tmp;
			
			// On parcourt la liste des points d'intersection
			for(Iterator<Point3D> it = listeIntersec.iterator(); it.hasNext();){
				Point3D intersection = it.next();
				
				// On prend le point le plus proche
				tmp = new Vecteur3D(r.getOrigine(),intersection,r.getOrigine()).getNorme();
				
				if(tmp<norme || norme == -1){
					norme = tmp;
					pointPlusProche = intersection;
				}
			}
		}
		
		return pointPlusProche;
		
	}

	/**
	 * retourne le vecteur normal a cet objet au point p
	 * 
	 * @param p le point de l'objet dont on cherche la normale
	 * @return le vecteur normal au point p
	 */
	public Vecteur3D getNormale (Point3D p){
		Vecteur3D P0P1 = new Vecteur3D(listeFacettes.get(facetteIntersec).getPoint0(), listeFacettes.get(facetteIntersec).getPoint1(), listeFacettes.get(facetteIntersec).getPoint0());
		Vecteur3D P0P2 = new Vecteur3D(listeFacettes.get(facetteIntersec).getPoint0(), listeFacettes.get(facetteIntersec).getPoint2(), listeFacettes.get(facetteIntersec).getPoint0());
		
		double Nx = P0P1.getY()*P0P2.getZ()-P0P1.getZ()*P0P2.getY();
		double Ny = P0P1.getZ()*P0P2.getX()-P0P1.getX()*P0P2.getZ();
		double Nz = P0P1.getX()*P0P2.getY()-P0P1.getY()*P0P2.getX();
		
		Vecteur3D N = new Vecteur3D(Nx, Ny, Nz, p);
		Nx = Nx/N.getNorme();
		Ny = Ny/N.getNorme();
		Nz = Nz/N.getNorme();
		
		return new Vecteur3D(Nx, Ny, Nz, p);
	}
	
	/**
	 * retourne l'attribut origine
	 * 
	 * @return le point origine
	 */
	public Point3D getOrigine(){
		return this.origine;
	}
	
	/**
	 * modifie les coordonnees de l'attribut origine
	 * 
	 * @param ori le nouveau point d'origine
	 */
	public void setOrigine(Point3D ori){
		
		if(ori == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.origine = ori;
		
		Point3D p0 = origine;
		Point3D p1 = new Point3D(origine.getX()+this.getVecteur1().getX(), origine.getY()+this.getVecteur1().getY(), origine.getZ()+this.getVecteur1().getZ());
		Point3D p2 = new Point3D(origine.getX()+this.getVecteur1().getX()+this.getVecteur0().getX(), origine.getY()+this.getVecteur1().getY()+this.getVecteur0().getY(), origine.getZ()+this.getVecteur1().getZ()+this.getVecteur0().getZ());
		Point3D p3 = new Point3D(origine.getX()+this.getVecteur0().getX(), origine.getY()+this.getVecteur0().getY(), origine.getZ()+this.getVecteur0().getZ());
		Point3D p4 = new Point3D(origine.getX()+this.getVecteur2().getX(), origine.getY()+this.getVecteur2().getY(), origine.getZ()+this.getVecteur2().getZ());
		Point3D p5 = new Point3D(origine.getX()+this.getVecteur1().getX()+this.getVecteur2().getX(), origine.getY()+this.getVecteur1().getY()+this.getVecteur2().getY(), origine.getZ()+this.getVecteur1().getZ()+this.getVecteur2().getZ());
		Point3D p6 = new Point3D(origine.getX()+this.getVecteur1().getX()+this.getVecteur0().getX()+this.getVecteur2().getX(), origine.getY()+this.getVecteur1().getY()+this.getVecteur0().getY()+this.getVecteur2().getY(), origine.getZ()+this.getVecteur1().getZ()+this.getVecteur0().getZ()+this.getVecteur2().getZ());
		Point3D p7 = new Point3D(origine.getX()+this.getVecteur0().getX()+this.getVecteur2().getX(), origine.getY()+this.getVecteur0().getY()+this.getVecteur2().getY(), origine.getZ()+this.getVecteur0().getZ()+this.getVecteur2().getZ());
		
		listeFacettes.set(0, new Facette(this.getMatiere(), p0, p1, p3));
		listeFacettes.set(1, new Facette(this.getMatiere(), p1, p2, p3));
		listeFacettes.set(2, new Facette(this.getMatiere(), p0, p3, p4));
		listeFacettes.set(3, new Facette(this.getMatiere(), p3, p4, p7));
		listeFacettes.set(4, new Facette(this.getMatiere(), p0, p1, p4));
		listeFacettes.set(5, new Facette(this.getMatiere(), p1, p4, p5));
		listeFacettes.set(6, new Facette(this.getMatiere(), p1, p2, p5));
		listeFacettes.set(7, new Facette(this.getMatiere(), p2, p5, p6));
		listeFacettes.set(8, new Facette(this.getMatiere(), p2, p3, p6));
		listeFacettes.set(9, new Facette(this.getMatiere(), p3, p6, p7));
		listeFacettes.set(10, new Facette(this.getMatiere(), p4, p5, p6));
		listeFacettes.set(11, new Facette(this.getMatiere(), p4, p6, p7));
	}
	
	/**
	 * retourne l'attribut vecteur0
	 * 
	 * @return le premier vecteur du cube
	 */
	public Vecteur3D getVecteur0(){
		return this.vecteur0;
	}
	
	/**
	 * retourne l'attribut vecteur1
	 * 
	 * @return le second vecteur du cube
	 */
	public Vecteur3D getVecteur1(){
		return this.vecteur1;
	}
	
	/**
	 * retourne l'attribut vecteur2
	 * 
	 * @return le troisieme vecteur du cube
	 */
	public Vecteur3D getVecteur2(){
		return this.vecteur2;
	}
	
	/**
	 * modifie les vecteurs de base du cube
	 * 
	 * @param v0 la nouvelle valeur de vecteur0
	 * @param v1 la nouvelle valeur de vecteur1
	 * @param v2 la nouvelle valeur de vecteur2
	 */
	public void setVecteurs(Vecteur3D v0, Vecteur3D v1, Vecteur3D v2){
		
		// On verifie que les vecteurs sont orthogonaux 2 a 2
		if(v0.getProduitScalaire(v1)!=0 || v0.getProduitScalaire(v2)!=0 || v1.getProduitScalaire(v2)!=0){
			throw new NonOrthogonalException(MessageErreur.MSG_ERREUR_ORTH);
		}
		
		// On verifie que leur norme est identique
		if(v0.getNorme()!=v1.getNorme() || v0.getNorme()!=v2.getNorme() || v1.getNorme()!=v2.getNorme()){
			throw new NormeIncorrectException(MessageErreur.MSG_ERREUR_NORM_IDENT);
		}
		
		this.vecteur0 = v0;
		this.vecteur1 = v1;
		this.vecteur2 = v2;
		
		Point3D p0 = origine;
		Point3D p1 = new Point3D(origine.getX()+v1.getX(), origine.getY()+v1.getY(), origine.getZ()+v1.getZ());
		Point3D p2 = new Point3D(origine.getX()+v1.getX()+v0.getX(), origine.getY()+v1.getY()+v0.getY(), origine.getZ()+v1.getZ()+v0.getZ());
		Point3D p3 = new Point3D(origine.getX()+v0.getX(), origine.getY()+v0.getY(), origine.getZ()+v0.getZ());
		Point3D p4 = new Point3D(origine.getX()+v2.getX(), origine.getY()+v2.getY(), origine.getZ()+v2.getZ());
		Point3D p5 = new Point3D(origine.getX()+v1.getX()+v2.getX(), origine.getY()+v1.getY()+v2.getY(), origine.getZ()+v1.getZ()+v2.getZ());
		Point3D p6 = new Point3D(origine.getX()+v1.getX()+v0.getX()+v2.getX(), origine.getY()+v1.getY()+v0.getY()+v2.getY(), origine.getZ()+v1.getZ()+v0.getZ()+v2.getZ());
		Point3D p7 = new Point3D(origine.getX()+v0.getX()+v2.getX(), origine.getY()+v0.getY()+v2.getY(), origine.getZ()+v0.getZ()+v2.getZ());
		
		listeFacettes.set(0, new Facette(this.getMatiere(), p0, p1, p3));
		listeFacettes.set(1, new Facette(this.getMatiere(), p1, p2, p3));
		listeFacettes.set(2, new Facette(this.getMatiere(), p0, p3, p4));
		listeFacettes.set(3, new Facette(this.getMatiere(), p3, p4, p7));
		listeFacettes.set(4, new Facette(this.getMatiere(), p0, p1, p4));
		listeFacettes.set(5, new Facette(this.getMatiere(), p1, p4, p5));
		listeFacettes.set(6, new Facette(this.getMatiere(), p1, p2, p5));
		listeFacettes.set(7, new Facette(this.getMatiere(), p2, p5, p6));
		listeFacettes.set(8, new Facette(this.getMatiere(), p2, p3, p6));
		listeFacettes.set(9, new Facette(this.getMatiere(), p3, p6, p7));
		listeFacettes.set(10, new Facette(this.getMatiere(), p4, p5, p6));
		listeFacettes.set(11, new Facette(this.getMatiere(), p4, p6, p7));
	}
	
	/**
	 * retourne le numero de la facette intersectee
	 * 
	 * @return l'attribut facetteIntersec
	 */
	public int getFacetteIntersec(){
		return this.facetteIntersec;
	}

	/**
	 * retourne la facette numero i
	 * 
	 * @param numFacette le numero de la facette cherchee
	 * @return l'element numero numFacette de listeFacettes
	 */
	public Facette getFacette(int numFacette){
		return this.listeFacettes.get(numFacette);
	}
}
