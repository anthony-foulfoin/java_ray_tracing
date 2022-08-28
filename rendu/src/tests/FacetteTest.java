package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Color;

import lancerRayon.Facette;
import lancerRayon.Matiere;
import lancerRayon.Rayon;

import org.junit.Before;
import org.junit.Test;

import util.Point3D;
import util.Vecteur3D;

public class FacetteTest {
	
	private Point3D P0;
	private Point3D P1;
	private Point3D P2;
	private Point3D pt;
	private Point3D p;
	private Matiere m;
	
	private Point3D a;
	private Point3D b;
	private Point3D origine;
	
	private Vecteur3D v;
	private Vecteur3D N;
	private Vecteur3D vr;
	private Rayon i;
	private Rayon r;
	private Rayon r1;
	private Color ambiante;
	private Color diffuse;
	private Color speculaire;

	private Color reflection;
	private Color refraction;
	
	private double indiceRefraction;
	private double Tx;
	private double Ty;
	private double Tz;

	
	
	private double brillance;
	
	private Facette f;

	
	@Before
	public void setUp(){
        P0 = new Point3D(9,7,-4);
        P1 = new Point3D(-78.6,46,0);
        P2 = new Point3D(65,4.2,-74);
        p = new Point3D(73.2,0.2,-4);
        a =new Point3D(7,-7,7);
        b =new Point3D(8,8,8);
        origine =new Point3D(0,0,0);
        v= new Vecteur3D(a,b,origine);
        i= new Rayon(v);
        ambiante = new Color(88);
        diffuse = new Color(45);
        speculaire = new Color(69);
        reflection = new Color(12);
        refraction = new Color(64);
        indiceRefraction= 565;
        brillance = 256;
        m = new Matiere(ambiante,diffuse,speculaire,reflection,refraction,indiceRefraction,brillance);
		f = new Facette(m,P0,P1,P2);		
	}
	
	@Test
	public void testFacette() {
			f = new Facette(m,P0,P1,P2);
			assertTrue(f != null);
			assertEquals(f.getPoint0(), P0);
			assertEquals(f.getPoint1(), P1);
			assertEquals(f.getPoint2(), P2);
	}

	
	@Test
	public void testGetRayonTransmis() {
		r = f.getRayonTransmis(i,p);
	    N = f.getNormale(p);
		double ps = i.getVecteur().getProduitScalaire(N);
		double ind = f.getMatiere().getIndiceRefraction();
		
		Tx = (1/ind)*(i.getVecteur().getX()-(ps+Math.sqrt(ind*ind+ps*ps-1))*N.getX());
		Ty = (1/ind)*(i.getVecteur().getY()-(ps+Math.sqrt(ind*ind+ps*ps-1))*N.getY());
		Tz = (1/ind)*(i.getVecteur().getZ()-(ps+Math.sqrt(ind*ind+ps*ps-1))*N.getZ());		
		System.out.println(Tx+" "+Ty+" "+Tz);
		
		Vecteur3D trans = new Vecteur3D(Tx, Ty, Tz, p);
		
		r1 = new Rayon(trans);
		assertEquals(r1,r);
		
		//Calculs manuels
		assertEquals(ind,565/64);
		//assertEquals(ps,-6191.046447);
		assertEquals(ps,i.getVecteur().getX()*N.getX()+i.getVecteur().getY()*N.getY()+i.getVecteur().getZ()*N.getZ());
		assertEquals(i.getVecteur().getX(), 1/Math.sqrt(227));
		assertEquals(i.getVecteur().getY(), 15/Math.sqrt(227));
		assertEquals(i.getVecteur().getZ(), 1/Math.sqrt(227));
		System.out.println(Tx+" "+Ty+" "+Tz);
		assertEquals(Tx,0.4000964001);
		assertEquals(Ty,0.8709232971);
		assertEquals(Tz,0.2853341644);

	}

	@Test
	public void testGetRayonReflechi() {
		r = f.getRayonReflechi (i,p);
		Vecteur3D N = f.getNormale(p);
		double ps = 2*i.getVecteur().getProduitScalaire(N);
		double Rx = i.getVecteur().getX()-ps*N.getX();
		double Ry = i.getVecteur().getY()-ps*N.getY();
		double Rz = i.getVecteur().getZ()-ps*N.getZ();
		
		Vecteur3D refl = new Vecteur3D(Rx, Ry, Rz, p);
		r1= new Rayon(refl);
		assertEquals(r1,r);
		
		//Calculs manuels
		//assertEquals(ps,2*(-6191.046447));
		assertEquals(ps,2*(i.getVecteur().getX()*N.getX()+i.getVecteur().getY()*N.getY()+i.getVecteur().getZ()*N.getZ()));
		assertEquals(i.getVecteur().getX(), 1/Math.sqrt(227));
		assertEquals(i.getVecteur().getY(), 15/Math.sqrt(227));
		assertEquals(i.getVecteur().getZ(), 1/Math.sqrt(227));
		assertEquals(Rx,-0.6645896583);
		assertEquals(Ry,-0.5928082125);
		assertEquals(Rz,-0.4548615288);
	}

