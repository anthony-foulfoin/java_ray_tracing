package util;

import java.util.Arrays;

/**
 * Cette classe permet de modeliser un point dans un espace en 3 dimensions.
 * 
 * Un point est donc represente par un triplet de points correspondant aux coordonnees
 * de ce dernier dans la base cannonique de l'espace.
 *
 */
public class Point3D {

	private double[] points;

	/**
	 * Constructeur de la classe
	 * @param x Premiere coordonnee du point, par rapport au premier vecteur de la base canonique
	 * @param y Seconde coordonnee du point, par rapport au second vecteur de la base canonique
	 * @param z Troisieme coordonnee du point, par rapport au troisieme vecteur de la base canonique
	 */
	public Point3D(double x, double y, double z){
		
		points = new double[3];
		
		points[0] = x;
		points[1] = y;
		points[2] = z;

	}
	
	/**
	 * 
	 * @return Coordonnee du point par rapport au premier vecteur de la base canonique 
	 */
	public double getX(){
		return points[0];
	}
	
	/**
	 * 
	 * @return Coordonnee du point par rapport au second vecteur de la base canonique 
	 */
	public double getY(){
		return points[1];
	}
	
	/**
	 * 
	 * @return Coordonnee du point par rapport au troisieme vecteur de la base canonique 
	 */
	public double getZ(){
		return points[2];
	}
	
	/**
	 * Permet de modifier la premiere coordonnee d'un point
	 * @param x Coordonnee du point par rapport au premier vecteur de la base canonique
	 */
	public void setX(double x){
		points[0] = x;
	}
	
	/**
	 * Permet de modifier la premiere coordonnee d'un point
	 * @param x Coordonnee du point par rapport au second vecteur de la base canonique
	 */
	public void setY(double y){
		points[1] = y;
	}
	
	/**
	 * Permet de modifier la premiere coordonnee d'un point
	 * @param x Coordonnee du point par rapport au troisieme vecteur de la base canonique
	 */
	public void setZ(double z){
		points[2] = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(points);
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
		Point3D other = (Point3D) obj;
		if (!Arrays.equals(points, other.points))
			return false;
		return true;
	}

	public String toString(){
		return "("+points[0]+","+points[1]+","+points[2]+")";
	}

}
