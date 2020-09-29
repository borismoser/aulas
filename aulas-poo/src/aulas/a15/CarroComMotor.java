package aulas.a15;

public class CarroComMotor {

	private String modelo;
	private int ano;
	private double velocidadeAtual;
	private TipoMotor tipoMotor;

	public CarroComMotor(String modelo, int ano, TipoMotor tipoMotor) {
		this.modelo = modelo;
		this.ano = ano;
		this.tipoMotor = tipoMotor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setTipoMotor(TipoMotor tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	public TipoMotor getTipoMotor() {
		return tipoMotor;
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
	
	@Override
	public String toString() {
		return this.getModelo() + " " + this.getAno() + " : " + this.getTipoMotor();
	}
}
