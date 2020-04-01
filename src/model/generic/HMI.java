package model.generic;

import java.util.List;

public interface HMI {

	public abstract void displayText (String text);
	
	// The List<Solution> type is not necessarily suitable, check that.
	public abstract void setParameters (List<Solution> param);
}
