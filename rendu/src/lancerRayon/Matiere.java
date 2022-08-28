package lancerRayon;

import java.awt.Color;

/**
 * Matiere associee a chaque objet.
 * Celle-ci se compose de l'ensemble des indices associes a chaque objet
 *
 */
public class Matiere {

	private Color ambiante;
	private Color diffuse;
	private Color speculaire;

	private Color reflection;
	private Color refraction;

	private double indiceRefraction;

	private double brillance;

	/**
	 * 
	 * @param ambiante indice de la composante ambiante
	 * @param diffuse indice de la composante diffuse
	 * @param speculaire indice de la composante speculaire
	 * @param reflection indice de la composante reflection
	 * @param refraction indice de la composante refraction
	 * @param indiceRefraction indice de refraction compris entre 0 et 1024
	 * @param brillance indice de la brillance compris entre 0 et 1024
	 */
	public Matiere(Color ambiante, Color diffuse, Color speculaire,
			Color reflection, Color refraction, double indiceRefraction,
			double brillance) {

		if(ambiante == null || diffuse == null || speculaire == null
				|| reflection == null || refraction==null || indiceRefraction <=0 ||
				indiceRefraction > 1024 || brillance <= 0 || brillance > 1024
				){
			throw new IndiceIncorrectException();
		}

		this.ambiante = ambiante;
		this.diffuse = diffuse;
		this.speculaire = speculaire;
		this.reflection = reflection;
		this.refraction = refraction;
		this.indiceRefraction = indiceRefraction/64.0;
		this.brillance = brillance/64.0;
	}

	/**
	 * retourne l'indice de la composante ambiante
	 * 
	 * @return l'attribut ambiante
	 */
	public Color getAbsAmb(){

		return ambiante;
	}

	/**
	 * modifie l'indice de la composante ambiante
	 * 
	 * @param abs la nouvelle valeur de l'attribut ambiante
	 */
	public void setAbsAmb(Color abs){

		if(abs==null){
			throw new NullPointerException();
		}

		this.ambiante = abs;
	}

	/**
	 * retourne l'indice de la composante diffuse
	 * 
	 * @return l'attribut diffuse
	 */
	public Color getAbsDif(){

		return diffuse;
	}

	/**
	 * modifie l'indice de la composante diffuse
	 * 
	 * @param abs la nouvelle valeur de l'attribut diffuse
	 */
	public void setAbsDif(Color abs){

		if(abs==null){
			throw new NullPointerException();
		}

		this.diffuse = abs;
	}

	/**
	 * retourne l'indice de la composante reflection
	 * 
	 * @return l'attribut reflection
	 */
	public Color getReflection(){

		return reflection;
	}

	/**
	 * modifie l'indice de la composante reflection
	 * 
	 * @param refl la nouvelle valeur de l'attribut reflection
	 */
	public void setReflection(Color refl){

		if(refl==null){
			throw new NullPointerException();
		}

		this.reflection = refl;
	}

	/**
	 * retourne l'indice de la composante refraction
	 * 
	 * @return l'attribut refraction
	 */
	public Color getRefraction(){

		return refraction;
	}
	
	/**
	 * modifie l'indice de la composante refraction
	 * 
	 * @param refr la nouvelle valeur de l'attribut refraction
	 */

	public void setRefraction(Color refr){

		if(refr==null){
			throw new NullPointerException();
		}

		this.refraction = refr;
	}

	/**
	 * retourne l'indice de la composante speculaire
	 * 
	 * @return l'attribut speculaire
	 */
	public Color getSpeculaire(){

		return speculaire;
	}
	
	/**
	 * modifie l'indice de la composante speculaire
	 * 
	 * @param refl la nouvelle valeur de l'attribut speculaire
	 */

	public void setSpeculaire(Color refl){

		if(refl==null){
			throw new NullPointerException();
		}

		this.speculaire = refl;
	}

	/**
	 * retourne l'indice de la brillance
	 * 
	 * @return l'attribut brillance
	 */
	public double getBrillance(){

		return brillance;
	}
	
	/**
	 * modifie l'indice de la brillance
	 * 
	 * @param abs la nouvelle valeur de l'attribut brillance
	 */

	public void setBrillance(int bril){

		if(bril<=0 || bril>1024){
			throw new IndiceIncorrectException();
		}

		this.brillance = bril/64.0;
	}

	/**
	 * retourne l'indice de refraction
	 * 
	 * @return l'attribut indiceRefraction
	 */
	public double getIndiceRefraction(){

		return indiceRefraction;
	}
	
	/**
	 * modifie l'indice de refraction
	 * 
	 * @param abs la nouvelle valeur de l'attribut indiceRefraction
	 */

	public void setIndiceRefraction(int indiceRefraction){

		if(indiceRefraction<=0 || indiceRefraction>1024){
			throw new IndiceIncorrectException();
		}

		this.indiceRefraction = indiceRefraction/64.0;
	}

}

