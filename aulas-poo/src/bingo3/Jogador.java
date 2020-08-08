package bingo3;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

	private final List<Cartela> cartelas;
	private final List<Integer> idCartelas;
	private boolean vencedor;

	public Jogador() {
		this.cartelas = new ArrayList<>();
		this.idCartelas = new ArrayList<>();
		this.vencedor = false;
	}

	public Jogador(Jogador original) {
		this.cartelas = original.getCartelas();
		this.idCartelas = new ArrayList<>(original.idCartelas);
		this.vencedor = original.vencedor;
	}

	public void addCartela(Cartela cartela) {
		if (idCartelas.contains(cartela.hashCode())) {
			throw new IllegalArgumentException("Jogador já possui a cartela " + cartela);
		}
		cartelas.add(cartela);
		idCartelas.add(cartela.hashCode());
	}

	private List<Cartela> getCartelas() {
		List<Cartela> copia = new ArrayList<>(cartelas.size());
		for (Cartela cart : cartelas) {
			Cartela c = new Cartela(cart);
			copia.add(c);
		}
		return copia;
	}

	public void conferirCartelas(int numero) {
		for (Cartela cart : cartelas) {
			cart.marcarNumero(numero);
			if (cart.ehVencedora()) {
				vencedor = true;
			}
		}
	}

	public boolean bingo() {
		return vencedor;
	}

	public List<Cartela> getCartelasVencedoras() {
		List<Cartela> cartelasVencedoras = new ArrayList<>();
		for (Cartela cart : cartelas) {
			if (cart.ehVencedora()) {
				Cartela c = new Cartela(cart);
				cartelasVencedoras.add(c);
			}
		}
		return cartelasVencedoras;
	}

}
