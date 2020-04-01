package model.generic;

import java.util.List;
import java.util.Observable;

public abstract class Algorithm {
	
	private List<Solution> observableSolutions;
	
	private Observable observablePerf;
	
	private Observable observableTime;
	
	public Algorithm () {
		
	}
	
	public abstract void lancer ();
	
	// The List<Solution> type is not necessarily suitable, check that.
	public abstract List<Solution> getParameters ();
	
	// The List<Solution> type is not necessarily suitable, check that.
	public abstract List<Solution> getDefaultParameters ();
	
	// The List<Solution> type is not necessarily suitable, check that.
	public abstract void setParameters (List<Solution> parameters);
	
	public abstract void stop ();

}
