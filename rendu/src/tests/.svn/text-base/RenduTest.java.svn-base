package tests;

import java.awt.Color;

import javax.swing.JFrame;

import junit.framework.TestCase;
import lancerRayon.Ecran;
import lancerRayon.NonOrthogonalException;
import lancerRayon.PointDeVue;
import lancerRayon.Rendu;
import lancerRayon.Scene;
import lancerRayon.ValeurNonPositiveException;
import lancerRayon.Vue;

import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class RenduTest  extends TestCase {
	
	private Color c1;
	private Scene s;
	private Rendu r;
	int nbProcesseurs;
	private Vecteur3D v1;
	private Vecteur3D v2;
	private Point3D position;
	int hauteur;
	int largeur;
	private Point3D a1;
	private Point3D a2;
	private Point3D b1;
	private Point3D b2;
	private Ecran e;
	int hauteurDefaut;
	private Vue v;
	private PointDeVue p;
	private JFrame j;
	
	public void setUp() {
		c1 = new Color(12);
		s = new Scene(c1);
		position = new Point3D(0,0,0);
		a1 = new Point3D(1,0,0);
		a2 = new Point3D(3,0,0);
		b1 = new Point3D(0,4,0);
		b2 = new Point3D(0,2,0);
		v1 = new Vecteur3D(a1, a2);
		v2 = new Vecteur3D(b1, b2);
		p = new PointDeVue(position);
		j = new JFrame();
		
		// rendu est devenu "protected" donc test plus possible ?
		//try{
			//r = new Rendu(s);
		//}
		//catch(NullPointerException r){
			//fail("Erreur : Exception de pointeur null leve");
		//}
	//}

	//@Test
	//public void testRendu() {
		//try{
			//r = new Rendu(s);
		//}
		//catch(NullPointerException r){
			//fail("Erreur : Exception de pointeur null leve");
		//}
		
	// Cas s est null
		//try{
			//r = new Rendu(null);
			//fail("Erreur de pointeur null non leve");
		//}
		//catch(NullPointerException r){
			//assertTrue(true);
		//}
	//}

	
	// calculerImage est devenu protected donc pas de test ?
	/*@Test
	public void testCalculerImage() {
		int nbProcesseurs = Runtime.getRuntime().availableProcessors();
		try{
			e = new Ecran(v1, v2, position, 20, 40);
		}
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		v= new Vue(p, e);
		r.calculerImage(v, j);
		assertEquals(e.getHauteur(), 20/nbProcesseurs);
		assertEquals(e.getLargeur(), 40);
	}*/
	
	// Les autres methodes sont "private"

	}
	
}
