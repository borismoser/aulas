package aulas.a07;

import java.util.Scanner;

public class CarroVetor {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);

		Carro[] cars = new Carro[3];
		Carro c;
		String modelo;
		int ano;

		for (int i = 0; i < cars.length; i++) {

			System.out.print("Informe o modelo do carro: ");
			modelo = ler.nextLine();

			System.out.print("Informe o ano do carro: ");
			ano = ler.nextInt();
			ler.nextLine(); // consumir o ENTER após inserir o ano.

			c = new Carro(modelo, ano);
			cars[i] = c;
		}

		System.out.println();
		// Acessando os carros no vetor por meio de seus índices:
		for (int i = 0; i < cars.length; i++) {

			infoCarro(cars[i]);

			// acelerar o carro armazenado na posição i:
			cars[i].acelerar(Math.random() * 100);

			// atualizar o modelo para letras maiúsculas
			cars[i].setModelo(cars[i].getModelo().toUpperCase());
		}

		System.out.println();
		// Acessando sequencialmente os carros no vetor sem conhecer seus índices:
		for (Carro cc : cars) {
			infoCarro(cc);
			cc.reduzir(Math.random() * 100);
		}

		// Acessando diretamente cada carro dentro do vetor:
		System.out.println();
		infoCarro(cars[0]);
		infoCarro(cars[1]);
		infoCarro(cars[2]);

	}

	private static void infoCarro(Carro car) {
		System.out.printf("%s %d", car.getModelo(), car.getAno());
		if (car.carroParado()) {
			System.out.print(" não está em movimento.");
		} else {
			System.out.printf(" está se movendo a %.2f km/h.", car.getVelocidadeAtual());
		}
		System.out.println();
	}
}
