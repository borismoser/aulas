package aulas.a20.paimae;

import java.util.ArrayList;

public class Escola {

	private String nomeEscola;
	private ArrayList<Professor> professores;
	private ArrayList<Estudante> estudantes;

	public Escola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
		this.professores = new ArrayList<>();
		this.estudantes = new ArrayList<>();
	}

	public boolean matricular(Estudante aluno) {
		for (Estudante est : estudantes) {
			if (aluno.equals(est)) {
				return false;
			}
		}
		return estudantes.add(aluno);
	}

	public boolean contratar(Professor prof) {
		for (Professor p : professores) {
			if (prof.equals(p)) {
				return false;
			}
		}
		return professores.add(prof);
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public ArrayList<Estudante> getEstudantes() {
		return estudantes;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

}