	@Test
	public void testGetNormale() {
		vr = f.getNormale(p);
		
		Vecteur3D P0P1 = new Vecteur3D(P0, P1, P0);
		Vecteur3D P0P2 = new Vecteur3D(P0, P2, P0);
	
		double Nx = P0P1.getY()*P0P2.getZ()-P0P1.getZ()*P0P2.getY();
		double Ny = P0P1.getZ()*P0P2.getX()-P0P1.getX()*P0P2.getZ();
		double Nz = P0P1.getX()*P0P2.getY()-P0P1.getY()*P0P2.getX();
		double normeN = Math.sqrt(Nx*Nx+Ny*Ny+Nz*Nz);
	
		v= new Vecteur3D(Nx/normeN, Ny/normeN, Nz/normeN);
		//assertEquals(v,vr);
		assertEquals(v.getX(),vr.getX());
		assertEquals(v.getY(),vr.getY());
		assertEquals(v.getZ(),vr.getZ());
		
		//Calculs manuels
		assertEquals(Nx,-2718.8);
		assertEquals(Ny,-5908);
		assertEquals(Nz,-1938.72);
		v= new Vecteur3D(-2718.8/6786.38, -5908/6786.38, -1938.72/6786.38);
		assertEquals(v.getX(),vr.getX(),0.000001);
		assertEquals(v.getY(),vr.getY(),0.000001);
		assertEquals(v.getZ(),vr.getZ(),0.000001);
		
	}

	@Test
	public void testGetIntersection() {
		vr = new Vecteur3D(2,6,9);
		vr.setOrigine(origine);
		r1 = new Rayon(vr);
		p = f.getIntersection(r1);
		
		double a1 = P1.getX()-P0.getX();
		double a2 = P1.getY()-P0.getY();
		double a3 = P1.getZ()-P0.getZ();
		
		double b1 = P2.getX()-P0.getX();
		double b2 = P2.getY()-P0.getY();
		double b3 = P2.getZ()-P0.getZ();
		
		double c1 = -r1.getVecteur().getX();
		double c2 = -r1.getVecteur().getY();
		double c3 = -r1.getVecteur().getZ();
		
		double d1 = r1.getOrigine().getX()-P0.getX();
		double d2 = r1.getOrigine().getY()-P0.getY();
		double d3 = r1.getOrigine().getZ()-P0.getZ();
		
		double det=a1*(b2*c3-c2*b3)-b1*(a2*c3-a3*c2)+c1*(a2*b3-a3*b2);
		if(det==0){
			p = null;
		}else{
			double alpha=(d1*(b2*c3-c2*b3)-b1*(d2*c3-d3*c2)+c1*(d2*b3-d3*b2))/(det);
			double beta=(a1*(d2*c3-c2*d3)-d1*(a2*c3-a3*c2)+c1*(a2*d3-a3*d2))/(det);
			
			if((0<=alpha) && (alpha<=1) && (0<=beta) && (beta<=(1-alpha))){
				double gamma=(a1*(b2*d3-d2*b3)-b1*(a2*d3-a3*d2)+d1*(a2*b3-a3*b2))/(det);
				if(gamma>=0.1f){
					double Px = r1.getOrigine().getX() + gamma*r1.getVecteur().getX();
					double Py = r1.getOrigine().getY() + gamma*r1.getVecteur().getY();
					double Pz = r1.getOrigine().getZ() + gamma*r1.getVecteur().getZ();
					p = new Point3D(Px, Py, Pz);
				}else{
					p = null;
				}
			}else{
				p = null;
			}
		}
		assertEquals(p,pt);
	
	}


	@Test
	public void testGetPoint0() {
		assertTrue(f != null);
		assertEquals(f.getPoint0(),P0);
	}

	@Test
	public void testSetP0DoubleDoubleDouble() {
		assertTrue(f != null);
		f.setP0(4, -1, 5.3);
		assertEquals(f.getPoint0().getX(),4);
		assertEquals(f.getPoint0().getY(),-1);
		assertEquals(f.getPoint0().getZ(),5.3);
	}

	@Test
	public void testSetP0Point3D() {
		assertTrue(f != null);
		pt = new Point3D(4, -1, 5.3);
		f.setP0(pt);
		assertEquals(f.getPoint0(),pt);
	}

	@Test
	public void testGetPoint1() {
		assertTrue(f != null);
		assertEquals(f.getPoint1(),P1);
	}

	@Test
	public void testSetP1DoubleDoubleDouble() {
		assertTrue(f != null);
		f.setP1(4, -1, 5.3);
		assertEquals(f.getPoint1().getX(),4);
		assertEquals(f.getPoint1().getY(),-1);
		assertEquals(f.getPoint1().getZ(),5.3);
	}

	@Test
	public void testSetP1Point3D() {
		assertTrue(f != null);
		pt = new Point3D(4, -1, 5.3);
		f.setP1(pt);
		assertEquals(f.getPoint1(),pt);
	}

	@Test
	public void testGetPoint2() {
		assertTrue(f != null);
		assertEquals(f.getPoint2(),P2);
	}

	@Test
	public void testSetP2DoubleDoubleDouble() {
		assertTrue(f != null);
		f.setP2(4, -2, 5.3);
		assertEquals(f.getPoint2().getX(),4);
		assertEquals(f.getPoint2().getY(),-2);
		assertEquals(f.getPoint2().getZ(),5.3);
	}

	@Test
	public void testSetP2Point3D() {
		assertTrue(f != null);
		pt = new Point3D(4, -2, 5.3);
		f.setP2(pt);
		assertEquals(f.getPoint2(),pt);
	}

}
