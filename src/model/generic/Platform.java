package model.generic;

public class Platform {
	
	private CombinatorialMultiObjectiveOptimizationAlgorithm algo;
	
	private TypeOfProblem typeProblem;
	
	private Problem problem;
	
	private Visualization visu;
	
	private HMI hmiLaunch;
	
	public Platform () {
		
	}
	
	public void startOptimization () {
		
	}
	
	public void startComparison () {
	
	}
	
	public void display () {
		
	}
	
	public void stop () {
		
	}

	public CombinatorialMultiObjectiveOptimizationAlgorithm getAlgo() {
		return algo;
	}

	public void setAlgo(CombinatorialMultiObjectiveOptimizationAlgorithm algo) {
		this.algo = algo;
	}

	public TypeOfProblem getTypeProblem() {
		return typeProblem;
	}

	public void setTypeProblem(TypeOfProblem typeProblem) {
		this.typeProblem = typeProblem;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public Visualization getVisu() {
		return visu;
	}

	public void setVisu(Visualization visu) {
		this.visu = visu;
	}

}
