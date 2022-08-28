package lancerRayon;

import java.awt.Color;

import util.Point3D;

/**
 * Cette classe permet de modeliser un point lumineux dans une scene.
 * Un point lumineux est caracterise par une couleur et par une position dans l'espace.
 *
 */
public class Lumiere {

	private Color couleur;
	private Point3D position;
	
	/**
	 * Constructeur de la classe
	 * @param couleur Couleur de la source lumineuse
	 * @param position Position de la source lumineuse dans l'espace
	 */
	public Lumiere(Color couleur, Point3D position){
		
		if(couleur == null || position == null){
			throw new NullPointerException();
		}
		this.couleur = couleur;
		this.position = position;
		
	}

	/**
	 * 
	 * @return la couleur de la source lumineuse
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * 
	 * @return la position de la source lumineuse
	 */
	public Point3D getPosition() {
		return position;
	}

	/**
	 * Permet de modifier la couleur de la source lumineuse
	 * @param couleur couleur de la source lumineuse
	 */
	public void setCouleur(Color couleur) {
		
		if(couleur==null){
			throw new NullPointerException();
		}
		
		this.couleur = couleur;
	}

	/**
	 * Permet de modifier la position de la source lumineuse
	 * @param position position de la source lumineuse
	 */
	public void setPosition(Point3D position) {
		
		if(position==null){
			throw new NullPointerException();
		}
		
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
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
		Lumiere other = (Lumiere) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
}
