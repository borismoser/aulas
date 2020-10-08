package aulas.a18.p2;

public class Professor extends Pessoa {

	public Professor(String nome) {
		super(nome);
	}

	public void explicar(String assunto) {
		System.out.println("Agora vou explicar " + assunto);
	}

}
