package model.generic;

import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import test.algorithms.InterfaceRandom;

import java.util.Observer;

import application.StopRequired;

public abstract class CombinatorialMultiObjectiveOptimizationAlgorithm implements Observer {

	    protected ObservableList<Solution> listSolutionsObservables;
	    protected ObservableList<Double> perfObservable;
	    protected ObservableList<Double> tempsObservable;
	    protected boolean stopRequired;
	    protected List<Parameter> listParam;
		protected ParetoFront bestSolutions; 

		public CombinatorialMultiObjectiveOptimizationAlgorithm(StopRequired stop){
	    	stopRequired = false;
	    	stop.addObserver(this);
	    	bestSolutions = new ParetoFront();
			listSolutionsObservables = FXCollections.observableList(bestSolutions.getSet());
	    }
	    public abstract void launch(Problem pb, InterfaceRandom generator);
	    public List<Parameter> getParameters(){
	    	return listParam;
	    }
	    public void setParameters(List<Parameter> list){
	    	this.listParam = list;
	    }
		@Override
		public void update(Observable o, Object objEvent) {
			this.stopRequired = true;
		}
	    public ParetoFront getBestSolutions() {
			return bestSolutions;
		}
}
