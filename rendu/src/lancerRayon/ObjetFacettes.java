package lancerRayon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Point3D;
import util.Vecteur3D;

/**
 * Cette classe permet de modeliser un objet compose de facettes
 *
 */
public class ObjetFacettes extends Objet{
	
	private List<Facette> listeFacettes;
	private int facetteIntersec;
	
	/**
	 * cree un nouvel objet a facettes
	 * 
	 * @param m la matiere de l'objet
	 * @param facettesCrees une liste de facettes preexistantes
	 */
	public ObjetFacettes(Matiere m, List<Facette> facettesCrees){
		super(m);
		
		if(facettesCrees == null) throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		
		this.listeFacettes = facettesCrees;
	}
	
	/**
	 * retourne le point d'intersection entre le rayon r et cet objet
	 * si il existe
	 * 
	 * @param r le rayon incident
	 * @return le point d'intersection ou null s'il n'existe pas
	 */
	public Point3D getIntersection(Rayon r){
		
		if ( r == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		List<Point3D> listeIntersec = new ArrayList<Point3D>();
		
		//recherche de tous les points d'intersections
		for(Iterator<Facette> i = this.listeFacettes.iterator(); i.hasNext();){
			Point3D pInter = i.next().getIntersection(r);
			if(pInter!=null){
				//liste des points d'intersection
				listeIntersec.add(pInter); 
			}
		}
		
		Point3D pointPlusProche = null;
		
		//si il y a des points d'intersection
		if(listeIntersec.size()>0){
			
			double norme = -1;
			double tmp;
			
			// On parcourt la liste des points d'intersection
			for(Iterator<Point3D> it = listeIntersec.iterator(); it.hasNext();){
				Point3D intersection = it.next();
				
				// On prend le point le plus proche
				tmp = new Vecteur3D(r.getOrigine(),intersection,r.getOrigine()).getNorme();
				
				if(tmp<norme || norme == -1){
					norme = tmp;
					pointPlusProche = intersection;
				}
			}
		}
		
		return pointPlusProche;
		
	}
	
	/**
	 * retourne le vecteur normal a cet objet au point p
	 * 
	 * @param p le point de l'objet dont on cherche la normale
	 * @return le vecteur normal au point p
	 */
	public Vecteur3D getNormale (Point3D p){
		
		if(p == null ){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		Vecteur3D P0P1 = new Vecteur3D(listeFacettes.get(facetteIntersec).getPoint0(), listeFacettes.get(facetteIntersec).getPoint1(), listeFacettes.get(facetteIntersec).getPoint0());
		Vecteur3D P0P2 = new Vecteur3D(listeFacettes.get(facetteIntersec).getPoint0(), listeFacettes.get(facetteIntersec).getPoint2(), listeFacettes.get(facetteIntersec).getPoint0());
		
		double Nx = P0P1.getY()*P0P2.getZ()-P0P1.getZ()*P0P2.getY();
		double Ny = P0P1.getZ()*P0P2.getX()-P0P1.getX()*P0P2.getZ();
		double Nz = P0P1.getX()*P0P2.getY()-P0P1.getY()*P0P2.getX();
		
		Vecteur3D N = new Vecteur3D(Nx, Ny, Nz, p);
		Nx = Nx/N.getNorme();
		Ny = Ny/N.getNorme();
		Nz = Nz/N.getNorme();
		
		return new Vecteur3D(Nx, Ny, Nz, p);
	}
	
	/**
	 * retourne le numero de la facette intersectee
	 * 
	 * @return l'attribut facetteIntersec
	 */
	public int getFacetteIntersec(){
		return this.facetteIntersec;
	}
	
	/**
	 * retourne le nombre de facettes
	 * 
	 * @return la taille de listeFacettes
	 */
	public int getNombreFacettes(){
		return this.listeFacettes.size();
	}
	
	/**
	 * retourne la liste des facettes
	 * 
	 * @return la liste de facettes listeFacettes
	 */
	public List<Facette> getListeFacettes(){
		return this.listeFacettes;
	}
	
	/**
	 * modifie les facettes
	 * 
	 * @param nouvFacettes la liste des nouvelles facettes
	 */
	public void setListeFacettes(List<Facette> nouvFacettes){
		
		if(nouvFacettes == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		for(int i=0; i<this.listeFacettes.size(); i++){
			this.listeFacettes.set(i, nouvFacettes.get(i));
		}
	}
	
	/**
	 * retourne la facette numero i
	 * 
	 * @param i le numero de la facette cherchee
	 * @return l'element numero i de listeFacettes
	 */
	public Facette getFacetteI(int i){
		return this.listeFacettes.get(i);
	}
	
	/**
	 * modifie la facette numero i
	 * 
	 * @param i le numero de la facette a modifier
	 * @param f la nouvelle facette
	 */
	public void setFacetteI(int i, Facette f){
		
		if(f == null){
			throw new NullPointerException(MessageErreur.MSG_ERREUR_PARAM_NULL);
		}
		
		this.listeFacettes.set(i, f);
	}

}
