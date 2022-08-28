package lancerRayon;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser un objet
 *
 */
public abstract class Objet {

	Matiere matiere;
	
	/**
	 * retourne le point d'intersection entre le rayon r et cet objet
	 * si il existe
	 * 
	 * @param r le rayon incident
	 * @return le point d'intersection ou null s'il n'existe pas
	 */
	public abstract Point3D getIntersection (Rayon r);
	
	/**
	 * retourne le vecteur normal a cet objet au point p
	 * 
	 * @param p le point de l'objet dont on cherche la normale
	 * @return le vecteur normal au point p
	 */
	public abstract Vecteur3D getNormale (Point3D p);
	
	/**
	 * retourne le rayon reflechi par rapport au rayon en un point donne
	 * 
	 * @param i le rayon qui genere le rayon reflechi
	 * @param p le point d'intersection de l'objet avec le rayon
	 * @return le rayon reflechi
	 */
	public Rayon getRayonReflechi (Rayon i, Point3D p){
		
		if (i == null || p == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		Vecteur3D N = getNormale(p);
		double ps = 2.0*i.getVecteur().getProduitScalaire(N);
		double Rx = i.getVecteur().getX()-ps*N.getX();
		double Ry = i.getVecteur().getY()-ps*N.getY();
		double Rz = i.getVecteur().getZ()-ps*N.getZ();
		
		Vecteur3D refl = new Vecteur3D(Rx, Ry, Rz, p);
		
		return new Rayon(refl);
	}
	
	/**
	 * retourne le rayon transmis par rapport au rayon en un point donne
	 * @param i le rayon qui genere le rayon transmis
	 * @param p le point d'intersection de l'objet avec le rayon
	 * @return le rayon transmis
	 */
	public Rayon getRayonTransmis(Rayon i, Point3D p){
		
		if (i == null || p == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		Vecteur3D N = getNormale(p);
		double ps = i.getVecteur().getProduitScalaire(N);
		double ind = this.getMatiere().getIndiceRefraction();
		
		if(ps>0){
			double Nx = -1.0*N.getX();
			double Ny = -1.0*N.getY();
			double Nz = -1.0*N.getZ();
			N = new Vecteur3D(Nx, Ny, Nz, p);
			ps = i.getVecteur().getProduitScalaire(N);
		}
		
		double Tx = (1.0/ind)*(i.getVecteur().getX()-(ps+Math.sqrt(ind*ind+ps*ps-1.0))*N.getX());
		double Ty = (1.0/ind)*(i.getVecteur().getY()-(ps+Math.sqrt(ind*ind+ps*ps-1.0))*N.getY());
		double Tz = (1.0/ind)*(i.getVecteur().getZ()-(ps+Math.sqrt(ind*ind+ps*ps-1.0))*N.getZ());
		
		Vecteur3D trans = new Vecteur3D(Tx, Ty, Tz, p);
		
		return new Rayon(trans);
	}
	
	/**
	 * Cree un nouvel objet
	 * 
	 * @param matiere la matiere de l'objet
	 */
	public Objet(Matiere matiere) {

		if(matiere == null){
			throw new NullPointerException();
		}
		this.matiere = matiere;
	}

	/**
	 * retourne la matiere de l'objet
	 * 
	 * @return l'attribut matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * modifie la matiere de l'objet
	 * 
	 * @param matiere la nouvelle matiere
	 */
	public void setMatiere(Matiere matiere) {
		
		if(matiere == null){
			throw new NullPointerException();
		}
		
		this.matiere = matiere;
	}
	
}
