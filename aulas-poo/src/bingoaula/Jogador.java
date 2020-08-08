package bingoaula;

import java.util.ArrayList;

public class Jogador {

	private ArrayList<Cartela> cartelas;
	private ArrayList<Integer> idCartelasJogador;

	public Jogador(int qtdCartelas) {
		this.cartelas = new ArrayList<>(qtdCartelas);
		this.idCartelasJogador = new ArrayList<>(qtdCartelas);
		Cartela cartela;
		for (int i = 0; i < qtdCartelas; i++) {
			int hash;
			do {
				cartela = new Cartela();
				hash = cartela.getNumeros().hashCode();
			} while (idCartelasJogador.contains(hash));
			cartelas.add(cartela);
			idCartelasJogador.add(hash);
		}

	}

	public ArrayList<Cartela> getCartelas() {
		return cartelas;
	}
	
	public ArrayList<Integer> getIdCartelasJogador() {
		return idCartelasJogador;
	}

}
