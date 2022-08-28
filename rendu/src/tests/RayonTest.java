package tests;


import junit.framework.TestCase;
import lancerRayon.Rayon;

import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class RayonTest extends TestCase{

	private Rayon r;
	private Rayon r1;
	private Vecteur3D v;	
	private Point3D a1;
	private Point3D b1;
	private Point3D origine;
	private int a;

	@Override
	public void setUp() {
			a1 = new Point3D(8, 9, 4);
			b1 = new Point3D(95, -4, 0);
			origine = new Point3D(0,0,0);
			try {
				v = new Vecteur3D(a1,b1,origine);
			}
			catch(NullPointerException r){
				fail("Erreur: Exception de pointeur null levee");
			}
			try{
				r = new Rayon(v);
			}
			catch(NullPointerException r){
				fail("Erreur: Exception de pointeur null levee");
			}
			a = 23;
	}

	@Test
	public void testRayon() {
		a1 = new Point3D(8, 9, 4);
		b1 = new Point3D(95, -4, 0);
		origine = new Point3D(0,0,0);
		v = new Vecteur3D(a1,b1,origine);
		r = new Rayon(v);
		try{
			r = new Rayon(v);
		}
		catch(NullPointerException r){
			fail("Erreur: Exception de pointeur nul levee");
		}
		
		try{
			r = new Rayon(null);
			fail("Erreur: Exception de pointeur nul non levee");
		}
		catch(NullPointerException r){
			assertTrue(true);
		}
		
		v = new Vecteur3D(a1,b1);
		try{
			r = new Rayon(v);
			fail("Erreur: Exception de pointeur nul non levee");
		}
		catch(NullPointerException r){
			assertTrue(true);
		}
	}

	@Test
	public void testGetVecteur() {
		assertEquals(r.getVecteur(), v);
	}

	@Test
	public void testGetOrigine() {
		assertEquals(r.getOrigine(), origine);
	}

	@Test
	public void testEqualsObject() {
	       if (r.equals(r) == true) {	
				assertTrue(true);
			}
	        else{
				fail("Erreur");
			}
			
	        if (r.equals(null) == false) {
				assertTrue(true);
			}
	        else{
				fail("Erreur");
			}
	        
	        if (r.equals(a) == false) {
	        	assertTrue(true);
			}
	        else{
				fail("Erreur");
	        }
	       
	    
	        r1 = new Rayon(v);
	        if (r.equals(r1) == true){
	        	assertTrue(true);
	        }
	        
	        r1 = null;
	        if (r.equals(r1) == true){
	        	fail("Erreur");
	        }
	}

}
