package aulas.a25.aparelhos.modelagem;

import java.util.Objects;

public class Televisor extends Aparelho {

	private int polegadas;
	private int canal = 1;

	public Televisor(String marca, String modelo, int polegadas) {
		super(marca, modelo);
		this.polegadas = polegadas;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		if (isLigado()) {
			if (canal > 999) {
				canal = 1;
			} else if (canal < 1) {
				canal = 999;
			}
			this.canal = canal;
			System.out.println("Novo canal: " + canal);
		} else {
			System.out.println("A TV está desligada!");
		}
	}

	public void canalMais() {
		setCanal(canal + 1);
	}

	public void canalMenos() {
		setCanal(canal - 1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMarca(), getModelo(), polegadas);
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		Televisor other = (Televisor) obj;
		return polegadas == other.polegadas;
	}

	@Override
	public String toString() {
		return String.format("TV %s/%s %d\" Ch:%d", //
				getMarca(), getModelo(), polegadas, canal);
	}

}
