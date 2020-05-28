package model.problem;

import java.util.Scanner;

/**
 * Classe Resource
 * @author : Alexis V.
 * @version : 1.0
 */
public class Resource implements Cloneable {

    private int iIdResource;
    private double dQuantity;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public Resource(Scanner sc) {
        this.iIdResource = sc.nextInt();
        this.dQuantity = sc.nextDouble();
    }

    /**
     * Constructeur surchargé avec un objet du même type
     * @param resource : Objet ressource avec lequel on souhaite en créer un nouveau
     */
    public Resource(Resource resource) {
        this.iIdResource = resource.getiIdResource();
        this.dQuantity = resource.getdQuantity();
    }

    public Resource(Scanner sc, GraphProject gp) throws Exception {
//        TODO
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return "Objet Ressource -> iIdResource : " + this.iIdResource + " / dQuantity : " + this.dQuantity;
    }

    /**
     * Permet de soustraire une quantité sur l'attribut dQuantity
     * @param dQuantity : quantité qu'on souhaite soustraire à dQuantity sur l'objet courant
     */
    public void removeQuantity(double dQuantity) {
        this.dQuantity -= dQuantity;
    }

    /**
     * Permet d'ajouter une quantité sur l'attribut dQuantity
     * @param dQuantity : quantité qu'on souhaite ajouter à dQuantity sur l'objet courant
     */
    public void addQuantity(double dQuantity) {
        this.dQuantity += dQuantity;
    }

    /**
     * @return : valeur de iIdResource sur l'objet courant
     */
    public int getiIdResource() {
        return this.iIdResource;
    }

    /**
     * @return : valeur de iIdOrNode sur l'objet courant
     */
    public double getdQuantity() {
        return this.dQuantity;
    }

}
