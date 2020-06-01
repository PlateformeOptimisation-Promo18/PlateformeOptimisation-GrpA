package test.model.evolutionary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.algorithms.evolutionary.Archive;
import model.algorithms.evolutionary.Individual;

public class ArchiveTest {

private Archive archive;
	
	@Before
	public void setUp() {
		this.archive = new Archive(10);
	}

	@After
	public void tearDown() {
		this.archive = null;
	}
	
	@Test
	public void testEnleveDoublons() {
		this.archive = new Archive(10);
		Individual individu = new Individual(null);
		this.archive.add(individu);
		this.archive.add(individu);
		this.archive.enleveDoublons();
		assertEquals(1, this.archive.getIndividualSet().size());
	}
	
	@Test
	public void testUpdateArchive() {
		
	}

}
