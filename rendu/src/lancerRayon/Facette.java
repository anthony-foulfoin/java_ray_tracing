package lancerRayon;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser une facette
 *
 */
public class Facette extends Objet{

	private Point3D P0;
	private Point3D P1;
	private Point3D P2;
	
	/**
	 * cree une nouvelle facette triangulaire
	 * 
	 * @param m la matiere de la facette
	 * @param P0 le premier point
	 * @param P1 le second point
	 * @param P2 le troisieme point
	 */
	public Facette(Matiere m, Point3D p0, Point3D p1, Point3D p2){
		super(m);
		
		if(p0 == null || p1 == null || p2 == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.P0 = p0;
		this.P1 = p1;
		this.P2 = p2;
	}
	
	/**
	 * retourne le point d'intersection entre le rayon r et cet objet
	 * si il existe
	 * 
	 * @param r le rayon incident
	 * @return le point d'intersection ou null s'il n'existe pas
	 */
	public Point3D getIntersection(Rayon r){
		
		if(r== null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		double a1 = P1.getX()-P0.getX();
		double a2 = P1.getY()-P0.getY();
		double a3 = P1.getZ()-P0.getZ();
		
		double b1 = P2.getX()-P0.getX();
		double b2 = P2.getY()-P0.getY();
		double b3 = P2.getZ()-P0.getZ();
		
		double c1 = -r.getVecteur().getX();
		double c2 = -r.getVecteur().getY();
		double c3 = -r.getVecteur().getZ();
		
		double d1 = r.getOrigine().getX()-P0.getX();
		double d2 = r.getOrigine().getY()-P0.getY();
		double d3 = r.getOrigine().getZ()-P0.getZ();
		
		double det=a1*(b2*c3-c2*b3)-b1*(a2*c3-a3*c2)+c1*(a2*b3-a3*b2);
		if(det==0){
			return null;
		}else{
			double alpha=(d1*(b2*c3-c2*b3)-b1*(d2*c3-d3*c2)+c1*(d2*b3-d3*b2))/(det);
			double beta=(a1*(d2*c3-c2*d3)-d1*(a2*c3-a3*c2)+c1*(a2*d3-a3*d2))/(det);
			
			if((0<=alpha) && (alpha<=1) && (0<=beta) && (beta<=(1-alpha))){
				double gamma=(a1*(b2*d3-d2*b3)-b1*(a2*d3-a3*d2)+d1*(a2*b3-a3*b2))/(det);
				if(gamma>=0.1f){
					double Px = r.getOrigine().getX() + gamma*r.getVecteur().getX();
					double Py = r.getOrigine().getY() + gamma*r.getVecteur().getY();
					double Pz = r.getOrigine().getZ() + gamma*r.getVecteur().getZ();
					return new Point3D(Px, Py, Pz);
				}else{
					return null;
				}
			}else{
				return null;
			}
		}
	}

	/**
	 * retourne le vecteur normal a cet objet au point p
	 * 
	 * @param p le point de l'objet dont on cherche la normale
	 * @return le vecteur normal au point p
	 */
	public Vecteur3D getNormale (Point3D p){
		
		if(p == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		Vecteur3D P0P1 = new Vecteur3D(this.P0, this.P1, this.P0);
		Vecteur3D P0P2 = new Vecteur3D(this.P0, this.P2, this.P0);
	
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
	 * retourne l'attribut P0
	 * 
	 * @return le point P0
	 */
	public Point3D getPoint0(){
		return this.P0;
	}
	
	/**
	 * modifie les coordonnees de l'attribut P0
	 * 
	 * @param x la nouvelle abscisse de P0
	 * @param y la nouvelle ordonnee de P0
	 * @param z la nouvelle cote de P0
	 */
	public void setP0(double x, double y, double z){
		this.P0.setX(x);
		this.P0.setY(y);
		this.P0.setZ(z);
	}
	
	/**
	 * modifie les coordonnees de l'attribut P0
	 * 
	 * @param p le nouveau point P0
	 */
	public void setP0(Point3D p){
		
		if(p == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		this.P0.setX(p.getX());
		this.P0.setY(p.getY());
		this.P0.setZ(p.getZ());
	}
	
	/**
	 * retourne l'attribut P1
	 * 
	 * @return le point P1
	 */
	public Point3D getPoint1(){
		return this.P1;
	}
	
	/**
	 * modifie les coordonnees de l'attribut P1
	 * 
	 * @param x la nouvelle abscisse de P1
	 * @param y la nouvelle ordonnee de P1
	 * @param z la nouvelle cote de P1
	 */
	public void setP1(double x, double y, double z){
		this.P1.setX(x);
		this.P1.setY(y);
		this.P1.setZ(z);
	}
	
	/**
	 * modifie les coordonnees de l'attribut P1
	 * 
	 * @param p le nouveau point P1
	 */
	public void setP1(Point3D p){
		
		if(p == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		this.P1.setX(p.getX());
		this.P1.setY(p.getY());
		this.P1.setZ(p.getZ());
	}
	
	/**
	 * retourne l'attribut P2
	 * 
	 * @return le point P2
	 */
	public Point3D getPoint2(){
		return this.P2;
	}
	
	/**
	 * modifie les coordonnees de l'attribut P2
	 * 
	 * @param x la nouvelle abscisse de P2
	 * @param y la nouvelle ordonnee de P2
	 * @param z la nouvelle cote de P2
	 */
	public void setP2(double x, double y, double z){
		this.P2.setX(x);
		this.P2.setY(y);
		this.P2.setZ(z);
	}
	
	/**
	 * modifie les coordonnees de l'attribut P2
	 * 
	 * @param p le nouveau point P2
	 */
	public void setP2(Point3D p){
		
		if(p == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		this.P2.setX(p.getX());
		this.P2.setY(p.getY());
		this.P2.setZ(p.getZ());
	}
	
}
