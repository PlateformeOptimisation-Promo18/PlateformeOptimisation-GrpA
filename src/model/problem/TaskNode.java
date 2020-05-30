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
        this.listAlternatives = new ArrayList<>();
        for (int i = 0; i < sc.nextInt(); i++) {
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
    public int compare(Alternative alt1, Alternative alt2) {
//        TODO
        return 0;
    }
}

/**
 * Classe ComparatorAlternativeCost
 * @author : Alexis V.
 * @version : 1.0
 */
class ComparatorAlternativeCost implements Comparator<Alternative> {
    public int compare(Alternative alt1, Alternative alt2) {
//        TODO
        return 0;
    }
}
