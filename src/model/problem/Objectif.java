package model.problem;

import java.util.Scanner;

/**
 * Classe Objectif
 * @author : Alexis V.
 * @version : 1.0
 */
public class Objectif {

    private String sName;
    private double dMinimalValue;
    private double dMaximumValue;

    /**
     * Permet de créer un Objectif
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'Objectif
     */
    public Objectif(Scanner sc) {
        this.fLoad(sc);
    }

    /**
     *
     * @param sc : Scanner qui contient les valeurs qu'on souhaite renseigner lors de la creation de l'Objectif
     */
    protected void fLoad(Scanner sc) {
        this.sName = sc.next();
    }

    /**
     * @return : chaine de caractere qui decrit l'Objectif
     */
    public String toString() {
        return "Objectif -> sName : " + this.sName + " / dMinimalValue : " + this.dMinimalValue + " / dMaximumValue : " + this.dMaximumValue + "\n";
    }

    /**
     * Permet de renseigner la valeur de dMaximumValue
     * @param dMaximumValue : valeur qu'on souhaite affecter à dMaximumValue
     */
    protected void setdMaximumValue(double dMaximumValue) {
        this.dMaximumValue = dMaximumValue;
    }

    /**
     * Permet de renseigner la valeur de dMinimalValue
     * @param dMinimalValue : valeur qu'on souhaite affecter à dMinimalValue
     */
    protected void setdMinimalValue(double dMinimalValue) {
        this.dMinimalValue = dMinimalValue;
    }

    /**
     * @return : valeur de dMaximumValue
     */
    protected double getdMaximumValue() {
        return this.dMaximumValue;
    }

    /**
     * @return : valeur de dMinimalValue
     */
    protected double getdMinimalValue() {
        return this.dMinimalValue;
    }
}
