package model.algorithms.ants.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.ants.AntsColonyAlgorithm;
import model.algorithms.ants.AntsColonyAlgorithm.Noeud;

public class TestAntsColonyAlgorithm {
	
	private AntsColonyAlgorithm algo;

	@Before
	public void setUp() throws Exception {
		int[] tab = {2,3,3,2};
		this.algo = new AntsColonyAlgorithm (tab);
	}

	@After
	public void tearDown() throws Exception {
		this.algo = null;
	}

	@Test
	public void testInit() {
		String chaine = "";
		for (Noeud n : algo.getList())
			chaine+=n;
		assertEquals("2-0.53-0.333-0.332-0.5",chaine);
	}

}
