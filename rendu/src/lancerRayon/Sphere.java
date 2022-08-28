package lancerRayon;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser une sphere
 *
 */
public class Sphere extends Objet{
	
	private Point3D centre;
	private double rayon;
	
	/**
	 * cree une nouvelle sphere
	 * 
	 * @param m la matiere de la sphere
	 * @param p le centre de la sphere
	 * @param r le rayon de la sphere
	 */
	public Sphere(Matiere m, Point3D p, double r) throws ValeurNonPositiveException{
		super(m);
		this.centre = p;
        this.rayon = r;
        if (this.rayon<=0 || this.rayon>32768){
            throw new ValeurNonPositiveException();
        }
	}

	/**
	 * retourne le point d'intersection entre le rayon r et cet objet
	 * si il existe
	 * 
	 * @param r le rayon incident
	 * @return le point d'intersection ou null s'il n'existe pas
	 */
	public Point3D getIntersection(Rayon r){
			
		if(r == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		Vecteur3D SC = new Vecteur3D(r.getOrigine(), this.centre, r.getOrigine());
		double ps =	r.getVecteur().getProduitScalaire(SC);
		double norme = SC.getNorme();
		
		double delta = rayon*rayon + ps*ps - norme*norme;
		
		if(delta>=0.1f){
			double t1 = ps - Math.sqrt(delta);
			double t2 = ps + Math.sqrt(delta);
			double t;
			if((t1<0.1f) & (t2<0.1f)){
				return null;
			}else if(t1>=0.1f & t2>=0.1f){
				t = Math.min(t1, t2);
			}else{
				t = Math.max(t1, t2);
			}
			double Px = r.getOrigine().getX() + t*r.getVecteur().getX();
			double Py = r.getOrigine().getY() + t*r.getVecteur().getY();
			double Pz = r.getOrigine().getZ() + t*r.getVecteur().getZ();
			return new Point3D(Px, Py, Pz);
		}else{
			return null;
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
		
		double P2x = this.centre.getX()+(p.getX()-this.centre.getX())/this.rayon;
		double P2y = this.centre.getY()+(p.getY()-this.centre.getY())/this.rayon;
		double P2z = this.centre.getZ()+(p.getZ()-this.centre.getZ())/this.rayon;
		Point3D P2 = new Point3D(P2x, P2y, P2z);
		
		return new Vecteur3D(this.centre, P2, p);
	}
	
	/**
	 * retourne le centre de la sphere
	 * 
	 * @return l'attribut centre
	 */
	public Point3D getCentre(){
		return this.centre;
	}
	
	/**
	 * modifie les coordonnees du centre de la sphere
	 * 
	 * @param x la nouvelle abscisse de centre
	 * @param y la nouvelle ordonnee de centre
	 * @param z la nouvelle cote de centre
	 */
	public void setCentre(double x, double y, double z){
		this.centre.setX(x);
		this.centre.setY(y);
		this.centre.setZ(z);
	}
	
	/**
	 * modifie les coordonnees du centre de la sphere
	 * 
	 * @param p le nouveau centre
	 */
	public void setCentre(Point3D p){
		
		if(p == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		this.centre.setX(p.getX());
		this.centre.setY(p.getY());
		this.centre.setZ(p.getZ());
	}
	
	/**
	 * retourne le rayon de la sphere
	 * 
	 * @return l'attribut rayon
	 */
	public double getRayon(){
		return this.rayon;
	}
	
	/**
	 * modifie le rayon de la sphere
	 * 
	 * @param r le nouveau rayon
	 */
	public void setRayon(double r) throws ValeurNonPositiveException{
        if (r<=0 || r>32768){
            throw new ValeurNonPositiveException();
        }
        else{
            this.rayon = r;
        }
	}
}
