package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import lancerRayon.Lumiere;

import org.junit.Before;
import org.junit.Test;

import util.Point3D;

public class LumiereTest {
	private Lumiere l;
	private Lumiere l1;
	private Color c;
	private Color c1;
	private Point3D p;
	private Point3D p1;

	@Before
	public void setUp() throws Exception {
		p = new Point3D(-3,4,55);
		p1 = new Point3D(893,-4,515);
		c = new Color(43);
		c1 = new Color(42);
		l = new Lumiere (c,p);
		
	}

	@Test
	public void testLumiere() {
		try{
			l= new Lumiere (c,p);
			}
		catch (NullPointerException l){
			fail("Erreur : Exception de pointeur null levee");
		}
		assertEquals(l.getCouleur(),c);
		assertEquals(l.getPosition(),p);
		
		try{
			l= new Lumiere (null,p);
			fail("Erreur : Exception de pointeur null non levee");
			}
		catch (NullPointerException l){
			assertTrue(true);
		}
		
		try{
			l= new Lumiere (c,null);
			fail("Erreur : Exception de pointeur null non levee");
			}
		catch (NullPointerException l){
			assertTrue(true);
		}
		
	}

	@Test
	public void testGetCouleur() {
		assertTrue(l != null);
		assertEquals(l.getCouleur(),c);
	}

	@Test
	public void testGetPosition() {
		assertTrue(l != null);
		assertEquals(l.getPosition(),p);
	}

	@Test
	public void testSetCouleur() {
		try {
			l.setCouleur(c1);
		}
		catch (NullPointerException l){
			fail("Erreur : Exception de pointeur null levee");
			}
		assertEquals(l.getCouleur(),c1);
		
		try {
			l.setCouleur(null);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException l){
				assertTrue(true);
			}
	}

	@Test
	public void testSetPosition() {
		try {
			l.setPosition(p1);
		}
		catch (NullPointerException l){
			fail("Erreur : Exception de pointeur null levee");
			}
		assertEquals(l.getPosition(),p1);
		
		try {
			l.setCouleur(null);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException l){
				assertTrue(true);
			}
	}

	@Test
	public void testEqualsObject() {
		//On compare la lumiere avec elle même
		if (l.equals(l) == true) {	
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
		
        //On compare la lumiere avec null
		if (l.equals(null) == false) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
		
        //On compare la lumiere avec un objet qui n'est pas une lumiere
		if (l.equals(c) == false) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
        
        //On compare la lumiere avec une lumiere identique
        l1 = new Lumiere (c,p);
        if (l.getCouleur() != l1.getCouleur()) {
        	fail("Erreur");
        } else { 
        		if (l.getPosition() != l1.getPosition()) {
        			fail ("Erreur");
        		} else {
        			assertTrue(true);
        		}
        }
	
      //On compare la lumiere avec une lumiere n'ayant pas la meme couleur
        l1 = new Lumiere (c1,p);
        if (l.getCouleur() != l1.getCouleur()) {
        	assertTrue(true);
    	} else {
    			fail ("Erreur");
    		}
    	
      //On compare la lumiere avec une lumiere n'ayant pas la meme position
		l1 = new Lumiere (c,p1);
		if (l.getCouleur() != l1.getCouleur()) {
    	fail("Erreur");
    	} else { 
    		if (l.getPosition() != l1.getPosition()) {
    			assertTrue(true);
    		}
    	}
	}
}
