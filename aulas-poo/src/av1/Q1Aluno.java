package av1;

public class Q1Aluno {
	private String nome;
	private int idade;
	private int matricula;
	
	private static int proximaMatricula = 1000;
	
	public Q1Aluno() {
		this.matricula = proximaMatricula;
		proximaMatricula += 10;
	}

	public boolean ehMaiorIdade() {
		return idade >= 18;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getMatricula() {
		return matricula;
	}

	public String toString() {
		return String.format("Matrícula: %d; Nome: %s; Idade: %d; Maior: %b", 
							getMatricula(), getNome(), getIdade(), ehMaiorIdade());
	}
}