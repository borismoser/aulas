package aulas.a30.aparelhos.cls;

import java.util.Objects;

public class Televisor extends Aparelho implements ControlarCanal {

	private int polegadas;
	private int canal = 1;

	public Televisor(String marca, String modelo, int polegadas) {
		super(marca, modelo);
		this.polegadas = polegadas;
	}

	@Override
	public int getCanal() {
		return canal;
	}

	@Override
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

	@Override
	public void canalMais() {
		setCanal(canal + 1);
	}

	@Override
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
