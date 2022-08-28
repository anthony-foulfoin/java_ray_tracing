package xmlParser;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import lancerRayon.Cube;
import lancerRayon.Facette;
import lancerRayon.Lumiere;
import lancerRayon.Objet;
import lancerRayon.ObjetFacettes;
import lancerRayon.Plan;
import lancerRayon.Scene;
import lancerRayon.Sphere;
import lancerRayon.Vue;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import util.Point3D;
import util.Vecteur3D;

public class RayonParserWriter {

	public static File ecrireRenduXML(Scene s, String path){
		
		//		Nous allons commencer notre arborescence en creant la racine XML
		//qui sera ici "Rendu".
		Element racine = new Element("Rendu");
		
		//On cree un nouveau Document JDOM base sur la racine que l'on vient de creer
		Document document = new Document(racine);

		// Rendu est une liste de vue. On itere sur les vues definies au sein de la scene
		for (Iterator<Vue> iter = s.getVuesValues().iterator(); iter.hasNext();) {
			Vue vue = iter.next();
			Element elementVue;
			
			Element tmp1, tmp2;
			Attribute tmpA;
			
			// On ajoute la vue en tant qu'element a la racine
			elementVue = new Element("Vue");
			
			racine.addContent(elementVue);
			
			// la largeur de l'ecran
			tmpA = new Attribute("largeur", Integer.toString(vue.getEcran().getLargeur()));
			elementVue.setAttribute(tmpA);
			
			// la hauteur de l'ecran
			tmpA = new Attribute("hauteur", Integer.toString(vue.getEcran().getHauteur()));
			elementVue.setAttribute(tmpA);
			
			// Creation du point de vue
			tmp1 = new Element("PointVue");
			elementVue.addContent(tmp1);
			
			// On cree le point du point de vue
			tmp2 = new Element("Point");
			tmp2.setAttribute("x", Integer.toString((int)vue.getPointDeVue().getPosition().getX()));
			tmp2.setAttribute("y", Integer.toString((int)vue.getPointDeVue().getPosition().getY()));
			tmp2.setAttribute("z", Integer.toString((int)vue.getPointDeVue().getPosition().getZ()));
			
			// On l'ajoute au point de vue
			tmp1.addContent(tmp2);
			
			Point3D origine = vue.getEcran().getPosition();
			Vecteur3D v1= vue.getEcran().getV1();
			Vecteur3D v2= vue.getEcran().getV2();	
			
			int ix;
			int iy;
			int iz;
			
			ix = (int)(origine.getX() + (vue.getEcran().getHauteur()-1)*v2.getX()) ;
			iy = (int)(origine.getY() + (vue.getEcran().getHauteur()-1)*v2.getY());
			iz = (int)(origine.getZ() + (vue.getEcran().getHauteur()-1)*v2.getZ());
			
			tmp2 = new Element("Point");
			tmp2.setAttribute("x", Integer.toString(ix));
			tmp2.setAttribute("y", Integer.toString(iy));
			tmp2.setAttribute("z", Integer.toString(iz));
			elementVue.addContent(tmp2);
			
			ix = (int)(origine.getX() + (vue.getEcran().getHauteur()-1)*v2.getX() + (vue.getEcran().getLargeur()-1)*v1.getX());
			iy = (int)(origine.getY() + (vue.getEcran().getHauteur()-1)*v2.getY() + (vue.getEcran().getLargeur()-1)*v1.getY());
			iz = (int)(origine.getZ() + (vue.getEcran().getHauteur()-1)*v2.getZ() + (vue.getEcran().getLargeur()-1)*v1.getZ());
			
			tmp2 = new Element("Point");
			tmp2.setAttribute("x", Integer.toString(ix));
			tmp2.setAttribute("y", Integer.toString(iy));
			tmp2.setAttribute("z", Integer.toString(iz));
			elementVue.addContent(tmp2);
			
			  //On calcul les coordonnee du nouveau point, translation de l'origine dans la largeur
			ix = (int)(origine.getX() + (vue.getEcran().getLargeur()-1)*v1.getX());
			iy = (int)(origine.getY() + (vue.getEcran().getLargeur()-1)*v1.getY());
			iz = (int)(origine.getZ() + (vue.getEcran().getLargeur()-1)*v1.getZ());
			
			tmp2 = new Element("Point");
			tmp2.setAttribute("x", Integer.toString(ix));
			tmp2.setAttribute("y", Integer.toString(iy));
			tmp2.setAttribute("z", Integer.toString(iz));
			elementVue.addContent(tmp2);
			
			tmp2 = new Element("Point");
			tmp2.setAttribute("x", Integer.toString((int)origine.getX()));
			tmp2.setAttribute("y", Integer.toString((int)origine.getY()));
			tmp2.setAttribute("z", Integer.toString((int)origine.getZ()));
			elementVue.addContent(tmp2);
		}
		
		
		File F = new File(path);
		

		try
		   {
		      //On utilise ici un affichage classique avec getPrettyFormat()
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      //Remarquez qu'il suffit simplement de creer une instance de FileOutputStream
		      //avec en argument le nom du fichier pour effectuer la serialisation.
		      sortie.output(document, new FileWriter(F));
		   }
		   catch (java.io.IOException e){
			   System.out.println("Erreur lors de l'ecriture");
		   }

		 return F;
		
	}
	
