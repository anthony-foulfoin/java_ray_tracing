package tests;
 
import junit.framework.TestCase;

import org.junit.Test;

import util.Point3D;

public class PointTest extends TestCase{
	
	private Point3D a;
	private Point3D b;
	private Point3D c;
	private int n;
	
	@Override
	public void setUp() {
		
			a = new Point3D(1.5, 56, 12);
			b = new Point3D(1.5, 56, 12);
			c = new Point3D(15, 6, 192);
			n=98;
	}


	@Test
	public void testPoint3D() {
		a = new Point3D(5,-78,1.78);
		assertEquals(a.getX(), 5.0);
		assertEquals(a.getY(), -78.0);
		assertEquals(a.getZ(), 1.78);
	}

	@Test
	public void testGetX() {
		assertEquals(a.getX(), 1.5);
	}

	@Test
	public void testGetY() {
		assertEquals(a.getY(), 56.0);
	}

	@Test
	public void testGetZ() {
		assertEquals(a.getZ(), 12.0);
	}

	@Test
	public void testSetX() {
		a.setX(-780);
		assertEquals(a.getX(), -780.0);
	}

	@Test
	public void testSetY() {
		a.setY(-7);
		assertEquals(a.getY(), -7.0);
	}

	@Test
	public void testSetZ() {
		a.setZ(18);
		assertEquals(a.getZ(), 18.0);
	}

	@Test
	public void testEqualsObject() {
        if (a.equals(a) == true) {	
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
		
        if (a.equals(null) == false) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
        
        if (a.equals(b) == true) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
		
        if (a.equals(c) == false) {
			assertTrue(true);
		}
        else{
			fail("Erreur");
		}
        
        if (a.equals(n) == false) {
        	assertTrue(true);
		}
        else{
			fail("Erreur");
        }
        
	}

}
