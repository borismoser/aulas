package aulas.a30.aparelhos.cls;

import java.util.ArrayList;
import java.util.Random;

public class MP3Player extends Aparelho implements ControlarReproducao {

	private int capacidade;
	private ArrayList<String> musicas;
	private int selecionada;
	private boolean tocando;

	public MP3Player(String marca, String modelo, int capacidade) {

		super(marca, modelo);
		this.capacidade = capacidade;
		this.musicas = new ArrayList<>();
		this.selecionada = -1;
		this.tocando = false;
	}

	@Override
	public void play() {
		if (selecionada >= 0) {
			tocando = true;
			System.out.println("Tocando música: " + musicas.get(selecionada));
		} else {
			System.out.println("Nenhuma música selecionada.");
		}
	}

	@Override
	public void pause() {
		if (tocando) {
			tocando = false;
			System.out.println("Pausa na música: " + musicas.get(selecionada));
		} else {
			System.out.println("Nenhuma música em reprodução.");
		}
	}

	@Override
	public void stop() {
		if (tocando) {
			tocando = false;
			System.out.println("Música interrompida: " + musicas.get(selecionada));
		} else {
			System.out.println("Nenhuma música em reprodução.");
		}
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int carregarMusica(String titulo) {
		if (musicas.size() < capacidade) {
			musicas.add(titulo);
			return musicas.size();
		}
		return -1;
	}

	public int selecionarMusicaAleatoria() {
		if (musicas.size() > 0) {
			Random rd = new Random();
			int m = rd.nextInt(musicas.size());
			selecionarMusica(m);
			return m;
		}
		return -1;
	}

	public void selecionarMusica(int musica) {
		if ((musica >= 0) && (musica < musicas.size())) {
			selecionada = musica;
			System.out.println("Música selecionada: " //
					+ musica + " - " + musicas.get(selecionada));
		} else {
			System.out.println("Não é possível selecionar a música: " + musica);

		}
	}

	public void proxima() {
		selecionarMusica(selecionada + 1);
	}

	public void anterior() {
		selecionarMusica(selecionada - 1);
	}
}
