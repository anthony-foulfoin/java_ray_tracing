package xmlParser;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lancerRayon.Cube;
import lancerRayon.Ecran;
import lancerRayon.Facette;
import lancerRayon.Lumiere;
import lancerRayon.Matiere;
import lancerRayon.NonOrthogonalException;
import lancerRayon.Objet;
import lancerRayon.ObjetFacettes;
import lancerRayon.Plan;
import lancerRayon.PointDeVue;
import lancerRayon.Scene;
import lancerRayon.Sphere;
import lancerRayon.ValeurNonPositiveException;
import lancerRayon.Vue;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import util.Point3D;
import util.Vecteur3D;

public class RayonParserReader {

	static org.jdom.Document document;
	static Element racine;

	public static List<Vue> parserRenduXML(File f) throws JDOMException, IOException, NonOrthogonalException, ValeurNonPositiveException{
		
		SAXBuilder sxb = new SAXBuilder();
		List<Vue> l = new ArrayList<Vue>();
		

         //On cree un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est termin.
         document = sxb.build(f);

	      //On initialise un nouvel lment racine avec l'lment racine du document.
	      racine = document.getRootElement();
	      
	      // On obtient la liste de toutes les vues a parser
	      List<Element> listVues= racine.getChildren("Vue");
	      
	      // On itere sur la liste des vues
	      for(Iterator<Element> i = listVues.iterator();i.hasNext();){
	    	  Element e = i.next();
	    	  Vue v;
	    	  Ecran ecran = null;
	    	  PointDeVue pointDevue;
	    	  Point3D bG, hG, bD, hD;
	    	  int x,y,z;
	    	  // On obtient sa largeur et sa hauteur
	    	  int largeur = Integer.parseInt(e.getAttributeValue("largeur"));
	    	  int hauteur = Integer.parseInt(e.getAttributeValue("hauteur"));
	    	  
	    	  // On obtient les coordonnees des 4 points
	    	  // Le point en bas a gauche
	    	  x = Integer.parseInt(((Element) e.getChildren("Point").get(0)).getAttributeValue("x"));
	    	  y = Integer.parseInt(((Element) e.getChildren("Point").get(0)).getAttributeValue("y"));
	    	  z = Integer.parseInt(((Element) e.getChildren("Point").get(0)).getAttributeValue("z"));
	    	  
	    	  bG = new Point3D(x,y,z);
	    	  
	    	  // Le point en bas droite
	    	  x = Integer.parseInt(((Element) e.getChildren("Point").get(1)).getAttributeValue("x"));
	    	  y = Integer.parseInt(((Element) e.getChildren("Point").get(1)).getAttributeValue("y"));
	    	  z = Integer.parseInt(((Element) e.getChildren("Point").get(1)).getAttributeValue("z"));
	    	  
	    	  bD = new Point3D(x,y,z);
	    	  
	    	  // Haut droite
	    	  x = Integer.parseInt(((Element) e.getChildren("Point").get(2)).getAttributeValue("x"));
	    	  y = Integer.parseInt(((Element) e.getChildren("Point").get(2)).getAttributeValue("y"));
	    	  z = Integer.parseInt(((Element) e.getChildren("Point").get(2)).getAttributeValue("z"));
	    	  
	    	  hD = new Point3D(x,y,z);
	    	  
	    	  // Haut gauche
	    	  x = Integer.parseInt(((Element) e.getChildren("Point").get(3)).getAttributeValue("x"));
	    	  y = Integer.parseInt(((Element) e.getChildren("Point").get(3)).getAttributeValue("y"));
	    	  z = Integer.parseInt(((Element) e.getChildren("Point").get(3)).getAttributeValue("z"));
	    	  
	    	  hG = new Point3D(x,y,z);
	    	  
	    	 // On peut creer l'ecran

			ecran = new Ecran(new Vecteur3D(hG, hD), new Vecteur3D(hG,bG), hG, hauteur, largeur);
			
			// On traite le point de vue
			x = Integer.parseInt(e.getChild("PointVue").getChild("Point").getAttributeValue("x"));
			y = Integer.parseInt(e.getChild("PointVue").getChild("Point").getAttributeValue("y"));
			z = Integer.parseInt(e.getChild("PointVue").getChild("Point").getAttributeValue("z"));
	    	
			pointDevue = new PointDeVue(new Point3D(x,y,z));
			
			l.add(new Vue(pointDevue, ecran));
	      }
	      return l;
	}
	   
