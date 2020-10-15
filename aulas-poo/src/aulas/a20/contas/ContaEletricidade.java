package aulas.a20.contas;

import java.util.Objects;

public class ContaEletricidade extends Conta {

	private double kilowatts;

	public ContaEletricidade(Consumidor consumidor, double valorDevido, double kilowatts) {
		super(consumidor, valorDevido);
		this.kilowatts = kilowatts;
	}

	@Override
	public void imprimir() {
		System.out.println("Conta de Eletricidade");
		System.out.println("Consumidor: " + this.getConsumidor().getNome());
		System.out.println("Consumo: " + this.kilowatts + " kw");
		System.out.println("Valor a pagar: R$ " + this.getValorDevido());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getConsumidor(), kilowatts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ContaEletricidade outraConta = (ContaEletricidade) obj;
		return kilowatts == outraConta.kilowatts && //
				Objects.equals(getConsumidor(), outraConta.getConsumidor());
	}

}