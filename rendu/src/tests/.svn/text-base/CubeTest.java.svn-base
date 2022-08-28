package tests;

import java.awt.Color;

import junit.framework.TestCase;
import lancerRayon.Cube;
import lancerRayon.Facette;
import lancerRayon.Matiere;
import lancerRayon.Rayon;

import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class CubeTest extends TestCase{
	
	private Cube c1;
	private Point3D P0;
	private Point3D ori;
	private Point3D origine;
	private Vecteur3D v0;
	private Vecteur3D v1;
	private Vecteur3D v2;
	private Matiere m;
	private Rayon R;
	
	@Override
	public void setUp(){
		P0 = new Point3D(2,1,-1);
		v0 = new Vecteur3D(4,0,0);
		v1 = new Vecteur3D(0,4,0);
		v2 = new Vecteur3D(0,0,4);
		m = new Matiere(Color.black, Color.black, Color.black, Color.black, Color.black, 1*64, 1.0*64.0);
		c1 =new Cube(m, P0, v0, v1, v2);
		origine = new Point3D(0,0,0);
	}

	@Test
	public void testGetRayonTransmis() {
		R = new Rayon(new Vecteur3D(1,1,0,origine));
		Point3D inte = c1.getIntersection(R);
		assertEquals(c1.getRayonTransmis(R, inte).getVecteur().getX(), Math.sqrt(2)/2);
		assertEquals(c1.getRayonTransmis(R, inte).getVecteur().getY(), Math.sqrt(2)/2);
		assertEquals(c1.getRayonTransmis(R, inte).getVecteur().getZ(), 0.0);
	}

	@Test
	public void testGetRayonReflechi() {
		R = new Rayon(new Vecteur3D(1,1,0,origine));
		Point3D inte = c1.getIntersection(R);		
		assertEquals(c1.getRayonReflechi(R, inte).getVecteur().getX(), Math.sqrt(2)/2);
		assertEquals(c1.getRayonReflechi(R, inte).getVecteur().getY(), Math.sqrt(2)/2);
		assertEquals(c1.getRayonReflechi(R, inte).getVecteur().getZ(), 0.0);
	}

	@Test
	public void testGetNormale() {
		R = new Rayon(new Vecteur3D(1,1,0,origine));
		Point3D inte = c1.getIntersection(R);
		Vecteur3D N = c1.getNormale(inte);
		
		assertEquals(N, new Vecteur3D(0.0,0.0,-1.0,inte));
	}

	@Test
	public void testGetIntersection() {
		R = new Rayon(new Vecteur3D(1,1,0,origine));
		Point3D inte = c1.getIntersection(R);
		assertEquals(inte ,new Point3D(2.0,2.0,0.0));	
		Rayon R2 = new Rayon(new Vecteur3D(-1,-1,0,origine));
		assertNull(c1.getIntersection(R2));
	}

	@Test
	public void testCube() {
		Cube c2 = new Cube(m, P0, v0, v1, v2);
		
		Point3D p0 = P0;
		Point3D p1 = new Point3D(P0.getX()+v1.getX(), P0.getY()+v1.getY(), P0.getZ()+v1.getZ());
		Point3D p2 = new Point3D(P0.getX()+v1.getX()+v0.getX(), P0.getY()+v1.getY()+v0.getY(), P0.getZ()+v1.getZ()+v0.getZ());
		Point3D p3 = new Point3D(P0.getX()+v0.getX(), P0.getY()+v0.getY(), P0.getZ()+v0.getZ());
		Point3D p4 = new Point3D(P0.getX()+v2.getX(), P0.getY()+v2.getY(), P0.getZ()+v2.getZ());
		Point3D p5 = new Point3D(P0.getX()+v1.getX()+v2.getX(), P0.getY()+v1.getY()+v2.getY(), P0.getZ()+v1.getZ()+v2.getZ());
		Point3D p6 = new Point3D(P0.getX()+v1.getX()+v0.getX()+v2.getX(), P0.getY()+v1.getY()+v0.getY()+v2.getY(), P0.getZ()+v1.getZ()+v0.getZ()+v2.getZ());
		Point3D p7 = new Point3D(P0.getX()+v0.getX()+v2.getX(), P0.getY()+v0.getY()+v2.getY(), P0.getZ()+v0.getZ()+v2.getZ());
		
		assertEquals(c2.getMatiere(), m);
		assertEquals(c2.getFacette(0).getPoint0(), p0);
		assertEquals(c2.getFacette(0).getPoint1(), p1);
		assertEquals(c2.getFacette(0).getPoint2(), p3);
		
		assertEquals(c2.getFacette(1).getPoint0(), p1);
		assertEquals(c2.getFacette(1).getPoint1(), p2);
		assertEquals(c2.getFacette(1).getPoint2(), p3);
		
		assertEquals(c2.getFacette(2).getPoint0(), p0);
		assertEquals(c2.getFacette(2).getPoint1(), p3);
		assertEquals(c2.getFacette(2).getPoint2(), p4);
		
		assertEquals(c2.getFacette(3).getPoint0(), p3);
		assertEquals(c2.getFacette(3).getPoint1(), p4);
		assertEquals(c2.getFacette(3).getPoint2(), p7);
		
		assertEquals(c2.getFacette(4).getPoint0(), p0);
		assertEquals(c2.getFacette(4).getPoint1(), p1);
		assertEquals(c2.getFacette(4).getPoint2(), p4);
		
		assertEquals(c2.getFacette(5).getPoint0(), p1);
		assertEquals(c2.getFacette(5).getPoint1(), p4);
		assertEquals(c2.getFacette(5).getPoint2(), p5);
		
		assertEquals(c2.getFacette(6).getPoint0(), p1);
		assertEquals(c2.getFacette(6).getPoint1(), p2);
		assertEquals(c2.getFacette(6).getPoint2(), p5);
		
		assertEquals(c2.getFacette(7).getPoint0(), p2);
		assertEquals(c2.getFacette(7).getPoint1(), p5);
		assertEquals(c2.getFacette(7).getPoint2(), p6);
		
		assertEquals(c2.getFacette(8).getPoint0(), p2);
		assertEquals(c2.getFacette(8).getPoint1(), p3);
		assertEquals(c2.getFacette(8).getPoint2(), p6);
		
		assertEquals(c2.getFacette(9).getPoint0(), p3);
		assertEquals(c2.getFacette(9).getPoint1(), p6);
		assertEquals(c2.getFacette(9).getPoint2(), p7);
		
		assertEquals(c2.getFacette(10).getPoint0(), p4);
		assertEquals(c2.getFacette(10).getPoint1(), p5);
		assertEquals(c2.getFacette(10).getPoint2(), p6);
		
		assertEquals(c2.getFacette(11).getPoint0(), p4);
		assertEquals(c2.getFacette(11).getPoint1(), p6);
		assertEquals(c2.getFacette(11).getPoint2(), p7);
	}

	@Test
	public void testGetFacetteIntersec() {
		R = new Rayon(new Vecteur3D(1,1,0,origine));
		c1.getIntersection(R);
		assertEquals(c1.getFacetteIntersec() ,0);
	}
	
	@Test
	public void testGetFacette() {
		Facette f = new Facette(m, new Point3D(2,1,-1), new Point3D(2,1,3), new Point3D(2,5,-1));
		assertEquals(f.getPoint0(), c1.getFacette(0).getPoint0());
		assertEquals(f.getPoint0(), c1.getFacette(4).getPoint0());
		assertEquals(f.getPoint0(), c1.getFacette(2).getPoint0());
	}

	@Test
	public void testGetMatiere() {
		//assertEquals(m,new Matiere(Color.black, Color.black, Color.black, Color.black, Color.black, 2, 1));
		assertEquals(c1.getMatiere().getAbsAmb(),Color.black);
		assertEquals(c1.getMatiere().getAbsDif(),Color.black);
		assertEquals(c1.getMatiere().getSpeculaire(),Color.black);
		assertEquals(c1.getMatiere().getReflection(),Color.black);
		assertEquals(c1.getMatiere().getRefraction(),Color.black);
		assertEquals(c1.getMatiere().getIndiceRefraction(),1.0);
		assertEquals(c1.getMatiere().getBrillance(),1.0);
	}

	@Test
	public void testSetMatiere() {
		Matiere m2 = new Matiere(Color.blue, Color.blue, Color.blue, Color.blue, Color.blue, 5.0*64.0, 3.0*64.0);
		c1.setMatiere(m2);
		assertEquals(c1.getMatiere().getAbsAmb(),Color.blue);
		assertEquals(c1.getMatiere().getAbsDif(),Color.blue);
		assertEquals(c1.getMatiere().getSpeculaire(),Color.blue);
		assertEquals(c1.getMatiere().getReflection(),Color.blue);
		assertEquals(c1.getMatiere().getRefraction(),Color.blue);
		assertEquals(c1.getMatiere().getIndiceRefraction(),5.0);
		assertEquals(c1.getMatiere().getBrillance(),3.0);
	}

}
