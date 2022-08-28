package lancerRayon;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser le rayon qui est lance par l'algorithme depuis le 
 * point de vue a travers l'ecran.
 */
public class Rayon {

	private Vecteur3D vecteur; // Vecteur assoccie au rayon
	
	/**
	 * Constructeur de la classe
	 * @param vecteur direction du rayon. Un point d'origine doit imperativement etre specifie.
	 */
	public Rayon(Vecteur3D vecteur){
		
		if(vecteur == null){
			throw new NullPointerException();
		}
		
		if(vecteur.getOrigine() == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_ORIGINE);
		}
		
		this.vecteur = vecteur;
		this.vecteur.normaliser();
		
	}
	
	/**
	 * 
	 * @return le vecteur modelisant le rayon
	 */
	public Vecteur3D getVecteur(){
		return vecteur;
	}
	
	/**
	 * 
	 * @return l'origine du rayon
	 */
	public Point3D getOrigine(){
		return vecteur.getOrigine();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vecteur == null) ? 0 : vecteur.hashCode());
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
		Rayon other = (Rayon) obj;
		if (vecteur == null) {
			if (other.vecteur != null)
				return false;
		} else if (!vecteur.equals(other.vecteur))
			return false;
		return true;
	}
}
