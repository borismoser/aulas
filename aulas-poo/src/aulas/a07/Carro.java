package aulas.a07;

public class Carro {

	private String modelo;
	private int ano;
	private double velocidadeAtual;

	public Carro(String modelo, int ano) {
		this.modelo = modelo;
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	// O ano de um carro não pode ser alterado para menos de 1900.
	public void setAno(int ano) {
		if (ano >= 1900) {
			this.ano = ano;
		}
	}

	public double getVelocidadeAtual() {
		return velocidadeAtual;
	}

	// A velocidade a aumentar deve ser positiva.
	public void acelerar(double kmh) {
		if (kmh > 0.0) {
			velocidadeAtual += kmh;
		}
	}

	// A velocidade a diminuir deve ser positiva,
	// porém a velocidade atual não pode ficar negativa. 
	public void reduzir(double kmh) {
		if (kmh > 0.0 && kmh <= velocidadeAtual) {
			velocidadeAtual -= kmh;
		}
	}

	// O carro está parado quando sua velocidade for igual a zero.
	public boolean carroParado() {
		return velocidadeAtual == 0;
	}
}
