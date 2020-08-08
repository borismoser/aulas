package bingo;

import java.util.ArrayList;

public class JogadorDeBingo {
	private ArrayList<CartelaDeBingo> cartelas;

	public JogadorDeBingo() {
		this.cartelas = new ArrayList<>();
	}

	public JogadorDeBingo(int quantidadeCartelas) {
		if (quantidadeCartelas <= 0) {
			throw new IllegalArgumentException("A quantidade de cartelas por jogador deve ser maior que zero.");
		}
		this.cartelas = new ArrayList<>(quantidadeCartelas);
	}
	
	public ArrayList<CartelaDeBingo> getCartelas() {
		return cartelas;
	}

	public boolean ehVencedor(ArrayList<Integer> numerosSorteados) {
		boolean vencedor = false;
		for (CartelaDeBingo cart : this.cartelas) {
			if (cart.ehVencedora(numerosSorteados)) {
				vencedor = true;
			}
		}
		return vencedor;
	}

}
