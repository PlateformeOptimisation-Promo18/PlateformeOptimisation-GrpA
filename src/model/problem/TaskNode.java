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

    protected int iIdTask;
    protected String sName;
    protected List<Alternative> listAlternatives;

    /**
     * TODO
     * @param sc
     * @param gp
     */
    public TaskNode(Scanner sc, GraphProject gp) {
        this.sName = sc.next();
        this.iIdTask = sc.nextInt();
        this.listAlternatives = new ArrayList<>();
        for (int i = 0; i < sc.nextInt(); i++) {
            this.listAlternatives.add(new Alternative(sc, gp));
        }
    }

    public String toString() {
//        TODO
        return null;
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


    protected void setiIdTask(int iIdTask) {
        this.iIdTask = iIdTask;
    }

    public int getNbAlternatives() {
//        TODO
        return 0;
    }

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
