package aulas.a18.p4;

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
			if (aluno.getNome().equalsIgnoreCase(est.getNome())) {
				return false;
			}
		}
		return estudantes.add(aluno);
	}

	public boolean contratar(Professor prof) {
		for (Professor p : professores) {
			if (prof.getNome().equalsIgnoreCase(p.getNome())) {
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
