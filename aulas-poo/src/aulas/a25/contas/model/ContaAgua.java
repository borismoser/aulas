package aulas.a25.contas.model;

import java.util.Objects;

public class ContaAgua extends Conta {

	private double metrosCubicos;

	public ContaAgua(Consumidor consumidor, double valorDevido, double metrosCubicos) {
		super(consumidor, valorDevido);
		this.metrosCubicos = metrosCubicos;
	}

	@Override
	public void imprimir() {
		System.out.println("Conta de Água");
		System.out.println("Consumidor: " + this.getConsumidor().getNome());
		System.out.println("Consumo: " + this.metrosCubicos + " metros cúbicos");
		System.out.println("Valor a pagar: R$ " + this.getValorDevido());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getConsumidor(), getValorDevido(), metrosCubicos);
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
		ContaAgua outraConta = (ContaAgua) obj;
		return metrosCubicos == outraConta.metrosCubicos && //
				this.getValorDevido() == outraConta.getValorDevido() && //
				Objects.equals(getConsumidor(), outraConta.getConsumidor());
	}

}
