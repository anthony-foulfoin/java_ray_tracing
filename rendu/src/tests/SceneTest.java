package tests;
import java.awt.Color;

import junit.framework.TestCase;
import lancerRayon.Ecran;
import lancerRayon.Lumiere;
import lancerRayon.Matiere;
import lancerRayon.NonOrthogonalException;
import lancerRayon.PointDeVue;
import lancerRayon.Scene;
import lancerRayon.Sphere;
import lancerRayon.ValeurNonPositiveException;
import lancerRayon.Vue;

import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;


public class SceneTest extends TestCase{
	
	private Color c;
	private Color c1;
	private Color c2;
	private Color c3;
	private Color c4;
	private Scene s;
	private Vue v;
	private Vue vbis;
	private PointDeVue p;
	private PointDeVue pbis;
	private Ecran e;
	private Point3D a;
	private Vecteur3D v1;
	private Vecteur3D v2;
	private Point3D b;
	private Point3D a1;
	private Point3D a2;
	private Point3D b1;
	private Point3D b2;
	private Lumiere l;
	private Lumiere lbis;
	private Matiere m;
	private double temp;
	private double temp2;
	private Sphere sph;
	private Sphere sph2;
	private int id;
	
	@Override
	public void setUp() throws ValeurNonPositiveException {
		a = new Point3D(1,1,1);
		b = new Point3D(4,3,2);
		a1 = new Point3D(0,0,0);
		a2 = new Point3D(0,1,0);
		b2 = new Point3D(3,0,0);
		v1 = new Vecteur3D(a1, a2);
		v2 = new Vecteur3D(a1, b2);
		c = new Color(5);
		c1 = new Color(7);
		c2 = new Color(10);
		c3 = new Color(22);
		c4 = new Color(45);
		m = new Matiere(c, c1, c2, c3, c4, 15, 20);
		b1 = new Point3D(1,1,1);
		l = new Lumiere(c,b1);
		lbis = new Lumiere(c1,b2);
		sph = new Sphere(m, b, 2);
		sph2 = new Sphere(m, a, 5);
		
		try{
			e = new Ecran(v1, v2, b, 10, 20);
		}	
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de valeur non positive levee");
		}
		catch(NonOrthogonalException e){
			fail("Erreur : Exception de non-orthogonalite levee");
		}
		p = new PointDeVue(a);
		pbis = new PointDeVue(b);
		v = new Vue(p, e);
		vbis = new Vue (pbis, e);
		
		try{
			s = new Scene(c);
		}	
		catch(NullPointerException s){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		
//	 Cas c=null
		try{
			s = new Scene(null);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException s){
			assertTrue(true);
		}	
	}
	
// Test creation Scene
	public void testScene() {
		try{
			s = new Scene(c);
		}	
		catch(NullPointerException s){
			fail("Erreur : Exception de pointeur null leve");
		}
	
//	 Cas c=null
		try{
			s = new Scene(null);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException s){
			assertTrue(true);
		}
	}

	@Test
	public void testAddVue() {
		try{
			temp = s.getVuesValues().size();
			id = s.addVue(v);
			temp2 = s.getVuesValues().size();
			assertEquals(temp+1,temp2);
			assertEquals(v,s.getVue(id));
		}	
		catch(NullPointerException s){
				fail("Erreur : Exception de pointeur null leve");
		}
		
		try{
			s.addVue(null);
			fail("Erreur : Exception de pointeur null leve");
		}	
		catch(NullPointerException s){
			assertTrue(true);
		}
	}


	@Test
	public void testGetVue() {
		assertTrue(s != null);
		assertEquals(s.getVue(s.addVue(v)), v);
	}

	@Test
	public void testSupprimerVue() {
		id = s.addVue(v);
		temp = s.getVuesValues().size();
		s.supprimerVue(id);
		temp2 = s.getVuesValues().size();
		assertEquals(temp, temp2+1);
	}

	@Test
	public void testAddLumiere() {
		try{
			temp = s.getLumieresValues().size();
			id = s.addLumiere(l);
			temp2 = s.getLumieresValues().size();
			assertEquals(temp+1,temp2);
			assertEquals(l,s.getLumiere(id));
		}	
		catch(NullPointerException s){
				fail("Erreur : Exception de pointeur null leve");
		}
		
		try{
			s.addLumiere(null);
			fail("Erreur : Exception de pointeur null leve");
		}	
		catch(NullPointerException s){
			assertTrue(true);
		}
	}

	@Test
	public void testGetLumiere() {
		assertTrue(s != null);
		assertEquals(s.getLumiere(s.addLumiere(l)),l);
	}

	@Test
	public void testSupprimerLumiere() {
		id = s.addLumiere(l);
		temp = s.getLumieresValues().size();
		s.supprimerLumiere(id);
		temp2 = s.getLumieresValues().size();
		assertEquals(temp, temp2+1);
	}

	@Test
	public void testAddObjet() {
		try{
			s.addObjet(sph);
		}	
		catch(NullPointerException s){
				fail("Erreur : Exception de pointeur null leve");
		}
		
		try{
			s.addObjet(null);
			fail("Erreur : Exception de pointeur null leve");
		}	
		catch(NullPointerException s){
			assertTrue(true);
		}
	}

	@Test
	public void testGetObjet() {
		assertTrue(s != null);
		assertEquals(s.getObjet(s.addObjet(sph)),sph);
	}

	@Test
	public void testSupprimerObjet() {
		id = s.addObjet(sph);
		temp = s.getObjetsValues().size();
		s.supprimerObjet(id);
		temp2 = s.getObjetsValues().size();
		assertEquals(temp, temp2+1);
	}

	@Test
	public void testGetObjets() {
		s.addObjet(sph);
		s.addObjet(sph2);
		assertTrue(s != null);
		assertEquals(s.getObjetsValues().size(), 2);
	}

	@Test
	public void testGetLumieres() {
		s.addLumiere(l);
		s.addLumiere(lbis);
		assertTrue(s != null);
		assertEquals(s.getLumieresValues().size(), 2);
	}

	@Test
	public void testGetVues() {
		s.addVue(v);
		s.addVue(vbis);
		assertTrue(s != null);
		assertEquals(s.getVuesValues().size(), 2);
	}

	@Test
	public void testGetLumiereAmbiante() {
		assertTrue(s != null);
		assertEquals(s.getLumiereAmbiante(),c);
	}

	@Test
	public void testSetLumiereAmbiante() {
		try{
			s.setLumiereAmbiante(c1);
		}
		catch (NullPointerException s){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(c1, s.getLumiereAmbiante());
		
		// a2 est null
		try{
			s.setLumiereAmbiante(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException s){
			assertTrue(true);		
		}
	}

}
