package aulas.a18.p2;

public class Estudante extends Pessoa {

	public Estudante(String nome) {
		super(nome);
	}

	public void estudar(String assunto) {
		System.out.println("Agora vou estudar " + assunto + ".");
	}

}
