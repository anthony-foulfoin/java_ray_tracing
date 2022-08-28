package util;

/**
 * Cette classe permet de modeliser un vecteur dans un espace un 3 dimensions.
 * 
 * Un vecteur est represente par :
 * - Un point A
 * - Un point B
 * 
 * Le sens du vecteur est A->B
 * 
 * De plus, si une origine est specifiee, on considere qu'il s'agit alors d'un representant d'un vecteur.
 *
 */
public class Vecteur3D {

	private Point3D a;
	private Point3D b;
	private Point3D origine;
	
	/**
	 * Permet de construire un representant d'un vecteur a partir de 2 points et d'une origine.
	 * 
	 * @param a premier point du vecteur
	 * @param b second point du vecteur
	 * @param origine origine du representant. Ne doit pas etre nul.
	 */
	public Vecteur3D(Point3D a, Point3D b, Point3D origine){
		
		if(a == null || b ==null || origine == null){
			throw new NullPointerException();
		}
		this.a = a;
		this.b = b;
		this.origine = origine;

	}
	
	/**
	 * Permet de construire un vecteur a partir de 2 points.
	 * 
	 * @param a premier point du vecteur
	 * @param b second point du vecteur
	 */
	public Vecteur3D(Point3D a, Point3D b){
		
		if(a == null || b ==null){
			throw new NullPointerException();
		}
		this.a = a;
		this.b = b;
		this.origine = null;

	}
	
	/**
	 * Permet de construire un vecteur a partir de ses coordonnees
	 * 
	 * @param x premiere composante du vecteur
	 * @param y seconde composante du vecteur
	 * @param z troisieme composante du vecteur
	 */
	public Vecteur3D(double x, double y, double z){
		this.a = new Point3D(0,0,0);
		this.b = new Point3D(x,y,z);
		this.origine = null;
	}
	
	/**
	 * Permet de construire un representant d'un vecteur a partir de ses coordonnees et d'une origine
	 * @param x premiere composante du vecteur
	 * @param y seconde composante du vecteur
	 * @param z troisieme composante du vecteur
	 * @param origine origine du representant. Ne doit pas etre nul.
	 */
	public Vecteur3D(double x, double y, double z, Point3D origine){
		
		if(origine == null){
			throw new NullPointerException();
		}
		
		this.a = new Point3D(0,0,0);
		this.b = new Point3D(x,y,z);
		this.origine = origine;
	}
	
	/**
	 * Permet de calculer le produit scalaire entre le vecteur courant, et le vecteur passe en parametre.
	 * @param vect vecteur dont on souhaite calculer le produit scalaire avec le vecteur courant
	 * @return le produit scalaire
	 */
	public double getProduitScalaire(Vecteur3D vect){
		
		if(vect == null){
			throw new NullPointerException();
		}
		
		return this.getX()*vect.getX() + this.getY()*vect.getY()
		+ this.getZ()*vect.getZ();
	}
	
	/**
	 * 
	 * @return le norme du vecteur
	 */
	public double getNorme(){
		return Math.sqrt(
				Math.pow(b.getX()-a.getX(), 2) 	+ 
				Math.pow(b.getY()-a.getY(), 2)	+
				Math.pow(b.getZ()-a.getZ(), 2));
	}
	
	/**
	 * This - V2
	 * @param v2
	 * @return
	 */
	public Vecteur3D soustraire(Vecteur3D v2){
		return new Vecteur3D(this.getX()-v2.getX(), this.getY()-v2.getY(),this.getZ()-v2.getZ());
	}
	
	public void normaliser(){
		double norme = getNorme();
		
		double x,y,z;
		
		x = (b.getX()-a.getX())/norme;
		y = (b.getY()-a.getY())/norme;
		z = (b.getZ()-a.getZ())/norme;
		
		this.a = new Point3D(0,0,0);
		this.b = new Point3D(x,y,z);

	}
	
	/**
	 * Calcul le cosinus de l'angle entre le vecteur courant et le vecteur passe en parametre
	 * 
	 * @param v
	 * @return le cos de l'angle entre les 2 vecteurs
	 */
	public double getCosinus(Vecteur3D v){
		
		if(v==null){
			throw new NullPointerException();
		}
		
		return getProduitScalaire(v)/(getNorme()*v.getNorme());
		
	}

	/**
	 * 
	 * @return le premier point du vecteur
	 */
	public Point3D getA() {
		return a;
	}

	/**
	 * 
	 * @return le second point du vecteur
	 */
	public Point3D getB() {
		return b;
	}
	
	/**
	 * 
	 * @return la premiere composante du vecteur
	 */
	public double getX(){
		return b.getX()-a.getX();
	}
	
	/**
	 * 
	 * @return la deuxieme composante du vecteur
	 */
	public double getY(){
		return b.getY()-a.getY();
	}
	
	/**
	 * 
	 * @return la troisieme composante du vecteur
	 */
	public double getZ(){
		return b.getZ()-a.getZ();
	}

	/**
	 * 
	 * @return l'origine du vecteur. Retourne null s'il ne s'agit d'un vecteur et non d'un representant.
	 */
	public Point3D getOrigine() {
		return origine;
	}
	
	/**
	 * Cette methode permet de modifier l'origine du representant du vecteur
	 * @param origine l'origine du representant du vecteur, doit etre non nul.
	 */
	public void setOrigine(Point3D origine) {
		if(origine == null){
			throw new NullPointerException();
		}
		
		this.origine = origine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
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
		Vecteur3D other = (Vecteur3D) obj;
		if(getX()!=((Vecteur3D) obj).getX())
			return false;
		if(getY()!=((Vecteur3D) obj).getY())
			return false;
		if(getZ()!=((Vecteur3D) obj).getZ())
			return false;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		return true;
	}
	
	public String toString(){
		return "[ ("+ getX() + "," + getY() + "," + getZ()+") ]";
	}
}
