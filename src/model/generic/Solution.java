package model.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solution {

	protected int[] valueVariables;
	protected List<Double> valuesObjectives;
	protected List<Double> valuesObjectivesNormalized;
	protected double hypervolum = 0.0;
	
	public abstract void evaluate(Problem pb);
	public abstract void randomSetValues(Problem pb, InterfaceRandom generator) throws Exception;
	public Solution(Problem gp) {
		int iNbObjectives = gp.getNbObjectives();
		valuesObjectives = new ArrayList<>(iNbObjectives);
		for (int i = 0; i < iNbObjectives; i++)
			valuesObjectives.add(0.0);
		valuesObjectivesNormalized = new ArrayList<>(iNbObjectives);
		for (int i = 0; i < iNbObjectives; i++)
			valuesObjectivesNormalized.add(0.0);

		valueVariables = new int[gp.getNbVariables()];
		// we initially fill solution with 0
		Arrays.fill(valueVariables, 0);
	}
	public Solution(Solution sol) {
		valuesObjectives = new ArrayList<>();
		List<Double> listOriginal = sol.getValueObjective();
		for (Double d : listOriginal) {
			valuesObjectives.add(new Double(d));
		}
		valuesObjectivesNormalized = new ArrayList<>();
		listOriginal = sol.getValuesObjectivesNormalized();
		for (Double d : listOriginal) {
			valuesObjectivesNormalized.add(new Double(d));
		}
		valueVariables = new int[sol.getValuesVariables().length];
		int[] listOriginalValues = sol.getValuesVariables();
		for (int i = 0; i < listOriginalValues.length; i++) {
			valueVariables[i] = listOriginalValues[i];
		}
		hypervolum = sol.getHypervolum();
	}
	public double getHypervolum() {
		return hypervolum;
	}
	private List<Double> getValuesObjectivesNormalized() {
		return valuesObjectivesNormalized;
	}
	private List<Double> getValueObjective() {
		return valuesObjectives;
	}
	private int[] getValuesVariables() {
		return valueVariables;
	}
	public int getNbVariables() {
		return valueVariables.length;
	}
	public Double getValueObjective(int i) {
		return valuesObjectives.get(i);
	}
	public void setValuesVariables(int[] valuesVariables) {
		this.valueVariables = valuesVariables;
	}
	public void setValuesVariables(int iIndexVariable, int iValue) {
		this.valueVariables[iIndexVariable] = iValue;

	}
	public int getValueVariable(int iIndexVariable) {
		return valueVariables[iIndexVariable];
	}
	public double evaluatePerf(Problem pb) {
		evaluate(pb);
		computeNormalizedObjective(pb);
		hypervolum = valuesObjectivesNormalized.get(0);
		for (int i = 1; i < valuesObjectives.size(); i++) {
			hypervolum *= valuesObjectivesNormalized.get(i);
		}
		return hypervolum;
	}
	protected void computeNormalizedObjective(Problem pb) {
		for (int i = 0; i < valuesObjectives.size(); i++) {
			valuesObjectivesNormalized.set(i,
					(pb.getMaxObjectif(i) - valuesObjectives.get(i)) / (pb.getMaxObjectif(i) - pb.getMinObjectif(i)));
		}

	}
	public boolean isDomined(Solution currentSolution) {
		for (int i = 0; i < valuesObjectives.size(); i++) {
			if (currentSolution.getValueObjective(i) > valuesObjectives.get(i))
				return false;
		}
		return true;
	}
	protected Double getValuesObjectivesNormalized(int i) {
		return valuesObjectivesNormalized.get(i);
	}
	@Override
	public String toString() {
		return "Solution [valuesObjectives=" + valuesObjectives + ", valuesVariables="
				+ Arrays.toString(valueVariables) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(hypervolum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((valuesObjectives == null) ? 0 : valuesObjectives.hashCode());
		result = prime * result + ((valuesObjectivesNormalized == null) ? 0 : valuesObjectivesNormalized.hashCode());
		result = prime * result + Arrays.hashCode(valueVariables);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solution other = (Solution) obj;
		if (Double.doubleToLongBits(hypervolum) != Double.doubleToLongBits(other.hypervolum))
			return false;
		if (valuesObjectives == null) {
			if (other.valuesObjectives != null)
				return false;
		} else if (!valuesObjectives.equals(other.valuesObjectives))
			return false;
		if (valuesObjectivesNormalized == null) {
			if (other.valuesObjectivesNormalized != null)
				return false;
		} else if (!valuesObjectivesNormalized.equals(other.valuesObjectivesNormalized))
			return false;
		if (!Arrays.equals(valueVariables, other.valueVariables))
			return false;
		return true;
	}
	public boolean isObjEgal(Solution sol2) {
		return valuesObjectives.equals(sol2.valuesObjectives);
	}
}
