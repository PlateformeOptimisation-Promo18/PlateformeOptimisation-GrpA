package model.generic;


/**
 * Classe param�tre g�n�rique
 * un param�tre est une valeur num�rique (classe Number) et un label (string) pour l'affichage
 * @author p.pitiot
 *
 */
public class Parameter{
	protected Number value;
	protected String name;
	
	public Parameter(Number value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	public Number getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	public void setValue(Number value) {
		this.value = value;
	}
	
}
