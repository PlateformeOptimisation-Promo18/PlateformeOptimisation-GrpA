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

    protected String sName;
    protected List<Double> listValueObjectif;
    protected List<Resource> listResources;

    /**
     * Constructeur surchargé qui permet de créer une nouvelle alternative
     * @param sc : scanner pour récupérer toutes les valeurs lues dans le fichier
     * @param graph : graph de projet qui permet d'obtenir le nombre d'objectifs
     */
    public Alternative(Scanner sc, GraphProject graph) {
        this.sName = sc.next();
        this.listValueObjectif = new ArrayList<>();
        this.listResources = new ArrayList<>();

        for (int i = 0; i < graph.getNbObjectives() ; i++) {
            this.listValueObjectif.add(sc.nextDouble());
        }
        for (int i = 0; i < sc.nextInt(); i++) {
            this.addResource(new Resource(sc));
        }
    }

    public boolean isResourcesAvailable(List<Resource> listAvailableResources) {
//        TODO
        return false;
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
        return null;
//        return "Objet Alternative -> sName : " + this.sName + " / listValueObjectif : " + this.listValueObjectif;
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
