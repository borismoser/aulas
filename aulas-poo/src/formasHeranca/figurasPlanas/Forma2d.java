package formasHeranca.figurasPlanas;

import formasHeranca.classes.Forma;

public abstract class Forma2d extends Forma {

	public Forma2d(String nome) {
		super(nome);
	}
	
	public abstract double getArea();
	
	public abstract double getPerimetro();
	
}
