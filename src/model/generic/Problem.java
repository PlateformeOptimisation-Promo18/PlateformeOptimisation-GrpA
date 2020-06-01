package model.generic;

public interface Problem {
	
	public Solution getSolution();

	public Solution copySolution(Solution sol);
	
	public int [] getTabSizeDomainVariables();

	public Double getMaxObjectif(int i);

	public Double getMinObjectif(int i);

	public int getNbObjectives();

	public int getNbVariables();

	public boolean[] GetActiveVariable(Solution sol);

	public int getSizeDomainVariable(int i) throws Exception;

	public String getName();
}
