package aulas.a07;

public class CarroMain {

	public static void main(String[] args) {

		Carro carroA = new Carro("Ferrari GTO", 1975);
		infoCarro(carroA);

		carroA.setAno(1992);
		carroA.setModelo("Monza SLE");
		infoCarro(carroA);

		carroA.acelerar(120);
		infoCarro(carroA);
		carroA.reduzir(80.5);
		infoCarro(carroA);

		Carro carroB = new Carro("Marea Turbo", 1999);
		infoCarro(carroB);
		carroB.acelerar(85);
		infoCarro(carroB);
		carroB.acelerar(48);
		infoCarro(carroB);

	}

	private static void infoCarro(Carro car) {
		System.out.print(car.getModelo() + " " + car.getAno());
		if (car.carroParado()) {
			System.out.println(" não está em movimento.");
		} else {
			System.out.println(" está se movendo a " + car.getVelocidadeAtual() + " km/h");
		}
	}
}
