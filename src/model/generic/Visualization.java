package model.generic;

import java.util.HashMap;
import java.util.List;

import javafx.scene.chart.Chart;

public abstract class Visualization {
	
	/** Visualization compatible */
	private HashMap<CombinatorialMultiObjectiveOptimizationAlgorithm, TypeOfProblem> visu;
	
	private Chart graph;
	
	private List<Solution> solutions;
	
	public Visualization () {
		
	}
	
	public abstract void visualize ();
	
	public abstract void setScale (int x, int y);
	
	public abstract void update ();
	
	public abstract int[] getDefaultParameters ();

}
