package tests;

import java.awt.Color;

import junit.framework.TestCase;
import lancerRayon.Matiere;
import lancerRayon.Plan;
import lancerRayon.Rayon;

import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class PlanTest extends TestCase{

	private Matiere m;
	private Plan Pl1;
	private Point3D P0;
	private Point3D P1;
	private Point3D P2;
	private Point3D origine;
	
	@Override
	public void setUp(){
		m = new Matiere(Color.black, Color.black, Color.black, Color.black, Color.black, 2.0*64.0, 1.0*64.0);
		P0 = new Point3D(2,0,0);
		P1 = new Point3D(2,1,0);
		P2 = new Point3D(2,0,1);
		Pl1 = new Plan(m, P0, P1, P2);
		origine = new Point3D(0,0,0);
	}
	
	@Test
	public void testGetRayonTransmis() {
		Rayon R = new Rayon(new Vecteur3D(origine,new Point3D(1,1,0),origine));
		Point3D inte = Pl1.getIntersection(R);
		assertEquals(Pl1.getRayonTransmis(R, inte).getVecteur().getX(), 0.9354143466, 0.0000000001);
		assertEquals(Pl1.getRayonTransmis(R, inte).getVecteur().getY(), 0.3535533905, 0.0000000001);
		assertEquals(Pl1.getRayonTransmis(R, inte).getVecteur().getZ(), 0.0);
	}

	@Test
	public void testGetRayonReflechi() {
		Point3D p1 = new Point3D(0, -2, 0);
		Rayon R1 = new Rayon(new Vecteur3D(p1, P0, p1));
		
		System.out.println(Pl1.getRayonReflechi(R1, P0).getVecteur().getX()+" "+Pl1.getRayonReflechi(R1, P0).getVecteur().getY()+" "+Pl1.getRayonReflechi(R1, P0).getVecteur().getZ());
		Rayon Rr = new Rayon(new Vecteur3D(-1,1,0,P0));
		assertEquals(Pl1.getRayonReflechi(R1, P0).getVecteur().getX(), Rr.getVecteur().getX(), 0.000000000000001);
		assertEquals(Pl1.getRayonReflechi(R1, P0).getVecteur().getY(), Rr.getVecteur().getY(), 0.000000000000001);
		assertEquals(Pl1.getRayonReflechi(R1, P0).getVecteur().getZ(), Rr.getVecteur().getZ(), 0.000000000000001);
	}

	@Test
	public void testGetNormale() {
		assertEquals(Pl1.getNormale(P0), new Vecteur3D(1,0,0,P0));
	}

	@Test
	public void testGetIntersection() {
		Point3D pv1 = new Point3D(0, -1, 0);
		Point3D pv2 = new Point3D(1, -1, 0);
		Point3D pv3 = new Point3D(1, 1, 0);
		Point3D pv4 = new Point3D(0, -1, 1);
		Rayon R1 = new Rayon(new Vecteur3D(pv1, pv2, pv1));
		Rayon R2 = new Rayon(new Vecteur3D(pv1, pv3, pv1));
		Rayon R3 = new Rayon(new Vecteur3D(pv2, pv1, pv1));
		Rayon R4 = new Rayon(new Vecteur3D(pv1, pv4, pv1));
		
		assertEquals(Pl1.getIntersection(R1), new Point3D(2,-1,0));
		assertEquals(Pl1.getIntersection(R2), new Point3D(2,3,0));
		assertNull(Pl1.getIntersection(R3));
		assertNull(Pl1.getIntersection(R4));
	}

	@Test
	public void testPlan() {
		Plan Pl2 = new Plan(m, P1, P2, P0);
		assertEquals(Pl2.getMatiere(), m);
		assertEquals(Pl2.getP0(), P1);
		assertEquals(Pl2.getP1(), P2);
		assertEquals(Pl2.getP2(), P0);
	}

	@Test
	public void testGetP0() {
		assertEquals(Pl1.getP0(),P0);
	}

	@Test
	public void testSetP0() {
		Pl1.setP0(8, 32, 4);
		assertEquals(Pl1.getP0(), new Point3D(8,32,4));
	}

	@Test
	public void testGetP1() {
		assertEquals(Pl1.getP1(),P1);
	}

	@Test
	public void testSetP1() {
		Pl1.setP1(8, 32, 4);
		assertEquals(Pl1.getP1(), new Point3D(8,32,4));
	}

	@Test
	public void testGetP2() {
		assertEquals(Pl1.getP2(),P2);
	}

	@Test
	public void testSetP2() {
		Pl1.setP2(8, 32, 4);
		assertEquals(Pl1.getP2(), new Point3D(8,32,4));
	}

}
