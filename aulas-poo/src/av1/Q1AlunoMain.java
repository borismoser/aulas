package av1;

public class Q1AlunoMain {

	public static void main(String[] args) {

		novoAluno("A1", 15);
		novoAluno("A2", 18);
		novoAluno("A3", 22);

	}

	private static void novoAluno(String umNome, int umaIdade) {
		Q1Aluno a = new Q1Aluno();
		a.setNome(umNome);
		a.setIdade(umaIdade);
		System.out.println(a);
	}
}
