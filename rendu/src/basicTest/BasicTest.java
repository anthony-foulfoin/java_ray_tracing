package basicTest;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lancerRayon.NonOrthogonalException;
import lancerRayon.Scene;
import lancerRayon.ValeurNonPositiveException;
import lancerRayon.Vue;

import org.jdom.JDOMException;

import util.GetInput;
import util.PPM;
import xmlParser.RayonParserReader;
import xmlParser.RayonParserWriter;

public class BasicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		new BasicTest(args);	
		
	}
	
	public BasicTest(String[] args){
		System.out.println("Recherche du ficher XML des Scenes a l'adresse : ");
		System.out.println(args[1]);
		File scene = new File(args[1]);
		if(scene!=null) System.out.println("Fichier XML recupere");
		System.out.println("Recherche du ficher XML du rendu a l'adresse : ");
		System.out.println(args[0]);
		File rendu = new File(args[0]);
		if(rendu!=null) System.out.println("Fichier XML recupere");
		System.out.println("Parsing des fichiers XML");
		
		Scene s = null;
		List<Vue> vues = null;
		try {
			s = RayonParserReader.parserSceneXML(scene);
			vues = RayonParserReader.parserRenduXML(rendu);
		} catch (JDOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NonOrthogonalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValeurNonPositiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TEST
		System.out.println("Nombre d'objets : " + s.getObjetsValues().size());
		
		System.out.println("Parsing termine");
		System.out.println("Liaison de la scene et des vues");
		for (Iterator<Vue> iterator = vues.iterator(); iterator.hasNext();) {
			s.addVue(iterator.next());
		}
		
		System.out.println("Liaison terminee");
		System.out.println("Construction du rendu");
		 BufferedImage bf2 = s.getVue(0).getBufferedImage();
		JFrame frame = new PixelDemo(bf2);
	    s.mettreAJourRendu(0, frame);  
		System.out.println("Rendu construit");
		System.out.println("Affichage de l'image construite");
		
		GetInput.getString("Attente pour enregistrement. Appuyer sur touche pour enregistrer l'image");
		System.out.println("Enregistrement de l'image construite");
		// O enregistre l'image en PPM
		PPM ppm = new PPM(s.getVue(0).getBufferedImage());
		try {
			ppm.write("test.ppm");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Image enregistree");
		
		System.out.println("Enregistrement du fichier XML");
		
		File scene2 = RayonParserWriter.ecrireScene(s, "testscene.xml");
		File rendu2 = RayonParserWriter.ecrireRenduXML(s, "testrendu.xml");
		
	}

	public class PixelDemo extends JFrame {
		private Container c;

		public PixelDemo(BufferedImage img) {
			this.initialize(img);
			this.pack();
			this.setVisible(true);
		}

		private void initialize(BufferedImage img) {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			c = getContentPane();
			JPanel panel = new DemoPanel(img);
			panel.setPreferredSize(new Dimension(401, 401));
			c.add(panel);
		}

		class DemoPanel extends JPanel {
			private BufferedImage img;

			public DemoPanel(BufferedImage img) {
				super();
				this.initialize(img);
			}

			private void initialize(BufferedImage imag) {
				img = imag;
			}

			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
		}
	}
}
