package model.problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Classe TaskNode
 * @author : Alexis V.
 * @version : 1.0
 */
public class TaskNode extends Node {

    private int iIdTask;
    private String sName;
    private List<Alternative> listAlternatives;

    /**
     * Permet de créer un tâche dans laquelle il y aura des alternatives
     * @param sc : Scanner qui contient les valeurs pour créer la tâche et alternatives attachées
     * @param gp : GraphProject dans lequel on ajoute les tâches
     */
    public TaskNode(Scanner sc, GraphProject gp) {
        this.sName = sc.next();
        this.iIdTask = sc.nextInt();
        int iNbAlternatives = sc.nextInt();

        this.listAlternatives = new ArrayList<>(iNbAlternatives);
        for (int i = 0; i < iNbAlternatives; i++) {
            this.listAlternatives.add(new Alternative(sc, gp));
        }
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        StringBuilder msg = new StringBuilder("TaskNode -> sName : " + this.sName + " / iIdTask : " + this.iIdTask + "\n");
        for (Alternative listResource : this.listAlternatives) {
            msg.append(listResource.toString());
        }
        return msg.toString();
    }

    /**
     * Permet de récupérer le cout de l'alternative a un un index donné
     * @param iSelectedTaskNodeAlternative : index dans la liste d'alternative ou on souhaite récupérer son cout
     * @return : cout de l'alternative
     */
    public double getCost(int iSelectedTaskNodeAlternative) {
        return this.listAlternatives.get(iSelectedTaskNodeAlternative).getCost();
    }

    /**
     * Permet de récupérer la duree de l'alternative a un un index donné
     * @param iSelectedTaskNodeAlternative : index dans la liste ou on souhaite récupérer sa duree
     * @return : duree de l'alternative
     */
    public double getDuration(int iSelectedTaskNodeAlternative) {
        return this.listAlternatives.get(iSelectedTaskNodeAlternative).getDuration();
    }

    public Boolean isResourcesAvailable(List<Resource> listAvailableResources, int iSelectedTaskNodeAlternative) {
//        TODO
        return false;
    }

    public boolean isResourcesAvailable(List<Resource> listAvailableResources, boolean bIsMinCalculated, int iNumObjectif) {
//        TODO
        return false;
    }

    public List<Resource> getListResourcesofSelectedAlternative(int iSelectedTaskNodeAlternative) {
//        TODO
        return null;
    }

    public Alternative getAlternativeExtremum(boolean bIsMinCalculated, int iNumObjectif) {
//        TODO
        return null;
    }

    /**
     * Permet de renseigner la valeur de iIdTask
     * @param iIdTask : valeur qu'on souhaite affecter à iIdTask sur l'objet courant
     */
    protected void setiIdTask(int iIdTask) {
        this.iIdTask = iIdTask;
    }

    /**
     * @return : taille de listAlternatives sur l'objet courant
     */
    public int getNbAlternatives() {
        return this.listAlternatives.size();
    }

    /**
     * @return : valeur de iIdTask sur l'objet courant
     */
    protected int getiIdTask() {
        return this.iIdTask;
    }
}

/**
 * Classe ComparatorAlternativeDuration
 * @author : Alexis V.
 * @version : 1.0
 */
class ComparatorAlternativeDuration implements Comparator<Alternative> {

    /**
     * Permet de comparer les durees de 2 alternatives passées en paramètres
     * @param alt1 : Alternative 1
     * @param alt2 : Alternative 3
     * @return : 1 si alt1 > alt2 / -1 si alt1 < alt2 / 0 si alt1 = alt2
     */
    public int compare(Alternative alt1, Alternative alt2) {
        int val;
        if (alt1.getDuration() > alt2.getDuration()) {
            val = 1;
        } else if (alt1.getDuration() < alt2.getDuration()) {
            val = -1;
        } else {
            val = 0;
        }
        return val;
    }
}

/**
 * Classe ComparatorAlternativeCost
 * @author : Alexis V.
 * @version : 1.0
 */
class ComparatorAlternativeCost implements Comparator<Alternative> {

    /**
     * Permet de comparer les couts de 2 alternatives passées en paramètres
     * @param alt1 : Alternative 1
     * @param alt2 : Alternative 3
     * @return : 1 si alt1 > alt2 / -1 si alt1 < alt2 / 0 si alt1 = alt2
     */
    public int compare(Alternative alt1, Alternative alt2) {
        int val;
        if (alt1.getCost() > alt2.getCost()) {
            val = 1;
        } else if (alt1.getCost() < alt2.getCost()) {
            val = -1;
        } else {
            val = 0;
        }
        return val;
    }
}
