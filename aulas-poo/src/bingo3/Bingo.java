package bingo3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bingo {
	private List<Integer> idCartelas;
	private List<Jogador> jogadores;

	private List<Jogador> vencedores;
	private List<Integer> globo;
	private List<Integer> numerosSorteados;
	private SecureRandom sr = new SecureRandom();
	private BingoStatus bingoStatus;

	public Bingo(int qtdJogadores, int qtdCartelasPorJogador) {
		this.bingoStatus = BingoStatus.preGame;
		System.out.println(bingoStatus.getMensagem());
		this.jogadores = new ArrayList<>(qtdJogadores);
		this.idCartelas = new ArrayList<>(qtdJogadores * qtdCartelasPorJogador);
		for (int i = 0; i < qtdJogadores; i++) {
			novoJogador(qtdCartelasPorJogador);
		}
		this.vencedores = new ArrayList<>();
		this.globo = new ArrayList<>(75);
		this.numerosSorteados = new ArrayList<>(75);
	}

	private void novoJogador(int qtdCartelas) {
		Jogador jogador = new Jogador();
		this.jogadores.add(jogador);
		for (int i = 0; i < qtdCartelas; i++) {
			novaCartela(jogador);
		}
	}

	private void novaCartela(Jogador jog) {
		if (!jogadores.contains(jog)) {
			throw new IllegalArgumentException("Jogador não pertence ao Bingo!");
		}
		Cartela cartela;
		do {
			cartela = new Cartela();
		} while (idCartelas.contains(cartela.hashCode()));
		jog.addCartela(cartela);
		idCartelas.add(cartela.hashCode());
	}

	public void simular() {
		if (jogadores.size() == 0) {
			throw new IllegalStateException("Nenhum jogador participando do Bingo!");
		}

		this.bingoStatus = BingoStatus.inGame;
		System.out.println(bingoStatus.getMensagem());

		for (int i = 0; i < 75; i++) {
			globo.add(i + 1);
		}
		Collections.shuffle(globo);

		int n;
		do {
			n = sorteia();
			verificaVencedor(n);
		} while (vencedores.size() == 0);

		this.bingoStatus = BingoStatus.postGame;
		System.out.println(bingoStatus.getMensagem());

	}

	private void verificaVencedor(int numero) {
		for (Jogador jog : jogadores) {
			jog.conferirCartelas(numero);
			if (jog.bingo()) {
				vencedores.add(jog);
			}
		}
	}

	private int sorteia() {
		int n = sr.nextInt(globo.size());
		numerosSorteados.add(globo.get(n));
		globo.remove(n);
		return numerosSorteados.get(numerosSorteados.size() - 1);
	}

	public List<Jogador> getVencedores() {
		return new ArrayList<>(vencedores);
	}

	public List<Integer> getNumerosSorteados() {
		return new ArrayList<>(numerosSorteados);
	}

}
