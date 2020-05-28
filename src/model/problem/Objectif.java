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
        this.FLoad(sc);
    }

    /**
     * @return : chaine de caractere qui decrit l'objet courant
     */
    public String toString() {
        return "Objet Objectif -> sName : " + this.sName + " / dMinimalValue : " + this.dMinimalValue + " / dMaximumValue : " + this.dMaximumValue;
    }

    /**
     *
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'objet
     */
    protected void FLoad(Scanner sc) {
        this.sName = sc.next();
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
