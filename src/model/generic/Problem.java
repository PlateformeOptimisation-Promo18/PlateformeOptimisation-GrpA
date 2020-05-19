package model.generic;

/**
 * interface Problem : définit les traitements que dois implémenter un problème
 * pour pouvoir utiliser un algo d'optimisation
 * 
 * @author p.pitiot
 */
public interface Problem {

	/**
	 * Méthode retournant une solution vide
	 * 
	 * @return la solution créée
	 */
	public Solution getSolution();

	/**
	 * méthode copiant une solution attention à réfléchir si vous avez besoin de
	 * copier des solutions pour les modifier ne pas modifier la solution
	 * d'origine mais bien la copie !
	 * 
	 * @param sol
	 *            la solution à copier
	 * @return la solution copiée
	 */
	public Solution copySolution(Solution sol);

	/**
	 * méthode retournant un tableau des tailles de domaines de chaque variable
	 * du problème les algos doivent l'utiliser pour tirer des solutions (pour
	 * chaque variable : tirage entre 0 et le nombre de valeurs possibles -1)
	 * 
	 * @return le tableau des tailles de domaines
	 */
	public int[] getTabSizeDomainVariables();

	public Double getMaxObjectif(int i);

	public Double getMinObjectif(int i);

	public int getNbObjectives();

	public int getNbVariables();

	/**
	 * Méthode retournant un tableau indiquant quelles variables sont actives
	 * dans une solution une variable active est utile alors qu'une variable
	 * inactive ne sert à rien pour le problème de graphe c'est par exemple un
	 * choix pour une tache qui n'est pas sur le chemin correspondant au
	 * scénario
	 * 
	 * @param sol la solution dont on veut connaitre les variables actives
	 * @return tableau de booléen chaque case : vrai si la variable est active
	 */
	public boolean[] getActiveVariable(Solution sol);
	
	/**
	 * méthode retourne la tailles du domaine de la variable à l'indice i
	 * c'est comme getTabSizeDomainVariables mais pour une variable
	 * @return le tableau des tailles de domaines
	 * @throws Exception si l'indice est hors tableau
	 */
	public int getTabSizeDomainVariable(int i) throws Exception;

	
	/**
	 * renvoi le nom du problème, utilisé pour 
	 * le nommage du fichier sauvegarde entre autre
	 * @return le nom du problème
	 */
	public String getName();

}
