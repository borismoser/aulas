package aulas.a32av3.q1;

import java.util.Random;

public class App {

	public static void main(String[] args) {

		Random rd = new Random();

		Fabrica f = new Fabrica("Pirata");

		int x;
		for (int i = 0; i < 100; i++) {
			x = rd.nextInt(3);
			switch (x) {
			case 0:
				f.construirVeiculoCorrida("F1", 350.0);
				break;
			case 1:
				f.construirVeiculoCarga("F1000", 1200);
				break;
			case 2:
				f.construirVeiculoTransporte("Kombi", 15);
			}
		}
		
		System.out.println("Quantidade de veículos de carga: " + f.qtVeiculosCarga());
		System.out.println("Quantidade de veículos de corrida: " + f.qtVeiculosCorrida());
		System.out.println("Quantidade de veículos de transporte: " + f.qtVeiculosTransporte());

	}

}
