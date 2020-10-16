package aulas.a20.contas;

import java.util.ArrayList;
import java.util.Objects;

public class Consumidor {

	private String nome;

	private ArrayList<ContaEletricidade> eletricidade = new ArrayList<>();
	private ArrayList<ContaTelefone> telefone = new ArrayList<>();
	private ArrayList<ContaAgua> agua = new ArrayList<>();

	public Consumidor(String nome) {
		this.nome = Objects.requireNonNull(nome);
	}

	public String getNome() {
		return nome;
	}

	public Status novaConta(ContaEletricidade ce) {
		if (!this.equals(ce.getConsumidor()))
			return Status.CONSUMIDOR_INCORRETO;
		if (eletricidade.contains(ce))
			return Status.CONTA_DUPLICADA;
		eletricidade.add(ce);
		return Status.CONTA_ACEITA;
	}

	public Status novaConta(ContaTelefone ct) {
		if (!this.equals(ct.getConsumidor()))
			return Status.CONSUMIDOR_INCORRETO;
		if (telefone.contains(ct))
			return Status.CONTA_DUPLICADA;
		telefone.add(ct);
		return Status.CONTA_ACEITA;
	}

	public Status novaConta(ContaAgua ca) {

		if (!this.equals(ca.getConsumidor()))
			return Status.CONSUMIDOR_INCORRETO;

		if (agua.contains(ca))
			return Status.CONTA_DUPLICADA;

		agua.add(ca);
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
