package tests;

import static org.junit.Assert.*;
import lancerRayon.PointDeVue;

import org.junit.Before;
import org.junit.Test;

import util.Point3D;

public class PointDeVueTest {
	
	private Point3D p;
	private Point3D p1;
	private PointDeVue pt;
	private PointDeVue pt1;

	@Before
	public void setUp() throws Exception {
		p = new Point3D(67,42,98);
		p1 = new Point3D(88,23,43);
		pt = new PointDeVue(p);
	}


	@Test
	public void testPointDeVue() {
		try{
		 pt = new PointDeVue(p);
		}
		catch (NullPointerException p){
			fail("Erreur : Exception de pointeur null leve");
		}
		assertEquals(pt.getPosition(), p);
		
		try{
			 pt = new PointDeVue(null);
			fail("Erreur : Exception de pointeur null non leve"); 
		}
		catch (NullPointerException p){
			assertTrue(true);
		}
	}

	@Test
	public void testGetPosition() {
		assertTrue(pt != null);
		assertEquals(pt.getPosition(), p);
		}

	@Test
	public void testSetPosition() {
		assertTrue(pt != null);
		
		try {
			pt.setPosition(p1);
		}
		catch (NullPointerException p){
			fail("Erreur : Exception de pointeur null leve");
		}
		assertEquals(pt.getPosition(), p1);
		
		try {
			pt.setPosition(null);
			fail("Erreur : Exception de pointeur null non leve");
		}
		catch (NullPointerException p){
			assertTrue(true);
		}
		
	}

	@Test
	public void testEqualsObject() {
		//On compare le Point de Vue avec lui même
		if (pt.equals(pt) == true) {	
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
		
        //On compare le Point de Vue avec null
		if (pt.equals(null) == false) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
		
        //On compare le Point de Vue avec un objet qui n'est pas un Point de Vue
		if (pt.equals(p) == false) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
        
        //On compare le Point de Vue avec un Point de Vue identique
		pt1 = new PointDeVue(p);
        if (pt.getPosition() != pt1.getPosition()) {
        	fail("Erreur");
        } else { 
        			assertTrue(true);
        		}
	
      //On compare le Point de Vue avec un Point de Vue different
        pt1 = new PointDeVue(p1);
        if (pt.getPosition() != pt1.getPosition()) {
   			assertTrue(true);
        } else { 
        	fail("Erreur");
    		}

	}

}
