package tests;

import junit.framework.TestCase;
import lancerRayon.Ecran;
import lancerRayon.NonOrthogonalException;
import lancerRayon.ValeurNonPositiveException;
import util.Point3D;
import util.Vecteur3D;

public class EcranTest extends TestCase {
	
	private Ecran e;
	private Vecteur3D v1;
	private Vecteur3D v2;
	private Vecteur3D v3;
	private Vecteur3D v4;
	private Point3D position1;
	private Point3D position2;
	private Point3D a1;
	private Point3D b1;
	private Point3D origine;
	private Point3D a2;
	private Point3D b2;
	private Point3D a3;
	private Point3D b3;
	private Point3D a4;
	private Point3D b4;

	
	public void setUp() {
		
		a1 = new Point3D(1.5, 0, 0);
		b1 = new Point3D(-1.5, 0, 0);
		origine = new Point3D(0,0,0);
		v1 = new Vecteur3D(a1,b1,origine);
		a2 = new Point3D(0 , 0, -4);
		b2 = new Point3D(0 , 0, 1);
		v2 = new Vecteur3D(a2,b2,origine);
		position1 = new Point3D(78,5,-62);
		a3 = new Point3D(1.43 , 2, 0);
		b3 = new Point3D(9 , 2, 0);
		v3= new Vecteur3D(a3,b3,origine);
		a4 = new Point3D(0 , 4, 4);
		b4 = new Point3D(0 , 4, 2);
		v4= new Vecteur3D(a4,b4,origine);
		position2 = new Point3D(0,53,-6);
		try{
			e = new Ecran (v1, v2, position1, 9, 9);
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		
	}

	public void testEcran() {
		try{
			e = new Ecran (v1, v2, position1, 9, 9);
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux levee");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		//Cas vecteur non orthogonaux
		try{
			e = new Ecran (v1, v1, position1, 3, 9);
			fail("Erreur de vecteurs non orthogonaux non leve");
		}
		catch(NonOrthogonalException e){
			assertTrue(true);	
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		//Cas hauteur negative
		try{
			e = new Ecran (v1, v2, position1, -1, 9);
			fail("Erreur de hauteur negative non levee");
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		catch(ValeurNonPositiveException e){
			assertTrue(true);
		}
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		//Cas largeur negative
		try{
			e = new Ecran (v1, v2, position1, 1, -9);
			fail("Erreur de largeur negative non levee");
		}
		catch(NonOrthogonalException e){
			fail("Erreur : Exception de vecteurs non orthogonaux leve");
		}
		catch(ValeurNonPositiveException e){
			assertTrue(true);
		}
		catch(NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		
		//Cas v1=null
		try{
			e = new Ecran (null, v2, position1, 1, 9);
			fail("Erreur de pointeur null non leve");
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NullPointerException e){
			assertTrue(true);
		}
		
		//Cas v2=null
		try{
			e = new Ecran (v1, null, position1, 1, 9);
			fail("Erreur de pointeur null non levee");
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NullPointerException e){
			assertTrue(true);
		}
		
		//Cas position=null
		try{
			e = new Ecran (v1, v2, null, 1, 9);
			fail("Erreur de pointeur null non levee");
		}
		catch(NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		catch(NullPointerException e){
			assertTrue(true);
		}
	}

	public void testGetV1() {
		assertTrue(e != null);
		assertTrue(e.getV1() != null);
		assertEquals(v1, e.getV1());		
	}

	public void testGetV2() {
		assertTrue(e != null);
		assertTrue(e.getV2() != null);
		assertEquals(v2, e.getV2());
	}

	public void testGetPosition() {
		assertTrue(e != null);
		assertTrue(e.getV1() != null);
		assertEquals(position1, e.getV1().getOrigine());
	}

	public void testGetHauteur() {
		assertTrue(e != null);
		assertEquals(9, e.getHauteur());
	}

	public void testGetLargeur() {
		assertTrue(e != null);
		assertEquals(9, e.getLargeur());
	}

	public void testSetV1() {
		try{
			e.setV1(v3);
		}
		catch (NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		catch (NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		assertEquals(v3, e.getV1());
		assertEquals((e.getV1()).getOrigine(), position1);
				
		//Le nouveau v1 est null
		try{
			e.setV1(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
		catch (NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		} 
		
		//Le nouveau v1 est non-orthogonal a v2
		try{
			e.setV1(v2);
			fail("Erreur de non orthogonalite non levee");
		}
		catch (NullPointerException e){
			fail("Erreur : Exception de pointeur null levee");
		}
		catch (NonOrthogonalException e){
			assertTrue(true);
		} 
		
	}

	public void testSetV2() {
		try{
			e.setV2(v4);
		}
		catch (NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		catch (NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		}
		assertEquals(v4, e.getV2());
		assertEquals((e.getV2()).getOrigine(), position1);
				
		//Le nouveau v2 est null
		try{
			e.setV2(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
		catch (NonOrthogonalException e){
			fail("Erreur: Exception de vecteurs non orthogonaux leve");
		} 
		
		//Le nouveau v2 est non-orthogonale  v1
		try{
			e.setV2(v1);
			fail("Erreur de non-orthogonalit non leve");
		}
		catch (NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		catch (NonOrthogonalException e){
			assertTrue(true);
		} 

	}

	public void testSetPosition() {
		try{
			e.setPosition(position2);
		}
		catch (NullPointerException e){
			fail("Erreur : Exception de pointeur null leve");
		}
		assertEquals((e.getV1()).getOrigine(), position2);
		assertEquals((e.getV2()).getOrigine(), position2);
		
		//Le nouveau position est null
		try{
			e.setPosition(null);
			fail("Erreur de pointeur null non leve");
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
		
	}

	public void testSetHauteur() {
		try{
			e.setHauteur(6);
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		assertEquals(e.getHauteur(), 6);
		
		try{
			e.setHauteur(-6);
			fail("Erreur de hauteur negative non leve");
		}
		catch(ValeurNonPositiveException e){
			assertTrue(true);
		}
		
	}	

	public void testSetLargeur() {
		try{
			e.setLargeur(6);
		}
		catch(ValeurNonPositiveException e){
			fail("Erreur : Exception de hauteur ou largeur ngative leve");
		}
		assertEquals(e.getLargeur(), 6);
		
		try{
			e.setLargeur(-6);
			fail("Erreur de hauteur negative non leve");
		}
		catch(ValeurNonPositiveException e){
			assertTrue(true);
		}
		
	}

}
