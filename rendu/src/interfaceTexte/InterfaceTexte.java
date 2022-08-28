package interfaceTexte;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import lancerRayon.ImageObserver;
import lancerRayon.Scene;
import lancerRayon.Vue;
import util.PPM;
import xmlParser.RayonParserReader;

public class InterfaceTexte implements ImageObserver{

	int nbPixels;
	Scene s;
	
	public static void main(String[] args){
		
		new InterfaceTexte(args);
	}

	public InterfaceTexte(String[] args){
		
		// Traitement des arguments
		
		// On verifie que le nombre d'arguments est correcte
		if(args.length < 2 || args.length > 3){
			System.out.println("Attention, Le fichier doit prendre en parametre 2 ou 3 arguments.");
			System.out.println("Utilisation : ");
			System.out.println("java InterfaceTexte nomFichierScene nomFichierRendu [nomFichierSortie]");
			System.out.println(" - nomFichierScene : l'adresse relative ou absolue du fichier contenant la description de la scene");
			System.out.println(" - nomFichierRendu : l'adresse relative ou absolue du fichier contenant la description des vues");
			System.out.println(" - nomFichierSortie : l'adresse relative ou absolue du fichier dans lequel enregistrer l'image calculee");
		}
		else {
			
			File fichierScene = new File(args[0]);
			File fichierRendu = new File(args[1]);
			String fichierSortie = null;
			
			if(args.length == 3 ){
				fichierSortie = args[2];
			}
			else{
				fichierSortie = "output.ppm";
			}
			
			System.out.println("\n1. Lecture du fichier XML des scenes");
			try {
				this.s = RayonParserReader.parserSceneXML(fichierScene);
			} catch (Exception e1) {
				System.out.println("1. Echec de la lecture");
				System.exit(0);
			}
			System.out.println("1. Lecture reussie");
			System.out.println("\n2. Lecture du fichier XML des rendus");
			List<Vue> vues = null;
			try{
				vues = RayonParserReader.parserRenduXML(fichierRendu);
			} catch (Exception e1) {
				System.out.println("2. Echec de la lecture");
				System.exit(0);
			}
			System.out.println("2. Lecture reussie");
			
			System.out.println("\n3. Liaison des vues a la scene");
			for (Iterator<Vue> iterator = vues.iterator(); iterator.hasNext();) {
				s.addVue(iterator.next());
			}
			System.out.println("3. Liaison reussie");
			
			nbPixels = vues.get(0).getEcran().getHauteur()*vues.get(0).getEcran().getLargeur();
			
			for(int i=nbPixels/20;i<=nbPixels;i = i+nbPixels/20){
				s.getRendu().avertirMiseAjour(this, i);
			}
			
			System.out.println("\n4. Calcul de l'image");
			long time = System.currentTimeMillis();
			s.mettreAJourRendu(0, null);
			// On attend que les threads aient fini leur travail avant de rendre la main
			try {
				synchronized (s.getRendu()) {
					s.getRendu().wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long timeAfter = System.currentTimeMillis();
			double timeCalcul = (timeAfter - time) / 1000.0;
			System.out.println("4. Image calculee en " + timeCalcul + " secondes");
			
			System.out.println("\n5. Enregistrement du fichier PPM");
			try {
				new PPM(vues.get(0).getImage()).write(fichierSortie);
			} catch (IOException e) {
				System.out.println("5. Echec de l'enregistrement");
				e.printStackTrace();
			}
			System.out.println("5. Enregistrement reussi");
		}
	}

	public void notifier() {

		System.out.println("4. Calcul : " + ((s.getRendu().getNbPixelsCalcules()*100/nbPixels)+1) + " %");;
		
	}
	
}
