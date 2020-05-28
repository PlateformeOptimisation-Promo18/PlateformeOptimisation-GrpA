package model.algorithms.Random;

import java.util.LinkedList;
import java.util.List;

import application.StopRequired;
import model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import model.generic.InterfaceRandom;
import model.generic.Parameter;
import model.generic.Problem;
import model.generic.Solution;

public class RandomSearchAlgo extends CombinatorialMultiObjectiveOptimizationAlgorithm {
	private static final int NB_ITERATION_MAX = 10;
	
	public RandomSearchAlgo(Problem pb, StopRequired stop) {
		super(pb, stop, "RandomSearch");
		Parameter nbIterationMax = new Parameter(NB_ITERATION_MAX, "nb iteration max");
		listParam.add(nbIterationMax);
	}
	@Override
	public void launch(InterfaceRandom generator) {

		int iNbIterationMax = listParam.get(0).getValue().intValue();
		try {
			long lStartTime = System.nanoTime();
			do {
				Solution solutionCurrent = pb.getSolution();
				solutionCurrent.randomSetValues(pb, generator);
				solutionCurrent.evaluatePerf(pb);
				long lEstimatedTime = System.nanoTime() - lStartTime;
				List<Solution> listNewSolution = new LinkedList<>();
				listNewSolution.add(solutionCurrent);
				updateAndSave(listNewSolution,lEstimatedTime);
				iNbIterationMax--;
			} while (iNbIterationMax > 0 && !stopRequired);

		} catch (Exception e) {
			System.out.println("Erreur lors de l'lagorithme RandomSearch");
			e.printStackTrace();
		}
	}

}
