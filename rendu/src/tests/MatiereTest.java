package tests;

import java.awt.Color;

import junit.framework.TestCase;
import lancerRayon.IndiceIncorrectException;
import lancerRayon.Matiere;

import org.junit.Test;

public class MatiereTest extends TestCase{
	
	private Matiere m;
	private Color c1;
	private Color c2;
	private Color c3;
	private Color c4;
	private Color c5;
	
	
	public void setUp() {
		c1 = new Color(12);
		c2 = new Color(32);
		c3 = new Color(44);
		c4 = new Color(56);
		c5 = new Color(79);
		try{
			m = new Matiere(c1, c2, c3, c4, c5, 20, 30);
		}	
		catch(IndiceIncorrectException m){
			
			fail("Erreur : Exception d'indice incorrect levee");
		}
		
	}

	@Test
	public void testMatiere() {
		try{
			System.out.println(c1);
			m = new Matiere(c1, c2, c3, c4, c5, 20, 30);
		}	
		catch(IndiceIncorrectException m){
			System.out.println("erreur");
			fail("Erreur : Exception d'indice incorrect levee");
		}
		
		//Cas ou c1=null
		try{
			m = new Matiere(null, c2, c3, c4, c5, 20, 30);
			fail("Erreur : Exception d'indice incorrect non levee");
		}	
		catch(IndiceIncorrectException m){
			assertTrue(true);
		}
		
		//Cas ou c2=null
		try{
			m = new Matiere(c1, null, c3, c4, c5, 20, 30);
			fail("Erreur : Exception d'indice incorrect non levee");
		}	
		catch(IndiceIncorrectException m){
			assertTrue(true);
		}
		
		//Cas ou c3=null
		try{
			m = new Matiere(c1, c2, null, c4, c5, 20, 30);
			fail("Erreur : Exception d'indice incorrect non levee");
		}	
		catch(IndiceIncorrectException m){
			assertTrue(true);
		}
		
		//Cas ou c4=null
		try{
			m = new Matiere(c1, c2, c3, null, c5, 20, 30);
			fail("Erreur : Exception d'indice incorrect non levee");
		}	
		catch(IndiceIncorrectException m){
			assertTrue(true);
		}
		
		//Cas ou c5=null
		try{
			m = new Matiere(c1, c2, c3, c4, null, 20, 30);
			fail("Erreur : Exception d'indice incorrect non levee");
		}	
		catch(IndiceIncorrectException m){
			assertTrue(true);
		}
	}

	@Test
	public void testGetAbsAmb() {
		assertTrue(m != null);
		assertEquals(c1, m.getAbsAmb());
	}

	@Test
	public void testSetAbsAmb() {
		try{
			m.setAbsAmb(c2);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(c2, m.getAbsAmb());
		
		// c2 est null
		try{
			m.setAbsAmb(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException m){
			assertTrue(true);		
		}
	}

	@Test
	public void testGetAbsDif() {
		assertTrue(m != null);
		assertEquals(c2, m.getAbsDif());
	}

	@Test
	public void testSetAbsDif() {
		try{
			m.setAbsDif(c1);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(c1, m.getAbsDif());
		
		// c1 est null
		try{
			m.setAbsDif(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException m){
			assertTrue(true);		
		}
	}

	@Test
	public void testGetReflection() {
		assertTrue(m != null);
		assertEquals(c4, m.getReflection());
	}

	@Test
	public void testSetReflection() {
		try{
			m.setReflection(c1);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(c1, m.getReflection());
		
		// c1 est null
		try{
			m.setReflection(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException m){
			assertTrue(true);		
		}
	}

	@Test
	public void testGetRefraction() {
		assertTrue(m != null);
		assertEquals(c5, m.getRefraction());
	}

	@Test
	public void testSetRefraction() {
		try{
			m.setRefraction(c1);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(c1, m.getRefraction());
		
		// c1 est null
		try{
			m.setRefraction(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException m){
			assertTrue(true);		
		}
	}

	@Test
	public void testGetSpeculaire() {
		assertTrue(m != null);
		assertEquals(c3, m.getSpeculaire());
	}

	@Test
	public void testSetSpeculaire() {
		try{
			m.setSpeculaire(c1);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(c1, m.getSpeculaire());
		
		// c1 est null
		try{
			m.setSpeculaire(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException m){
			assertTrue(true);		
		}
	}

	@Test
	public void testGetBrillance() {
		assertTrue(m != null);
		assertEquals(30.0/64, m.getBrillance());
	}

	@Test
	public void testSetBrillance() {
		try{
			m.setBrillance(55);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(55.0/64.0, m.getBrillance());	
	}

	@Test
	public void testGetIndiceRefraction() {
		assertTrue(m != null);
		assertEquals(20.0/64, m.getIndiceRefraction());
	}

	@Test
	public void testSetIndiceRefraction() {
		try{
			m.setIndiceRefraction(66);
		}
		catch (NullPointerException m){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(66.0/64.0, m.getIndiceRefraction());	
	}
}
