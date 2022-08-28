package lancerRayon;

import util.Point3D;

/**
 * Cette classe permet de modeliser un point de vue, c'est a dire un point dans l'espace
 * a partir duquel on observe la scene a travers un ecran.
 *
 */
public class PointDeVue {

	private Point3D position; // Position du point de vue

	/**
	 * Constructeur de la classe
	 * @param position Position du point de vue dans l'espace.
	 */
	public PointDeVue(Point3D position) {

		if(position == null){
			throw new NullPointerException();
		}
		
		this.position = position;
	}

	/**
	 * 
	 * @return la position du point de vue dans l'espace
	 */
	public Point3D getPosition() {
		return position;
	}

	/**
	 * Permet de modifier la position du point de vue
	 * @param position la position du point de vue
	 */
	public void setPosition(Point3D position) {
		
		if(position == null){
			throw new NullPointerException();
		}
		
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		PointDeVue other = (PointDeVue) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}	
	
	
}
