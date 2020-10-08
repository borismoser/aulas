package aulas.a18.p4;

public class PessoaTest {

	public static void main(String[] args) {

		Professor pro = new Professor("Yoda", 950);
		pro.oi();
		pro.explicar("A Força");
		System.out.println();
		Estudante est1 = new Estudante("Luke");
		est1.setIdade(25);
		est1.oi();
		est1.estudar("A Força");
		System.out.println();
		Estudante est2 = new Estudante("Obi-Wan", 33);
		est2.oi();
		est2.estudar("Algoritmos");

		Escola escola = new Escola("Academia Jedi");

		contratacao(escola, pro);
		matricula(escola, est1);
		matricula(escola, est2);
		contratacao(escola, pro);
		matricula(escola, est2);
	}

	private static void contratacao(Escola esc, Professor prof) {
		if (esc.contratar(prof)) {
			System.out.println("Prof. " + prof.getNome() + " contratado com sucesso!");
		} else {
			System.out.println("Prof. " + prof.getNome() + " já faz parte do quadro de professores!");
		}
	}
	
	private static void matricula(Escola esc, Estudante aluno) {
		if (esc.matricular(aluno)) {
			System.out.println("Estudante " + aluno.getNome() + " matriculado com sucesso!");
		} else {
			System.out.println("Estudante " + aluno.getNome() + " já foi matriculado antes!");
		}
	}

}
