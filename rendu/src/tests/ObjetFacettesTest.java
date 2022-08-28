package tests;

import java.awt.Color;
import java.util.ArrayList;

import junit.framework.TestCase;
import lancerRayon.Facette;
import lancerRayon.Matiere;
import lancerRayon.ObjetFacettes;
import lancerRayon.Rayon;

import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class ObjetFacettesTest extends TestCase{

	private ObjetFacettes O1;
	private Matiere m;
	private Rayon R;
	private Facette f0, f1, f2, f3;
	private ArrayList<Facette> listF;
	Point3D P0;
	Point3D P1;
	Point3D P2;
	Point3D P3;
	Point3D ori;
	
	@Override
	public void setUp(){
		m = new Matiere(Color.black, Color.black, Color.black, Color.black, Color.black, 128, 1);
		P0 = new Point3D(1,0,2);
		P1 = new Point3D(1,2,-1);
		P2 = new Point3D(1,-2,-1);
		P3 = new Point3D(3,-2,-1);
		ori = new Point3D(0,0,0);
		f0 = new Facette(m, P0, P1, P2);
		f1 = new Facette(m, P0, P1, P3);
		f2 = new Facette(m, P0, P2, P3);
		f3 = new Facette(m, P1, P2, P3);
		
		listF = new ArrayList<Facette>(4);
		listF.add(0, f0);
		listF.add(1, f1);
		listF.add(2, f2);
		listF.add(3, f3);
		
		O1 = new ObjetFacettes(m, listF);
	}
	
	@Test
	public void testGetRayonTransmis() {
		Point3D ori2 = new Point3D(0,0,-1);
		R = new Rayon(new Vecteur3D(ori2,new Point3D(1,1,-1),ori2));
		Point3D inte = O1.getIntersection(R);
		
		assertEquals(O1.getRayonTransmis(R, inte).getVecteur().getX(), 0.9354143466, 0.0000000001);
		assertEquals(O1.getRayonTransmis(R, inte).getVecteur().getY(), 0.3535533905, 0.0000000001);
		assertEquals(O1.getRayonTransmis(R, inte).getVecteur().getZ(), 0.0);
	}

	@Test
	public void testGetRayonReflechi() {
		R = new Rayon(new Vecteur3D(ori,new Point3D(1,0,1),ori));
		Point3D inte = O1.getIntersection(R);
		
		assertEquals(O1.getRayonReflechi(R, inte),new Rayon(new Vecteur3D(-1/Math.sqrt(2),0,1/Math.sqrt(2),inte)));
	}

	@Test
	public void testGetNormale() {
		R = new Rayon(new Vecteur3D(ori,new Point3D(1,0,0.5),ori));
		Point3D inte = O1.getIntersection(R);
		Vecteur3D N = O1.getNormale(inte);
		
		assertEquals(N, new Vecteur3D(-1,0,0,inte));
	}

	@Test
	public void testGetIntersection() {
		R = new Rayon(new Vecteur3D(ori,new Point3D(2,0,0),ori));
		Point3D inte = O1.getIntersection(R);
		assertEquals(inte ,new Point3D(1,0,0));
		
		Rayon R2 = new Rayon(new Vecteur3D(ori,new Point3D(-1,0,0),ori));
		assertNull(O1.getIntersection(R2));
	}

	@Test
	public void testObjetFacettes() {
		ArrayList<Facette> listF3 = new ArrayList<Facette>(2);
		listF3.add(0, f1);
		listF3.add(1, f3);
		ObjetFacettes O2 = new ObjetFacettes(m, listF3);
		
		assertEquals(O2.getMatiere(), m);
		assertEquals(O2.getListeFacettes(), listF3);
		assertEquals(O2.getNombreFacettes(), 2);
	}

	@Test
	public void testGetFacetteIntersec() {
		R = new Rayon(new Vecteur3D(ori,new Point3D(2,0,0),ori));
		O1.getIntersection(R);
		assertEquals(O1.getFacetteIntersec() ,0);
	}

	@Test
	public void testGetNombreFacettes() {
		assertEquals(O1.getNombreFacettes(), 4);
	}

	@Test
	public void testGetListeFacettes() {
		assertEquals(O1.getListeFacettes(), listF);
	}

	@Test
	public void testSetListeFacettes() {
		ArrayList<Facette> listF2 = new ArrayList<Facette>(4);
		listF2.add(0, f3);
		listF2.add(1, f0);
		listF2.add(2, f2);
		listF2.add(3, f1);
		
		O1.setListeFacettes(listF2);
		assertEquals(O1.getListeFacettes(), listF2);
	}

	@Test
	public void testGetFacetteI() {
		assertEquals(O1.getFacetteI(2).getPoint0(), f2.getPoint0());
		assertEquals(O1.getFacetteI(2).getPoint1(), f2.getPoint1());
		assertEquals(O1.getFacetteI(2).getPoint2(), f2.getPoint2());
	}

	@Test
	public void testSetFacetteI() {
		Facette f4 = new Facette(m, P3, P0, P2);
		O1.setFacetteI(1, f4);
		assertEquals(O1.getFacetteI(1).getPoint0(), f4.getPoint0());
		assertEquals(O1.getFacetteI(1).getPoint1(), f4.getPoint1());
		assertEquals(O1.getFacetteI(1).getPoint2(), f4.getPoint2());
	}

}
