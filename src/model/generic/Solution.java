package model.generic;

import java.util.List;

public abstract class Solution {
	
	// j'ai modifié votre solution en classe abstraite 
	// elle sera concrétisé par une classe lié au problème
	// pour nous c'est la classe scénario
	
	protected int [] valuesVariables;
	protected List<Double> valuesObjectives;

	public int[] getValuesVariables() {
		return valuesVariables;
	}

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
	// vous n'avez pas de classe problème !
	
	// public abstract void evaluate(Problem pb);


	
}
