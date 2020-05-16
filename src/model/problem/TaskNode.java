package model.problem;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskNode extends Node {

    protected List<Alternative> listAlternatives;
    protected int iIdTask;
    protected String sName;

    public TaskNode(Scanner sc, GraphProject gp) {
//        TODO
    }

    public String toString() {
//        TODO
    }

    public double getCost(int iSelectedTaskNodeAlternative) {
//        TODO
    }

    public double getDuration(int iSelectedTaskNodeAlternative) {
//        TODO
    }

    public Boolean isResourcesAvailable(List<Resource> listAvailableResources, int iSelectedTaskNodeAlternative) {
//        TODO
    }

    public boolean isResourcesAvailable(List<Resource> listAvailableResources, boolean bIsMinCalculated, int iNumObjectif) {
//        TODO
    }

    public List<Resource> getListResourcesofSelectedAlternative(int iSelectedTaskNodeAlternative) {
//        TODO
    }

    public Alternative getAlternativeExtremum(boolean bIsMinCalculated, int iNumObjectif) {
//        TODO
    }

    protected void setiIdTask(int iIdTask) {
        this.iIdTask = iIdTask;
    }

    public int getNbAlternatives() {
//        TODO
    }

    protected int getiIdTask() {
        return this.iIdTask;
    }
}

class ComparatorAlternativeDuration implements Comparator<Alternative> {
    public int compare(Alternative alt1, Alternative alt2) {
//        TODO
    }
}

class ComparatorAlternativeCost implements Comparator<Alternative> {
    public int compare(Alternative alt1, Alternative alt2) {
//        TODO
    }
}
