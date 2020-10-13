package aulas.a19.p5;

public class App {

	public static void main(String[] args) {

		Professor prof1 = new Professor("Yoda", 950);
		prof1.oi();
		prof1.explicar("A Força");
		System.out.println();

		Estudante est1 = new Estudante("Luke");
		est1.setIdade(25);
		est1.oi();
		est1.estudar("A Força");
		System.out.println();

		Estudante est2 = new Estudante("Obi-Wan", 33);
		est2.oi();
		est2.estudar("Algoritmos");
		System.out.println();

		Escola escola = new Escola("Academia Jedi");

		contratacao(escola, prof1);
		matricula(escola, est1);
		matricula(escola, est2);
		System.out.println();

		contratacao(escola, prof1);
		Professor prof2 = new Professor("Yoda", 950);
		contratacao(escola, prof2);

		Estudante est3 = new Estudante("Obi-Wan", 33);
		matricula(escola, est3);

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
