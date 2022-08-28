package tests;
import junit.framework.TestCase;
import util.Point3D;
import util.Vecteur3D;


public class Vecteur3DTest extends TestCase {
	
	private Vecteur3D v;
	private Vecteur3D v2;
	private Vecteur3D v3;
	private Point3D a1;
	private Point3D b1;
	private Point3D a2;
	private Point3D b2;
	private Point3D origine;
	private double a;
	private double b;
	private double c;
		
	public void setUp() {
		
		a1 = new Point3D(1.5, 0, 0);
		b1 = new Point3D(-1.5, 0, 0);
		a2 = new Point3D(2, 2, 0);
		b2 = new Point3D(1, 3, 0);
		origine = new Point3D(0,0,0);
		a = 5;
		b= 0;
		c = 0;
		
		try{
			v = new Vecteur3D(a1, b1, origine);
		}	
		catch(NullPointerException v){
			fail("Erreur : Exception de pointeur null leve");
		}
		try{
			v2 = new Vecteur3D(a2, b2, origine);
		}	
		catch(NullPointerException v){
			fail("Erreur : Exception de pointeur null leve");
		}
		try{
			v3 = new Vecteur3D(a, b, c, origine);
		}	
		catch(NullPointerException v){
				fail("Erreur : Exception de pointeur null leve");
		}
	}

		// Cas où le vecteur est defini par 2 points et une origine
	public void testVecteur3DPoint3DPoint3DPoint3D() {
		
		try{
			v = new Vecteur3D(a1, b1, origine);
		}	
		catch(NullPointerException v){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		// Cas a1=null
		try{
			v = new Vecteur3D(null, b1, origine);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException v){
			assertTrue(true);
		}
		
		// Cas b1=null
		try{
			v = new Vecteur3D(a1, null, origine);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException v){
			assertTrue(true);
		}
		
		// Cas origine=null
		try{
			v = new Vecteur3D(a1, b1, null);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException v){
			assertTrue(true);
		}
	}

			
		// Cas où le vecteur est defini par 2 points
	public void testVecteur3DPoint3DPoint3D() {
		try{
			v = new Vecteur3D(a1, b1);
		}	
		catch(NullPointerException v){
				fail("Erreur : Exception de pointeur null leve");
		}
		// Cas a1=null
		try{
			v = new Vecteur3D(null, b1);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException v){
			assertTrue(true);
		}
		
		// Cas b1=null
		try{
			v = new Vecteur3D(a1, null);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException v){
			assertTrue(true);
		}
	}
		
		// Cas où le vecteur est defini par ses coordonnees et une origine
	public void testVecteur3DDoubleDoubleDoublePoint3D() {
		try{
			v = new Vecteur3D(5, 0, 0, origine);
		}	
		catch(NullPointerException v){
				fail("Erreur : Exception de pointeur null leve");
		}
		
		// Cas origine=null
		try{
			v = new Vecteur3D(5, 0, 0, null);
			fail("Erreur de pointeur null non leve");
		}	
		catch(NullPointerException v){
			assertTrue(true);
		}
	}
			

	public void testGetProduitScalaire() {
		try{
			v.getProduitScalaire(v2);
		}	
		catch(NullPointerException v){
				fail("Erreur : Exception de pointeur null leve");
		}
		assertTrue(v != null);
		assertEquals(3.0, v.getProduitScalaire(v2));
		
		// v2 est null
		try{
			v.getProduitScalaire(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException v){
			assertTrue(true);
		}
		
	}

	public void testGetNorme() {
		assertTrue(v != null);
		assertEquals(3.0, v.getNorme());
	}
	
	public void testNormaliser(){
		v.normaliser();
		assertEquals(1.0, v.getNorme());
	}

	public void testGetCosinus() {
		try{
			v.getCosinus(v2);
		}	
		catch(NullPointerException v){
				fail("Erreur : Exception de pointeur null leve");
		}
		
		assertTrue(v != null);
		assertTrue(v2 != null);
		assertEquals(1/Math.sqrt(2), v.getCosinus(v2));
		
		// v2 est null
		try{
			v.getProduitScalaire(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException v){
			assertTrue(true);
		}
		
	}

	public void testGetA() {
		assertTrue(v != null);
		assertTrue(v.getA() != null);
		assertEquals(a1, v.getA());
	}

	public void testGetB() {
		assertTrue(v != null);
		assertTrue(v.getB() != null);
		assertEquals(b1, v.getB());
	}

	public void testGetX() {
		assertTrue(v3 != null);
		assertEquals(a, v3.getX());
	}

	public void testGetY() {
		assertTrue(v3 != null);
		assertEquals(b, v3.getY());
	}

	public void testGetZ() {
		assertTrue(v3 != null);
		assertEquals(c, v3.getZ());
	}

	public void testGetOrigine() {
		assertTrue(v != null);
		assertTrue(v.getOrigine() != null);
		assertEquals(origine, v.getOrigine());
	}

	public void testSetOrigine() {
		try{
			v.setOrigine(a2);
		}
		catch (NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		assertEquals(a2, v.getOrigine());
		
		// a2 est null
		try{
			v.setOrigine(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException e){
			assertTrue(true);		
		}
	}
}
