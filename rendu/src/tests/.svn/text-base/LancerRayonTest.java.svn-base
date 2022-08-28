package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;
import java.util.ArrayList;

import lancerRayon.LancerRayon;
import lancerRayon.Scene;

import org.junit.Before;
import org.junit.Test;

public class LancerRayonTest {
	private LancerRayon l;
	private Scene s;
	private Scene s1;
	private Scene s2;
	private int i,j;
	private Color c;
	private Color c1;
	private Color c2;
	private ArrayList<Scene> list;

	@Before
	public void setUp() throws Exception {
		l = new LancerRayon(999);
		c = new Color(32);
		c1 = new Color(48);
		c2 = new Color(54);
		s = new Scene(c);
		s1 = new Scene(c1);
		s2 = new Scene(c2);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testLancerRayon() {
			l = new LancerRayon(88);
			assertEquals(l.RECURSIVITE_MAX,88);
	}

	@Test
	public void testAjouterScene() {
		try {
			l.ajouterScene(s);
		}
		catch (NullPointerException l){
			fail("Erreur : Exception de pointeur null levee");
		}

		try {
			i = l.ajouterScene(null);
			fail("Erreur : Exception de pointeur null non levee");
		}
		catch (NullPointerException l){
			assertTrue(true);
		}
	}

	@Test
	public void testGetScene() {
		i = l.ajouterScene(s);
		assertTrue(l != null);
		assertTrue(l.getScene(i) != null);
		assertEquals(l.getScene(i), s);
	}

	@Test
	public void testSupprimerScene() {
		i = l.ajouterScene(s);
		assertTrue(l != null);
		l.supprimerScene(i);
		assertTrue(l.getScene(i) == null);
	}

	@Test
	public void testGetScenes() {
		l.ajouterScene(s);
		j=l.ajouterScene(s1);
		l.ajouterScene(s2);
		list = new ArrayList<Scene>();
		assertTrue(l != null);
		for (i=999;i>=0;i--){
			if (l.getScene(i) != null){
		list.add(l.getScene(i));
			}
		}
		assertEquals(l.getScenes().size(), list.size());

		list = new ArrayList<Scene>();
		l.supprimerScene(j);
		for (i=999;i>=0;i--){
			if (l.getScene(i) != null){
		list.add(l.getScene(i));
			}
		}
		assertEquals(l.getScenes().size(), list.size());
		
	}

}
