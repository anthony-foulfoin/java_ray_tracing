package tests;

import java.awt.Color;

import junit.framework.TestCase;
import lancerRayon.Matiere;
import lancerRayon.Rayon;
import lancerRayon.Sphere;

import lancerRayon.ValeurNonPositiveException;
import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class SphereTest extends TestCase {
	
	private Point3D c1;
	private Point3D c2;
	private double r1;
	private double r2;
	private Sphere S1;
	private Sphere S2;
	private Matiere m;


	@Override
	public void setUp() throws ValeurNonPositiveException{
		c1 = new Point3D(5, 0, 0);
		c2 = new Point3D(9, 5.4, 6);
		r1 = 2;
		r2 = 6;
		m = new Matiere(Color.black, Color.black, Color.black, Color.black, Color.black, 2.0*64.0, 1.0*64.0);
		try{
			S1 = new Sphere(m, c1, r1);
		}
		catch(ValeurNonPositiveException S1){
			fail("Erreur : Valeur non positive du rayon");
		}
	}
	
	@Test
	public void testGetRayonTransmis() throws ValeurNonPositiveException {
		Point3D p0 = new Point3D(0, 3, 0);
		Point3D p1 = new Point3D(3, 0, 0);
		Rayon R1 = new Rayon(new Vecteur3D(p0, p1, p0));
		
		double Tx = 0.5*((3/Math.sqrt(18))+Math.sqrt(3.5)-3/Math.sqrt(18));
		double Ty = 0.5*(-3/Math.sqrt(18));
		double Tz = 0;
		Rayon trans = new Rayon(new Vecteur3D(Tx, Ty, Tz, p1));
		
		assertEquals(S1.getRayonTransmis(R1, p1).getVecteur().getX(), trans.getVecteur().getX(), 0.000001);
		assertEquals(S1.getRayonTransmis(R1, p1).getVecteur().getY(), trans.getVecteur().getY(), 0.000001);
		assertEquals(S1.getRayonTransmis(R1, p1).getVecteur().getZ(), trans.getVecteur().getZ(), 0.000001);
	
		// test avec un indice de refraction de 1
		m = new Matiere(Color.black, Color.black, Color.black, Color.black, Color.black, 1.0*64.0, 1.0*64.0);
		S1 = new Sphere(m, c1, r1);
		
		// Le rayon transmis doit etre le m�me que le rayon lance
		assertEquals(S1.getRayonTransmis(R1, p1).getVecteur().getX(), R1.getVecteur().getX());
		assertEquals(S1.getRayonTransmis(R1, p1).getVecteur().getY(), R1.getVecteur().getY());
		assertEquals(S1.getRayonTransmis(R1, p1).getVecteur().getZ(), R1.getVecteur().getZ());
	}

	@Test
	public void testGetRayonReflechi() {
		Point3D p1 = new Point3D(0, -3, 0);
		Point3D p2 = new Point3D(1, -2, 0);
		Point3D p3 = new Point3D(3, 0, 0);
		Rayon R1 = new Rayon(new Vecteur3D(p1, p2, p1));
		System.out.println("N= "+S1.getNormale(p3).getX()+" "+S1.getNormale(p3).getY()+" "+S1.getNormale(p3).getZ());
		System.out.println(S1.getRayonReflechi(R1, p3).getVecteur().getX()+" "+S1.getRayonReflechi(R1, p3).getVecteur().getY()+" "+S1.getRayonReflechi(R1, p3).getVecteur().getZ());
		
		Rayon rr = new Rayon(new Vecteur3D(-1,1,0,p3));
		System.out.println("rr= "+rr.getVecteur().getX()+" "+rr.getVecteur().getY()+" "+rr.getVecteur().getZ());
		assertEquals(S1.getRayonReflechi(R1, p3).getVecteur().getX(), rr.getVecteur().getX(), 0.000001);
		assertEquals(S1.getRayonReflechi(R1, p3).getVecteur().getY(), rr.getVecteur().getY(), 0.000001);
		assertEquals(S1.getRayonReflechi(R1, p3).getVecteur().getZ(), rr.getVecteur().getZ(), 0.000001);
	}

	@Test
	public void testGetNormale() {
		Point3D p = new Point3D(3,0,0);
		assertEquals(S1.getNormale(p), new Vecteur3D(-1,0,0,p));
	}

	@Test
	public void testGetIntersection() throws ValeurNonPositiveException {
		Point3D ori1 = new Point3D(0,0,0);
		Point3D p2 = new Point3D(1,0,0);
		Point3D ori2 = new Point3D(0,5,0);
		Point3D inters = new Point3D(3,0,0);
		Rayon R1 = new Rayon(new Vecteur3D(ori1, p2, ori1));
		Rayon R2 = new Rayon(new Vecteur3D(ori1, p2, ori2));
		Rayon R3 = new Rayon(new Vecteur3D(p2, ori1, ori1));
		assertEquals(S1.getIntersection(R1), inters);
		assertNull(S1.getIntersection(R2));
		assertNull(S1.getIntersection(R3));
		
		// new test
		Point3D centreSphere, p3;
		Rayon R4;
		centreSphere = new Point3D(-500, -546, -234);
		try{
			S2 = new Sphere(m, centreSphere, 1);
		}
		catch(ValeurNonPositiveException S2){
			fail("Erreur : Valeur non positive du rayon");
		}
		p3 = new Point3D(60,29,-200);
		R4 = new Rayon(new Vecteur3D(ori1, p3,ori1));
		
		assertNull(S2.getIntersection(R4));
	}

	@Test
	public void testSphere() throws ValeurNonPositiveException {
		try{
			S2 = new Sphere(m, c2, r2);
		}
		catch(ValeurNonPositiveException S2){
			fail("Erreur : Valeur non positive du rayon");
		}
		//Cas ou r negatif :
		try{
			S2 = new Sphere(m, c1, -3);
			fail("Erreur : Exception de rayon negatif non levee");
		}
		catch(ValeurNonPositiveException S1){
			assertTrue(true);
		}
		assertEquals(S2.getMatiere(), m);
		assertEquals(S2.getCentre(), c2);
		assertEquals(S2.getRayon(), r2);
	}

	@Test
	public void testGetCentre() {
		assertEquals(S1.getCentre(), c1);
	}

	@Test
	public void testSetCentre() {
		S1.setCentre(c2);
		assertEquals(S1.getCentre(), c2);
	}

	@Test
	public void testGetRayon() {
		assertEquals(S1.getRayon(), r1);
	}

	@Test
	public void testSetRayon() throws ValeurNonPositiveException {
		S1.setRayon(r2);
		assertEquals(S1.getRayon(), r2);
	}

}
