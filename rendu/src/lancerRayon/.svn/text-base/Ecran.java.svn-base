package lancerRayon;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser un ecran.
 * 
 * Un ecran est caracterise par 2 vecteurs orthogonaux representants un "angle" de l'ecran, la position de cet angle, ainsi que la hauteur et 
 * la largeur de l'ecran.
 *
 */
public class Ecran {

	private Vecteur3D v1;
	private Vecteur3D v2;
	private int hauteur;
	private int largeur;
	
	/**
	 * Permet de construire un nouvel ecran.
	 * Un ecran est caracterise par 2 vecteurs orthogonaux representants un "angle" de l'ecran, la position de cet angle, ainsi que la hauteur et 
	 * la largeur de l'ecran.
	 * 
	 * Les 2 vecteurs passes en parametre doivent imperativement etre orthogonaux.
	 * 
	 * 
	 * @param v1 premier vecteur definissant l'ecran
	 * @param v2 second vecteur definissant l'ecran
	 * @param position l'origine des 2 vecteurs
	 * @param hauteur hauteur de l'ecran
	 * @param largeur largeur de l'ecran
	 * @throws NonOrthogonalException Exception lancee si v1 et v2 ne sont pas orthogonaux
	 * @throws ValeurNonPositiveException Exception lancee si position et/ou largeur est negatif ou nul ou si v1 ou v2 est de norme nulle.
	 */
	public Ecran(Vecteur3D v1, Vecteur3D v2, Point3D position, int hauteur,
			int largeur) throws NonOrthogonalException, ValeurNonPositiveException {
		
		if(v1 == null || v2 == null || position == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		if(hauteur<=0 || largeur<=0 || v1.getNorme()==0 || v2.getNorme()==0){
			throw new ValeurNonPositiveException();
		}
		
		// On verifie que les 2 vecteurs sont orthogonaux
		if(v1.getProduitScalaire(v2)!=0){
			throw new NonOrthogonalException();
		}
		
		this.v1 = v1;
		this.v2 = v2;
		this.v1.setOrigine(position);
		this.v2.setOrigine(position);
		
		this.v1.normaliser();
		this.v2.normaliser();
		
		this.hauteur = hauteur;
		this.largeur = largeur;
	}

	/**
	 * 
	 * @return le premier vecteur definissant l'ecran
	 */
	public Vecteur3D getV1() {
		return v1;
	}

	/**
	 * 
	 * @return le second vecteur definissant l'ecran
	 */
	public Vecteur3D getV2() {
		return v2;
	}

	/**
	 * 
	 * @return le poitn d'origine des 2 vecteurs definissant l'ecran
	 */
	public Point3D getPosition() {
		return v1.getOrigine();
	}

	/**
	 * 
	 * @return la hauteur de l'ecran
	 */
	public int getHauteur() {
		return hauteur;
	}



	/**
	 * 
	 * @return la largeur de l'ecran
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Permet de modifier le premier vecteur de l'ecran.
	 * Attention, celui-ci doit etre orthogonal au second vecteur
	 * @param v1 premier vecteur de l'ecran 
	 * @throws NonOrthogonalException Exception lancee si v1 et v2 ne sont pas orthogonaux
	 */
	public void setV1(Vecteur3D v1) throws NonOrthogonalException {
		
		if(v1 == null){
			throw new NullPointerException();
		}
		
		// On verifie que les 2 vecteurs sont orthogonaux
		if(v1.getProduitScalaire(v2)!=0){
			throw new NonOrthogonalException();
		}
		
		this.v1 = v1;
		this.v1.setOrigine(v2.getOrigine());
	}

	/**
	 * Permet de modifier le premier vecteur de l'ecran.
	 * Attention, celui-ci doit etre orthogonal au second vecteur
	 * @param v2 premier vecteur de l'ecran 
	 * @throws NonOrthogonalException Exception lancee si v1 et v2 ne sont pas orthogonaux
	 */
	public void setV2(Vecteur3D v2) throws NonOrthogonalException {
		
		if(v2 == null){
			throw new NullPointerException();
		}
		
		// On verifie que les 2 vecteurs sont orthogonaux
		if(v1.getProduitScalaire(v2)!=0){
			throw new NonOrthogonalException();
		}
		
		this.v2 = v2;
		this.v2.setOrigine(v1.getOrigine());
	}

	/**
	 * Permet de modifier le point d'origine des 2 vecteurs de l'ecran
	 * @param position la position du point d'origine des 2 vecteurs
	 */
	public void setPosition(Point3D position) {
		
		if(position == null){
			throw new NullPointerException();
		}
		
		this.v1.setOrigine(position);
		this.v2.setOrigine(position);
	}

	/**
	 * Permet de modifier la hauteur de l'ecran
	 * @param hauteur hauteur de l'ecran
	 * @throws ValeurNonPositiveException exception lancee si hauteur est negatif ou nul.
	 */
	public void setHauteur(int hauteur) throws ValeurNonPositiveException {
		
		if(hauteur<=0){
			throw new ValeurNonPositiveException();
		}
		
		this.hauteur = hauteur;
	}

	/**
	 * Permet de modifier la largeur de l'ecran
	 * @param largeur largeur de l'ecran
	 * @throws ValeurNonPositiveException exception lancee si largeur est negatif ou nul.
	 */
	public void setLargeur(int largeur) throws ValeurNonPositiveException {
		
		if(largeur<=0){
			throw new ValeurNonPositiveException();
		}
		
		this.largeur = largeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hauteur;
		result = prime * result + largeur;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ecran other = (Ecran) obj;
		if (hauteur != other.hauteur)
			return false;
		if (largeur != other.largeur)
			return false;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		return true;
	}
	
	
	
}