	public static Scene parserSceneXML(File f) throws JDOMException, IOException, ValeurNonPositiveException{
		
		SAXBuilder sxb = new SAXBuilder();
		Scene s;

         //On cre un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est termin.
         document = sxb.build(f);

	      //On initialise un nouvel lment racine avec l'lment racine du document.
	      racine = document.getRootElement();
	      
	      // On obtient la couleur de la lumiere ambiante
	      Integer ambR = Integer.parseInt(racine.getChild("Couleur").getAttributeValue("r"));
	      Integer ambV = Integer.parseInt(racine.getChild("Couleur").getAttributeValue("v"));
	      Integer ambB = Integer.parseInt(racine.getChild("Couleur").getAttributeValue("b"));
	      
	      s = new Scene(new Color(ambR, ambV, ambB));
	      
	      // On cree les objets de la scene
	      List<Element> listeObjets = racine.getChildren("ObjetGraphique");

	      // On itere sur la liste des objets
	      for(Iterator<Element> i = listeObjets.iterator();i.hasNext();){
				Element e = i.next();
				Objet o = null;
				Matiere m; 
				int oR;
				int oV;
				int oB;
				Color ambiante, diffuse, speculaire, reflection, refraction; 
				int brillance, indRefraction;
				
				// On obtient les caracteristiques de l'objet
				
				// Ambiante :
				oR = Integer.parseInt(e.getChild("Matiere").getChild("Ambiante").getChild("Couleur").getAttributeValue("r"));
				oV = Integer.parseInt(e.getChild("Matiere").getChild("Ambiante").getChild("Couleur").getAttributeValue("v"));
				oB = Integer.parseInt(e.getChild("Matiere").getChild("Ambiante").getChild("Couleur").getAttributeValue("b"));
				
				ambiante = new Color(oR, oV, oB);
				
				// Diffuse
				oR = Integer.parseInt(e.getChild("Matiere").getChild("Diffuse").getChild("Couleur").getAttributeValue("r"));
				oV = Integer.parseInt(e.getChild("Matiere").getChild("Diffuse").getChild("Couleur").getAttributeValue("v"));
				oB = Integer.parseInt(e.getChild("Matiere").getChild("Diffuse").getChild("Couleur").getAttributeValue("b"));
				
				diffuse = new Color(oR, oV, oB);
				
				// Speculaire
				oR = Integer.parseInt(e.getChild("Matiere").getChild("Speculaire").getChild("Couleur").getAttributeValue("r"));
				oV = Integer.parseInt(e.getChild("Matiere").getChild("Speculaire").getChild("Couleur").getAttributeValue("v"));
				oB = Integer.parseInt(e.getChild("Matiere").getChild("Speculaire").getChild("Couleur").getAttributeValue("b"));
				
				speculaire = new Color(oR, oV, oB);
				
				// Brillance
				brillance = Integer.parseInt(e.getChild("Matiere").getChild("Speculaire").getAttributeValue("n"));

				
				// Indice de refraction
				indRefraction = Integer.parseInt(e.getChild("Matiere").getAttributeValue("n"));
				
				// Reflection
				oR = Integer.parseInt(e.getChild("Matiere").getChild("Reflection").getChild("Couleur").getAttributeValue("r"));
				oV = Integer.parseInt(e.getChild("Matiere").getChild("Reflection").getChild("Couleur").getAttributeValue("v"));
				oB = Integer.parseInt(e.getChild("Matiere").getChild("Reflection").getChild("Couleur").getAttributeValue("b"));
				
				reflection = new Color(oR, oV, oB);
				
				// Refraction
				oR = Integer.parseInt(e.getChild("Matiere").getChild("Refraction").getChild("Couleur").getAttributeValue("r"));
				oV = Integer.parseInt(e.getChild("Matiere").getChild("Refraction").getChild("Couleur").getAttributeValue("v"));
				oB = Integer.parseInt(e.getChild("Matiere").getChild("Refraction").getChild("Couleur").getAttributeValue("b"));
				
				refraction = new Color(oR, oV, oB);
				
				// On cree la matiere de l'objet
				m = new Matiere(ambiante,diffuse, speculaire, reflection, refraction, indRefraction, brillance);
				
				// Si l'objet est une sphere
				if(e.getChild("Sphere")!=null){
					 // On obtient son centre et son rayon
					int x = Integer.parseInt(e.getChild("Sphere").getChild("Point").getAttributeValue("x"));
					int y = Integer.parseInt(e.getChild("Sphere").getChild("Point").getAttributeValue("y"));
					int z = Integer.parseInt(e.getChild("Sphere").getChild("Point").getAttributeValue("z"));
					int rayon = Integer.parseInt(e.getChild("Sphere").getAttributeValue("rayon"));
					
					o = new Sphere(m, new Point3D(x,y,z), rayon);
				}
				if(e.getChild("Plan")!=null){
					
					Point3D pt1, pt2, pt3;
					int x,y,z;
					// On obtient les 3 points de l'ecran
					x = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(0)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(0)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(0)).getAttributeValue("z"));
					
					pt1 = new Point3D(x,y,z);
					
					x = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(1)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(1)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(1)).getAttributeValue("z"));
					
					pt2 = new Point3D(x,y,z);
					
					x = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(2)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(2)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Plan").getChildren("Point").get(2)).getAttributeValue("z"));
					
					pt3 = new Point3D(x,y,z);
					
					o = new Plan(m, pt1, pt2, pt3);
					
				}
				if(e.getChild("Cube")!=null){
					    
					Point3D pt1, pt2, pt3, pt4;
					int x,y,z;
					// On obtient les 3 points de l'ecran
					x = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(0)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(0)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(0)).getAttributeValue("z"));
					
					pt1 = new Point3D(x,y,z);
					
					x = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(1)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(1)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(1)).getAttributeValue("z"));
					
					pt2 = new Point3D(x,y,z);
					
					x = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(2)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(2)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(2)).getAttributeValue("z"));
					
					pt3 = new Point3D(x,y,z);
					
					x = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(3)).getAttributeValue("x"));
					y = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(3)).getAttributeValue("y"));
					z = Integer.parseInt( ((Element) e.getChild("Cube").getChildren("Point").get(3)).getAttributeValue("z"));
					
					pt4 = new Point3D(x,y,z);
					
					Vecteur3D v1, v2, v3;
					
					v1 = new Vecteur3D(pt1, pt2);
					v2 = new Vecteur3D(pt1, pt3);	
					v3 = new Vecteur3D(pt1, pt4);
					o = new Cube(m, pt1, v1, v2, v3);
					
				}
				if(e.getChild("ObjetFacette")!=null){
					Element objet = e.getChild("ObjetFacette");
					List<Element> listeFacette = objet.getChildren("Facette");
					List<Facette> listObjets = new ArrayList<Facette>();
					
					for(Iterator<Element> it = listeFacette.iterator();it.hasNext();){
						
						Element facette = it.next();
						Facette fac;
						Point3D pt1, pt2, pt3;
						int x,y,z;
						
						x = Integer.parseInt( ((Element) facette.getChildren("Point").get(0)).getAttributeValue("x"));
						y = Integer.parseInt( ((Element) facette.getChildren("Point").get(0)).getAttributeValue("y"));
						z = Integer.parseInt( ((Element) facette.getChildren("Point").get(0)).getAttributeValue("z"));
						
						pt1 = new Point3D(x,y,z);
						
						x = Integer.parseInt( ((Element) facette.getChildren("Point").get(1)).getAttributeValue("x"));
						y = Integer.parseInt( ((Element) facette.getChildren("Point").get(1)).getAttributeValue("y"));
						z = Integer.parseInt( ((Element) facette.getChildren("Point").get(1)).getAttributeValue("z"));
						
						pt2 = new Point3D(x,y,z);
						
						x = Integer.parseInt( ((Element) facette.getChildren("Point").get(2)).getAttributeValue("x"));
						y = Integer.parseInt( ((Element) facette.getChildren("Point").get(2)).getAttributeValue("y"));
						z = Integer.parseInt( ((Element) facette.getChildren("Point").get(2)).getAttributeValue("z"));
						
						pt3 = new Point3D(x,y,z);
						
						fac = new Facette(m, pt1,pt2,pt3);
						
						listObjets.add(fac);
						
					}
					o = new ObjetFacettes(m, listObjets);
				}
				
				s.addObjet(o);
	      }
	      
	      // On traite maintenant les sources lumineuses
	      List<Element> lumieres = racine.getChildren("Source");
	      // On itere sur la liste des sources lumineuses
	      for(Iterator<Element> i = lumieres.iterator();i.hasNext();){
	    	  
	    	  Element e = i.next();
	    	  Lumiere l;
	    	  int lR;
	    	  int lV;
	    	  int lB;
	    	  
	    	  int x,y,z;
	    	  // On obtient la couleur de la source
	    	  lR = Integer.parseInt(e.getChild("Couleur").getAttributeValue("r"));
	    	  lV = Integer.parseInt(e.getChild("Couleur").getAttributeValue("v"));
	    	  lB = Integer.parseInt(e.getChild("Couleur").getAttributeValue("b"));
	    	  
	    	  // On obtient la position de la source
	    	  x = Integer.parseInt(e.getChild("Point").getAttributeValue("x"));
	    	  y = Integer.parseInt(e.getChild("Point").getAttributeValue("y"));
	    	  z = Integer.parseInt(e.getChild("Point").getAttributeValue("z"));
	    	  
	    	  // Construction de la source
	    	  l = new Lumiere(new Color(lR,lV,lB), new Point3D(x,y,z));
	    	  s.addLumiere(l);
	      }
	      // PARSING TERMINE !!!!
	      return s;
	}
}
