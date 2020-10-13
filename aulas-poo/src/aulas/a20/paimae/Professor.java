package aulas.a20.paimae;

public class Professor extends Pessoa {

	public Professor(String nome, int idade) {
		super(nome, idade);
	}

	public void explicar(String assunto) {
		System.out.println("Agora vou explicar " + assunto);
	}

}
