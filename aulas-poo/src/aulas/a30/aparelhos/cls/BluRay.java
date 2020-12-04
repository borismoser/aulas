package aulas.a30.aparelhos.cls;

public class BluRay extends Aparelho implements ControlarReproducao {

	private String titulo;
	private int status = PARADO;

	private static final int PARADO = 0;
	private static final int EM_PAUSA = 1;
	private static final int TOCANDO = 2;

	public BluRay(String marca, String modelo) {
		super(marca, modelo);
	}

	public void inserirDisco(String titulo) {
		if (!isLigado()) {
			System.out.println("O aparelho está desligado!");
			return;
		}
		if (this.titulo != null) {
			System.out.println("Já há um disco no aparelho!");
			return;
		}
		if (titulo == null) {
			System.out.println("Não há disco para inserir!");
			return;
		}
		this.titulo = titulo;
		System.out.println("Disco inserido: " + titulo);
	}

	@Override
	public void play() {
		if (!isLigado()) {
			System.out.println("O aparelho está desligado!");
			return;
		}
		if (titulo == null) {
			System.out.println("Não há disco para reproduzir!");
			return;
		}
		if (status == TOCANDO) {
			System.out.println("O disco já está sendo reproduzido!");
		} else if (status == EM_PAUSA) {
			System.out.println("Continuando a reprodução do disco.");
		} else {
			System.out.println("Iniciando a reprodução do título " + titulo);
			status = TOCANDO;
		}
	}

	@Override
	public void pause() {
		if (!isLigado()) {
			System.out.println("O aparelho está desligado!");
			return;
		}
		if (titulo == null) {
			System.out.println("Não há disco no aparelho!");
			return;
		}
		if (status == TOCANDO) {
			System.out.println("Colocando o disco em pausa!");
			status = EM_PAUSA;
		} else if (status == EM_PAUSA) {
			System.out.println("Continuando a reprodução do disco.");
			status = TOCANDO;
		} else {
			System.out.println("O disco está parado!");
		}
	}

	@Override
	public void stop() {
		if (!isLigado()) {
			System.out.println("O aparelho está desligado!");
			return;
		}
		if (titulo == null) {
			System.out.println("Não há disco no aparelho!");
			return;
		}
		if (status == TOCANDO || status == EM_PAUSA) {
			System.out.println("Interrompendo a reprodução do disco!");
			status = PARADO;
		} else {
			System.out.println("O disco está parado!");
		}
	}

	public void eject() {
		if (isLigado()) {
			if (titulo == null) {
				System.out.println("Não há disco para ejetar!");
			} else {
				System.out.println("Ejetando o disco: " + titulo);
				status = PARADO;
				titulo = null;
			}
		} else {
			System.out.println("O aparelho está desligado!");
		}
	}
}
