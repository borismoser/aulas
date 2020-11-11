package aulas.a25.contas.model;

import java.util.ArrayList;
import java.util.Objects;

public class Consumidor {

	private String nome;

	private ArrayList<Conta> contas = new ArrayList<>();

	public Consumidor(String nome) {
		this.nome = Objects.requireNonNull(nome);
	}

	public String getNome() {
		return nome;
	}

	public Status novaConta(Conta conta) {
		if (!this.equals(conta.getConsumidor()))
			return Status.CONSUMIDOR_INCORRETO;
		if (contas.contains(conta))
			return Status.CONTA_DUPLICADA;
		contas.add(conta);
		return Status.CONTA_ACEITA;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor outroConsumidor = (Consumidor) obj;
		return Objects.equals(this.nome, outroConsumidor.nome);
	}

	@Override
	public String toString() {
		return "Consumidor [nome=" + nome + "]";
	}

}
