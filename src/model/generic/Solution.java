package model.generic;

import java.util.List;

public abstract class Solution {
	
	// j'ai modifi� votre solution en classe abstraite 
	// elle sera concr�tis� par une classe li� au probl�me
	// pour nous c'est la classe sc�nario
	
	protected int [] valuesVariables;
	protected List<Double> valuesObjectives;

	public int[] getValuesVariables() {
		return valuesVariables;
	}
	
	public abstract void evaluer();

	public List<Double> getValuesObjectives() {
		return valuesObjectives;
	}
	
	public Double getValueObjective(int i) {
		return valuesObjectives.get(i);
	}

	public void setValuesVariables(int[] valuesVariables) {
		this.valuesVariables = valuesVariables;
	}
	
	public void setValuesVariables(int iIndexVariable, int iValue) {
		this.valuesVariables[iIndexVariable] = iValue;
		
	}
	
	public abstract void evaluate(Problem pb);


	
}
