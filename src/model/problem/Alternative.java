package model.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Alternative
 * @author : Alexis V.
 * @version : 1.0
 */
public class Alternative {

    private String sName;
    private List<Double> listValueObjectif;
    private List<Resource> listResources;

    /**
     * Constructeur surchargé qui permet de créer une nouvelle alternative
     * @param sc : scanner pour récupérer toutes les valeurs lues dans le fichier
     * @param graph : graph de projet qui permet d'obtenir le nombre d'objectifs
     */
    public Alternative(Scanner sc, GraphProject graph) {
        this.sName = sc.next();
        this.listValueObjectif = new ArrayList<>(graph.getNbObjectives());

        for (int i = 0; i < graph.getNbObjectives() ; i++) {
            this.listValueObjectif.add(sc.nextDouble());
        }

        int iNbResources = sc.nextInt();
        this.listResources = new ArrayList<>(iNbResources);

        for (int i = 0; i < iNbResources; i++) {
            this.listResources.add(new Resource(sc));
        }
    }

    /**
     * Permet de vérifier si les ressources nécessaires pour l'alternative (listResources) sont dans la liste des ressources disponibles
     * @param listAvailableResources : liste des ressources disponibles
     * @return : True si les ressources sont disponibles et False si non
     */
    public boolean isResourcesAvailable(List<Resource> listAvailableResources) {
        Resource resource;
        for (int i = 0; i < this.listResources.size(); i++) {
            resource = this.listResources.get(i);
            if (resource.getdQuantity() > listAvailableResources.get(i).getdQuantity()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Permet d'ajouter une ressource à la liste des ressources de l'alternative
     * @param resource : Ressource qu'on souhaite ajouter à la liste des ressources de l'alternative
     */
    public void addResource(Resource resource) {
        this.listResources.add(resource);
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        StringBuilder msg = new StringBuilder("Alternative -> sName : " + this.sName + " / listValueObjectif : [");
        for (double value : this.listValueObjectif) {
            msg.append(value).append(" ");
        }
        msg.append("]\n");
        for (Resource listResource : this.listResources) {
            msg.append(listResource.toString());
        }
        return msg.toString();
    }

    /**
     * @return : valeur du coût de l'alternative
     */
    public double getCost() {
        return this.listValueObjectif.get(0);
    }

    /**
     * @return : valeur de la durée de l'alternative
     */
    public double getDuration() {
        return this.listValueObjectif.get(1);
    }

    /**
     * @return : valeur de sName sur l'objet courant
     */
    public String getsName() {
        return this.sName;
    }

    /**
     * @return : valeur de listResources sur l'objet courant
     */
    public List<Resource> getListResources() {
        return this.listResources;
    }

}
