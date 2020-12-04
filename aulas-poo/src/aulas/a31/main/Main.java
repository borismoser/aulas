package aulas.a31.main;

import java.util.ArrayList;

import aulas.a31.classes.Chuveiro;
import aulas.a31.classes.ControleTemperatura;
import aulas.a31.classes.Forno;
import aulas.a31.classes.SecadorCabelo;

public class Main {

	public static void main(String[] args) {
		ArrayList<ControleTemperatura> lista = new ArrayList<>();
		
		lista.add(new SecadorCabelo());
		lista.add(new Forno(178, 312));
		lista.add(new Chuveiro(8));
		
		for (ControleTemperatura ct : lista) {
			ct.aumentarTemperatura();
		}
	}
}
