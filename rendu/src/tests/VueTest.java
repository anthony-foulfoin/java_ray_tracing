package tests;

import java.awt.image.BufferedImage;

import junit.framework.TestCase;

import lancerRayon.Ecran;
import lancerRayon.PointDeVue;
import lancerRayon.Vue;

import org.junit.Before;
import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class VueTest   extends TestCase {
	
	private Point3D pt;
	private Point3D pt1;
	private Point3D a;
	private Point3D b;
	private Point3D a1;
	private Point3D b1;
	private Point3D a3;
	private Point3D b3;
	private Point3D a4;
	private Point3D b4;
	private Point3D origine;
	private BufferedImage image;
	private PointDeVue pDv;
	private PointDeVue pDv1;
	private Ecran e;
	private Ecran e1;
	private Vecteur3D v1;
	private Vecteur3D v2;
	private Vecteur3D v3;
	private Vecteur3D v4;
	private Vue v;
	
	@Before
	public void setUp() throws Exception {
		pt = new Point3D(-45,69,88);
		pt1 = new Point3D(2,6,8);
	    pDv = new PointDeVue(pt);
	    pDv1= new PointDeVue(pt1);
	    a = new Point3D(1,0,0);
		b = new Point3D (4,0,0);
		a1 = new Point3D(0,0,8);
		b1= new Point3D (0,0,89);
		a3 = new Point3D(0,0,-6);
		b3= new Point3D (0,0,0.3);
		a4 = new Point3D(0,120,0);
		b4= new Point3D (0,1.34,0);
	    origine = new Point3D(0,0,0);
	    v1 = new Vecteur3D(a,b,origine);
	    v2 = new Vecteur3D(a1,b1,origine);
	    v3 = new Vecteur3D(a3,b3,origine);
	    v4 = new Vecteur3D(a4,b4,origine);
	    e = new Ecran(v1,v2,origine,98,98);
	    e1 = new Ecran(v3,v4,origine,108,110);
	    image = new BufferedImage(e.getLargeur(),e.getHauteur(), BufferedImage.TYPE_INT_RGB);
	    v = new Vue(pDv,e);
		
	}

	@Test
	public void testVue() {
		try{
			v = new Vue(pDv,e);
		}
		catch (NullPointerException v){
			fail("Erreur : Exception de pointeur null levee");
		}
		
		//Si le point de vue vaut null
		try{
			v = new Vue(null,e);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException v){
			assertTrue(true);
		}
		
		//Si l'ecran vaut null
		try{
			v = new Vue(pDv,null);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException v){
			assertTrue(true);
		}
		
	}

	@Test
	public void testGetImage() {
		assertTrue(v != null);
		v.setBufferedImage(image);
		assertEquals(v.getImage(), image);
	}

	@Test
	public void testGetBufferedImage() {
		assertTrue(v != null);
		v.setBufferedImage(image);
		assertEquals(v.getBufferedImage(), image);
	}

	@Test
	public void testGetPointDeVue() {
		assertTrue(v != null);
		assertEquals(v.getPointDeVue() , pDv);
	}

	@Test
	public void testGetEcran() {
		assertTrue(v != null);
		assertEquals(v.getEcran(),e);
	}

	@Test
	public void testSetPointDeVue() {
		try {
			v.setPointDeVue(pDv1);
		}
		catch (NullPointerException v){
			fail("Erreur : Exception de pointeur null levee");
		}
		assertEquals(v.getPointDeVue() , pDv1);
		
		try{
			v.setPointDeVue(null);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException v){
			assertTrue(true);
		}
	}
	
	@Test
	public void testSetBufferedImage() {
		try {
			v.setBufferedImage(image);
		}
		catch (NullPointerException v){
			fail("Erreur : Exception de pointeur null levee");
		}
		assertEquals(v.getBufferedImage() , image);
		
		try {
			v.setBufferedImage(null);
			fail("Erreur : Exception de pointeur null non levee");
		} 
		catch (NullPointerException v){
			assertTrue(true);
		}
	}
	

	@Test
	public void testSetEcran() {
		try {
			v.setEcran(e1);
		}
		catch (NullPointerException v){
			fail("Erreur : Exception de pointeur null levee");
		}
		assertEquals(v.getEcran() , e1);
		
		try{
			v.setEcran(null);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException v){
			assertTrue(true);
		}
	}

}
