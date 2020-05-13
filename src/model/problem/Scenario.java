package model.problem;

import java.util.ArrayList;
import java.util.Arrays;

import model.generic.Problem;
import model.generic.Solution;

public class Scenario extends Solution {
	
	public Scenario (GraphProject gp) {
		valuesObjectives = new ArrayList<>(gp.getNbObjectives());
		valuesObjectives.add(0.0);
		valuesObjectives.add(0.0);
		valuesVariables = new int[gp.getNbTasks() + gp.getNbOr()];
		// we fill scenario with 0 initially
		Arrays.fill(valuesVariables, 0);	
	}
	
	protected void setDuration(double iVal) {
		valuesObjectives.set(0, iVal);
	}

	protected void setCost(double iVal) {
		valuesObjectives.set(1, iVal);
	}
	public void evaluate(Problem gpTest) {
		
		int tableauEntier[] = { 0, 0, 0, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier)) {
			setDuration(3.8);
			setCost(17.4);
		}
		int tableauEntier1[] = { 1, 0, 0, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier1)) {
			setDuration(9.1);
			setCost(23.9);
		}

		int tableauEntier2[] = { 0, 1, 0, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier2)) {
			setDuration(9.8);
			setCost(18.5);
		}
		int tableauEntier3[] = { 1, 1, 0, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier3)) {
			setDuration(9.1);
			setCost(23.9);
		}
		int tableauEntier4[] = { 0, 0, 1, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier4)) {
			setDuration(3.8);
			setCost(17.4);
		}
		int tableauEntier5[] = { 1, 0, 1, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier5)) {
			setDuration(4.3);
			setCost(21.5);
		}
		int tableauEntier6[] = { 0, 1, 1, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier6)) {
			setDuration(9.8);
			setCost(18.5);
		}
		int tableauEntier7[] = { 1, 1, 1, 0, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier7)) {
			setDuration(4.3);
			setCost(21.5);
		}
		int tableauEntier8[] = { 0, 0, 0, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier8)) {
			setDuration(9.1);
			setCost(16.5);
		}
		int tableauEntier9[] = { 1, 0, 0, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier9)) {
			setDuration(14.4);
			setCost(23.0);
		}
		int tableauEntier10[] = { 0, 1, 0, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier10)) {
			setDuration(15.1);
			setCost(17.6);
		}
		int tableauEntier11[] = { 1, 1, 0, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier11)) {
			setDuration(14.4);
			setCost(23.0);
		}
		int tableauEntier12[] = { 0, 0, 1, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier12)) {
			setDuration(9.1);
			setCost(16.5);
		}
		int tableauEntier13[] = { 1, 0, 1, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier13)) {
			setDuration(9.6);
			setCost(20.6);
		}
		int tableauEntier14[] = { 0, 1, 1, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier14)) {
			setDuration(15.1);
			setCost(17.6);
		}
		int tableauEntier15[] = { 1, 1, 1, 1, 0 };
		if (Arrays.equals(this.valuesVariables, tableauEntier15)) {
			setDuration(9.6);
			setCost(20.6);
		}
		int tableauEntier16[] = { 0, 0, 0, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier16)) {
			setDuration(3.8);
			setCost(14.3);
		}
		int tableauEntier17[] = { 1, 0, 0, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier17)) {
			setDuration(9.1);
			setCost(20.8);
		}
		int tableauEntier18[] = { 0, 1, 0, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier18)) {
			setDuration(9.8);
			setCost(15.4);
		}
		int tableauEntier19[] = { 1, 1, 0, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier19)) {
			setDuration(9.1);
			setCost(20.8);
		}
		int tableauEntier20[] = { 0, 0, 1, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier20)) {
			setDuration(3.8);
			setCost(14.3);
		}
		int tableauEntier21[] = { 1, 0, 1, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier21)) {
			setDuration(4.3);
			setCost(18.4);
		}
		int tableauEntier22[] = { 0, 1, 1, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier22)) {
			setDuration(9.8);
			setCost(15.4);
		}
		int tableauEntier23[] = { 1, 1, 1, 0, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier23)) {
			setDuration(4.3);
			setCost(18.4);
		}
		int tableauEntier24[] = { 0, 0, 0, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier24)) {
			setDuration(9.1);
			setCost(13.4);
		}
		int tableauEntier25[] = { 1, 0, 0, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier25)) {
			setDuration(14.4);
			setCost(19.9);
		}
		int tableauEntier26[] = { 0, 1, 0, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier26)) {
			setDuration(15.1);
			setCost(14.5);
		}
		int tableauEntier27[] = { 1, 1, 0, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier27)) {
			setDuration(14.4);
			setCost(19.9);
		}
		int tableauEntier28[] = { 0, 0, 1, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier28)) {
			setDuration(9.1);
			setCost(13.4);
		}
		int tableauEntier29[] = { 1, 0, 1, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier29)) {
			setDuration(9.6);
			setCost(17.5);
		}
		int tableauEntier30[] = { 0, 1, 1, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier30)) {
			setDuration(15.1);
			setCost(14.5);
		}
		int tableauEntier31[] = { 1, 1, 1, 1, 1 };
		if (Arrays.equals(this.valuesVariables, tableauEntier31)) {
			setDuration(9.6);
			setCost(17.5);
		}
	}

	@Override
	public void evaluer() {
		// TODO Auto-generated method stub
		
	}
	
	// ses fonctions sont � retirer pour moi 
	// car elles sont r�alis�es dans la classe solution
	
//	public void setValuesVariables (int e1, int e2) {
//		
//	}
//	
//	public double getValueObjective (int i) {
//		return 0.0;
//	}

}
