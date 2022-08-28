package lancerRayon;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Cette classe permet de modeliser une vue.
 * 
 * Une vue est reprsente par un point de vue a partir duquel on observe la scene,
 * et un ecran au travers duquel la scene est observee.
 * 
 * Une vue est reprsentee par une image modelisant la scene telle qu'elle est vue depuis le point
 * de vue  traver l'ecran.
 *
 */
public class Vue {

	private BufferedImage image;
	private PointDeVue pointDeVue;
	private Ecran ecran;
	
	/**
	 * Constructeur de la classe
	 * @param pointDeVue point de vue a partir duquel on observe la scene
	 * @param ecran ecran au travers duquel la scene est observee
	 */
	public Vue(PointDeVue pointDeVue, Ecran ecran){
		
		if(pointDeVue == null || ecran == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.image = new BufferedImage(ecran.getLargeur(),ecran.getHauteur(), BufferedImage.TYPE_INT_RGB);
		this.pointDeVue = pointDeVue;
		this.ecran = ecran;
		
	}

	/**
	 * @return l'image construite par la classe, representant graphiquement la scene, depuis
	 * cette vue.
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * @return l'image "temporaire" representant graphiquement la scene, depuis
	 * cette vue.
	 */
	public BufferedImage getBufferedImage() {
		return  image;
	}

	/**
	 * 
	 * @return le point de vue de la vue
	 */
	public PointDeVue getPointDeVue() {
		return pointDeVue;
	}

	/**
	 * 
	 * @return l'ecran de la vue
	 */
	public Ecran getEcran() {
		return ecran;
	}

	/**
	 * Permet de modifier le point de vue
	 * @param pointDeVue le nouveau point de vue
	 */
	public void setPointDeVue(PointDeVue pointDeVue) {
		if(pointDeVue == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.pointDeVue = pointDeVue;
	}
	
	/**
	 * Permet de modifier l'image
	 * @param image la nouvelle image
	 */
	public void setBufferedImage(BufferedImage image) {
		if (image == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.image = image;
	}

	/**
	 * Permet de modifier l'ecran de la vue
	 * @param ecran le nouvel ecran de la vue
	 */
	public void setEcran(Ecran ecran) {
		if(ecran == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		this.ecran = ecran;
	}
}