	public static File ecrireScene(Scene s, String path){
//		Nous allons commencer notre arborescence en creant la racine XML
		//qui sera ici "Scene".
		Element racine = new Element("Scene");
		
		//On cree un nouveau Document JDOM base sur la racine que l'on vient de creer
		Document document = new Document(racine);

		// Scene est une liste d'ObjetsGraphique, une liste de Source et une couleur 

		//On itere sur les objets graphiques definies au sein de la scene
		for (Iterator<Objet> iter = s.getObjetsValues().iterator(); iter.hasNext();) {
			Objet objet = iter.next();
			Element elementObjet;
			
			Element matiere, ambiante, couleur, diffuse, speculaire, reflection, refraction, sphere, plan, cube, objetfacette, point;
			Attribute indiceRefraction, brillance;
			
			// On ajoute la vue en tant qu'element a la racine
			elementObjet = new Element("ObjetGraphique");
			racine.addContent(elementObjet);
			
			//Un ObjetGraphique est compose d'une Matiere et soit d'une Sphere, d'un Plan d'un Cube ou d'un ObjetFacette)
			matiere = new Element("Matiere");
			elementObjet.addContent(matiere);
			
			
			
					//une matiere c'est Ambiante,Diffuse,Speculaire,Reflection et Refraction
			
			// n l'indice de refraction
			indiceRefraction =  new Attribute("n", Integer.toString((int)objet.getMatiere().getIndiceRefraction()*64));
			matiere.setAttribute(indiceRefraction);
			
			// Creation de Ambiante
			ambiante = new Element("Ambiante");
			matiere.addContent(ambiante);
			
			           //Couleur
			couleur = new Element("Couleur");
			couleur.setAttribute("r",Integer.toString(objet.getMatiere().getAbsAmb().getRed()));
			couleur.setAttribute("v",Integer.toString(objet.getMatiere().getAbsAmb().getGreen()));
			couleur.setAttribute("b",Integer.toString(objet.getMatiere().getAbsAmb().getBlue()));
			ambiante.addContent(couleur);
			
			// Creation de Ambiante
			diffuse = new Element("Diffuse");
			matiere.addContent(diffuse);
			           
			           //Couleur
			couleur = new Element("Couleur");
			couleur.setAttribute("r",Integer.toString(objet.getMatiere().getAbsDif().getRed()));
			couleur.setAttribute("v",Integer.toString(objet.getMatiere().getAbsDif().getGreen()));
			couleur.setAttribute("b",Integer.toString(objet.getMatiere().getAbsDif().getBlue()));
			diffuse.addContent(couleur);
			
			
			// Creation de Speculaire
			speculaire = new Element("Speculaire");
			matiere.addContent(speculaire);
			
			           //n
			brillance = new Attribute("n",Integer.toString((int)objet.getMatiere().getBrillance()*64));
			speculaire.setAttribute(brillance);           
			           //Couleur
			couleur = new Element("Couleur");
			couleur.setAttribute("r",Integer.toString(objet.getMatiere().getSpeculaire().getRed()));
			couleur.setAttribute("v",Integer.toString(objet.getMatiere().getSpeculaire().getGreen()));
			couleur.setAttribute("b",Integer.toString(objet.getMatiere().getSpeculaire().getBlue()));
			speculaire.addContent(couleur);
			
			// Creation de Reflection
			reflection = new Element("Reflection");
			matiere.addContent(reflection);
			           
			           //Couleur
			couleur = new Element("Couleur");
			couleur.setAttribute("r",Integer.toString(objet.getMatiere().getReflection().getRed()));
			couleur.setAttribute("v",Integer.toString(objet.getMatiere().getReflection().getGreen()));
			couleur.setAttribute("b",Integer.toString(objet.getMatiere().getReflection().getBlue()));
			reflection.addContent(couleur);
			
			
			// Creation de Refraction
			refraction = new Element("Refraction");
			matiere.addContent(refraction);
			           
			           //Couleur
			couleur = new Element("Couleur");
			couleur.setAttribute("r",Integer.toString(objet.getMatiere().getRefraction().getRed()));
			couleur.setAttribute("v",Integer.toString(objet.getMatiere().getRefraction().getGreen()));
			couleur.setAttribute("b",Integer.toString(objet.getMatiere().getRefraction().getBlue()));
			refraction.addContent(couleur);
			
			
			
			//On definie les differents objets
			if (objet.getClass()==Sphere.class){
				//Creation de Sphere
			sphere = new Element("Sphere");
			sphere.setAttribute("rayon",Integer.toString((int)((Sphere) objet).getRayon()));
			elementObjet.addContent(sphere);
			 
			// On cree le point de la sphere
			point = new Element("Point");
			point.setAttribute("x", Integer.toString((int)((Sphere) objet).getCentre().getX()));
			point.setAttribute("y", Integer.toString((int)((Sphere) objet).getCentre().getY()));
			point.setAttribute("z", Integer.toString((int)((Sphere) objet).getCentre().getZ()));
			sphere.addContent(point);
			} 
			
			else
				
			{ if (objet.getClass()==Plan.class){
				//Creation du plan
				plan = new Element("Plan");
				elementObjet.addContent(plan);
				
				// On cree le premier point du plan
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Plan) objet).getP0().getX()));
				point.setAttribute("y", Integer.toString((int)((Plan) objet).getP0().getY()));
				point.setAttribute("z", Integer.toString((int)((Plan) objet).getP0().getZ()));
				plan.addContent(point);
				
				
				// On cree le deuxieme point du plan
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Plan) objet).getP1().getX()));
				point.setAttribute("y", Integer.toString((int)((Plan) objet).getP1().getY()));
				point.setAttribute("z", Integer.toString((int)((Plan) objet).getP1().getZ()));
				plan.addContent(point);
				
				// On cree le troisieme point du plan
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Plan) objet).getP2().getX()));
				point.setAttribute("y", Integer.toString((int)((Plan) objet).getP2().getY()));
				point.setAttribute("z", Integer.toString((int)((Plan) objet).getP2().getZ()));
				plan.addContent(point);
				
				} 
			
			else
			{ if(objet.getClass()==Cube.class){
				//Creation du cube
				cube= new Element("Cube");
				elementObjet.addContent(cube);
				
				// On cree le premier point du cube
				//nota le point p0 du cube est recupere
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Cube) objet).getFacette(0).getPoint0().getX()));
				point.setAttribute("y", Integer.toString((int)((Cube) objet).getFacette(0).getPoint0().getY()));
				point.setAttribute("z", Integer.toString((int)((Cube) objet).getFacette(0).getPoint0().getZ()));
				cube.addContent(point);
				
				// On cree le deuxieme point du cube
				//nota le point p1 du cube est recupere
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Cube) objet).getFacette(0).getPoint1().getX()));
				point.setAttribute("y", Integer.toString((int)((Cube) objet).getFacette(0).getPoint1().getY()));
				point.setAttribute("z", Integer.toString((int)((Cube) objet).getFacette(0).getPoint1().getZ()));
				cube.addContent(point);
				
				// On cree le troisieme point du cube
				//Nota le point p3 du cube est recupere
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Cube) objet).getFacette(0).getPoint2().getX()));
				point.setAttribute("y", Integer.toString((int)((Cube) objet).getFacette(0).getPoint2().getY()));
				point.setAttribute("z", Integer.toString((int)((Cube) objet).getFacette(0).getPoint2().getZ()));
				cube.addContent(point);
				
				// On cree le qatrieme point du cube
				//Nota le point p4 du cube est recupere
				point = new Element("Point");
				point.setAttribute("x", Integer.toString((int)((Cube) objet).getFacette(2).getPoint2().getX()));
				point.setAttribute("y", Integer.toString((int)((Cube) objet).getFacette(2).getPoint2().getY()));
				point.setAttribute("z", Integer.toString((int)((Cube) objet).getFacette(2).getPoint2().getZ()));
				cube.addContent(point);
				
				}
			
			else {
				if(objet.getClass()==ObjetFacettes.class){
					 Element objetFacette = new Element("ObjetFacette");
					 elementObjet.addContent(objetFacette);
					 
					 Element point2;
				
				//On itere les Facettes definies sur l'ObjetFacettes
					for (Iterator<Facette> iter2 = ((ObjetFacettes)objet).getListeFacettes().iterator(); iter2.hasNext();) {
						Facette facette = iter2.next();
						Element elementFacette;
						
						//On ajoute la Facette en tant qu'element a l'objetFacette
					  elementFacette =  new Element("Facette");
					  objetFacette.addContent(elementFacette);
					  
					//Creation du premier point 
					  	point2 = new Element("Point");
					    point2.setAttribute("x", Integer.toString((int)facette.getPoint0().getX()));
					    point2.setAttribute("y", Integer.toString((int)facette.getPoint0().getY()));
					    point2.setAttribute("z", Integer.toString((int)facette.getPoint0().getZ()));
						elementFacette.addContent(point2);
						
					//Creation du deuxieme point 
					  	point2 = new Element("Point");
					    point2.setAttribute("x", Integer.toString((int)facette.getPoint1().getX()));
					    point2.setAttribute("y", Integer.toString((int)facette.getPoint1().getY()));
					    point2.setAttribute("z", Integer.toString((int)facette.getPoint1().getZ()));
						elementFacette.addContent(point2);
						
					//Creation du troisieme point 
					  	point2 = new Element("Point");
					    point2.setAttribute("x", Integer.toString((int)facette.getPoint2().getX()));
					    point2.setAttribute("y", Integer.toString((int)facette.getPoint2().getY()));
					    point2.setAttribute("z", Integer.toString((int)facette.getPoint2().getZ()));
						elementFacette.addContent(point2);
					  
						}
			}
			}
			}
			}
		}

	
	//On itere les Sources definies au sein de la Scene
		for (Iterator<Lumiere> iter3 = s.getLumieresValues().iterator(); iter3.hasNext();) {
			Lumiere lumiere = iter3.next();
			Element elementLumiere;
			
			//On ajoute la source en tant qu'element a la scene
		  elementLumiere =  new Element("Source");
		  racine.addContent(elementLumiere);
		  
		  //On ajoute le point de la source
		  Element point3 = new Element("Point");
		  
		//Creation du premier point ;
		    point3.setAttribute("x", Integer.toString((int)lumiere.getPosition().getX()));
		    point3.setAttribute("y", Integer.toString((int)lumiere.getPosition().getY()));
		    point3.setAttribute("z", Integer.toString((int)lumiere.getPosition().getZ()));
			elementLumiere.addContent(point3);
			
		//On ajoute la couleur a la source
	           //Couleur
			Element couleur2 = new Element("Couleur");
			couleur2.setAttribute("r",Integer.toString(lumiere.getCouleur().getRed()));
			couleur2.setAttribute("v",Integer.toString(lumiere.getCouleur().getGreen()));
			couleur2.setAttribute("b",Integer.toString(lumiere.getCouleur().getBlue()));
			elementLumiere.addContent(couleur2);
		}
		
		
		//On ajoute la couleur a la scene
        //Couleur
		Element couleur2 = new Element("Couleur");
		couleur2.setAttribute("r",Integer.toString(s.getLumiereAmbiante().getRed()));
		couleur2.setAttribute("v",Integer.toString(s.getLumiereAmbiante().getGreen()));
		couleur2.setAttribute("b",Integer.toString(s.getLumiereAmbiante().getBlue()));
		racine.addContent(couleur2);
		
		
		
	File F = new File(path);
		

		try
		   {
		      //On utilise ici un affichage classique avec getPrettyFormat()
		      XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		      //Remarquez qu'il suffit simplement de creer une instance de FileOutputStream
		      //avec en argument le nom du fichier pour effectuer la serialisation.
		      sortie.output(document, new FileWriter(F));
		   }
		   catch (java.io.IOException e){
			   System.out.println("Erreur lors de l'ecriture");
		   }

		 return F;
		
			
	}
}
