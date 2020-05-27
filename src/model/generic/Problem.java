package model.generic;

/**
 * interface Problem : d�finit les traitements que dois impl�menter un probl�me
 * pour pouvoir utiliser un algo d'optimisation
 * 
 * @author p.pitiot
 */
public interface Problem {

	/**
	 * M�thode retournant une solution vide
	 * 
	 * @return la solution cr��e
	 */
	public Solution getSolution();

	/**
	 * m�thode copiant une solution attention � r�fl�chir si vous avez besoin de
	 * copier des solutions pour les modifier ne pas modifier la solution
	 * d'origine mais bien la copie !
	 * 
	 * @param sol
	 *            la solution � copier
	 * @return la solution copi�e
	 */
	public Solution copySolution(Solution sol);

	/**
	 * m�thode retournant un tableau des tailles de domaines de chaque variable
	 * du probl�me les algos doivent l'utiliser pour tirer des solutions (pour
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
	 * M�thode retournant un tableau indiquant quelles variables sont actives
	 * dans une solution une variable active est utile alors qu'une variable
	 * inactive ne sert � rien pour le probl�me de graphe c'est par exemple un
	 * choix pour une tache qui n'est pas sur le chemin correspondant au
	 * sc�nario
	 * 
	 * @param sol la solution dont on veut connaitre les variables actives
	 * @return tableau de bool�en chaque case : vrai si la variable est active
	 */
	public boolean[] getActiveVariable(Solution sol);
	
	/**
	 * m�thode retourne la tailles du domaine de la variable � l'indice i
	 * c'est comme getTabSizeDomainVariables mais pour une variable
	 * @return le tableau des tailles de domaines
	 * @throws Exception si l'indice est hors tableau
	 */
	public int getTabSizeDomainVariable(int i) throws Exception;

	
	/**
	 * renvoi le nom du probl�me, utilis� pour 
	 * le nommage du fichier sauvegarde entre autre
	 * @return le nom du probl�me
	 */
	public String getName();

}
