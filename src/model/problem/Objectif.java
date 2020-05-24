package model.problem;

import java.util.Scanner;

/**
 * Classe Objectif
 * @author : Alexis V.
 * @version : 1.0
 */
public class Objectif {

    protected String sName;
    protected double dMinimalValue;
    protected double dMaximumValue;

    /**
     * Permet de créer un objet avec des valeurs transmises en parametres
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    public Objectif(Scanner sc) {
        this.sName = sc.next();
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return String.format("Objet Objectif, sName : %s // dMinimalValue : %f // dMaximumValue : %f", this.sName, this.dMinimalValue, this.dMaximumValue);
    }

    protected void FLoad(Scanner sc) {
//        TODO
    }

    /**
     * Permet de renseigner la valeur de dMaximumValue
     * @param dMaximumValue : valeur qu'on souhaite affecter à dMaximumValue sur l'objet courant
     */
    protected void setdMaximumValue(double dMaximumValue) {
        this.dMaximumValue = dMaximumValue;
    }

    /**
     * Permet de renseigner la valeur de dMinimalValue
     * @param dMinimalValue : valeur qu'on souhaite affecter à dMinimalValue sur l'objet courant
     */
    protected void setdMinimalValue(double dMinimalValue) {
        this.dMinimalValue = dMinimalValue;
    }

    /**
     * @return : valeur de dMaximumValue sur l'objet courant
     */
    protected double getdMaximumValue() {
        return this.dMaximumValue;
    }

    /**
     * @return : valeur de dMinimalValue sur l'objet courant
     */
    protected double getdMinimalValue() {
        return this.dMinimalValue;
    }
}
