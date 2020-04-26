package model.algorithms.ants;

import java.util.ArrayList;
import java.util.List;

public class AntsColonyAlgorithm {
	
	private List<int[]> noeuds;
	private PheromonesTrails pheromonesTrails;
	
	public AntsColonyAlgorithm (List<int[]> ListTabNoeud) {
		this.noeuds = ListTabNoeud;
		this.pheromonesTrails = new PheromonesTrails(ListTabNoeud,1000);
	}
	
	
	

}
