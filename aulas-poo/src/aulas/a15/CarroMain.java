package aulas.a15;

import java.util.ArrayList;
import java.util.Scanner;

public class CarroMain {

	public static void main(String[] args) {

		ArrayList<CarroComMotor> carros = new ArrayList<>();

		carros.add(new CarroComMotor("Civic", 2020, TipoMotor.COMBUSTAO));
		carros.add(new CarroComMotor("Prius", 2017, TipoMotor.HIBRIDO));
		carros.add(new CarroComMotor("BMW i3", 2016, TipoMotor.ELETRICO));
		carros.add(new CarroComMotor("Audi A4", 2019, TipoMotor.COMBUSTAO));
		carros.add(new CarroComMotor("Fusion Hybrid", 2015, TipoMotor.HIBRIDO));
		carros.add(new CarroComMotor("Nissan Leaf", 2018, TipoMotor.ELETRICO));

		System.out.println("Listar os carros com qual tipo de motor?");
		System.out.println("1-Combustão");
		System.out.println("2-Elétrico");
		System.out.println("3-Híbrido");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		TipoMotor tipo;
		int opcao;
		do {
			System.out.print("Escolha uma opção:");
			opcao = sc.nextInt();
		} while (opcao < 1 || opcao > 3);
		if (opcao == 1) {
			tipo = TipoMotor.COMBUSTAO;
		} else if (opcao == 2) {
			tipo = TipoMotor.ELETRICO;
		} else {
			tipo = TipoMotor.HIBRIDO;
		}

		// Listar somente os carros do tipo escolhido
		for (CarroComMotor c : carros) {
			if (c.getTipoMotor() == tipo) {
				System.out.println(c);
			}
		}

		// Contar os carros por tipo de motor
		int qtC = 0;
		int qtE = 0;
		int qtH = 0;
		for (CarroComMotor c : carros) {
			// enumerações também podem ser utilizadas no switch/case:
			switch (c.getTipoMotor()) {
			case COMBUSTAO:
				qtC++;
				break;
			case ELETRICO:
				qtE++;
				break;
			case HIBRIDO:
				qtH++;
				break;
			}
		}
		System.out.println();
		// Ao exibir uma enumeração, automaticamente é utilizado seu método toString()
		System.out.println(TipoMotor.COMBUSTAO + ": " + qtC);
		System.out.println(TipoMotor.ELETRICO + ": " + qtE);
		System.out.println(TipoMotor.HIBRIDO + ": " + qtH);
	}

}
