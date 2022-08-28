package lancerRayon;

import java.util.Collection;
import java.util.HashMap;

/**
 * Principale classe du programme. C'est elle qui stocke l'ensemble des scenes du programme.
 *
 */
public class LancerRayon {

	public static int RECURSIVITE_MAX = 6;
	private int SCENES_IDENTIFIANT;
	private HashMap<Integer, Scene> scenes;
	
	/**
	 * Constructeur de la classe
	 * @param recursiviteMax Nombre maximum de sous-rayons que le programme peut lance pour un pixel donne.
	 */
	public LancerRayon(int recursiviteMax){
		LancerRayon.RECURSIVITE_MAX = recursiviteMax;
		this.SCENES_IDENTIFIANT = 0;
		scenes = new HashMap<Integer, Scene>();
	}

	/**
	 * Ajoute une scene au programme
	 * @param s La scene a ajouter
	 * @return l'identifiant associe a la scene
	 */
	public int ajouterScene(Scene s){
		
		if(s == null){
			throw new NullPointerException();
		}
		
		scenes.put(SCENES_IDENTIFIANT, s);
		
		SCENES_IDENTIFIANT++;
		
		return SCENES_IDENTIFIANT-1;
		
	}
	
	/**
	 * Permet d'obtenir une reference sur une scene a partir de son identifiant.
	 * Retourne null si la scene n'existe pas.
	 * @param s l'identifiant de la scene que l'on souhaite obtenir.
	 * @return la Scene correspondant a l'identifiant.
	 */
	public Scene getScene(int s){
		return scenes.get(s);
	}
	
	/**
	 * Cette methode permet de supprimer une scene
	 * @param s l'identifiant de la scene a supprimer
	 */
	public void supprimerScene(int s){
		scenes.remove(s);
	}
	
	/**
	 *
	 * @return toutes les scenes du programme
	 */
	public Collection<Scene> getScenes(){
		return scenes.values();
	}
}
