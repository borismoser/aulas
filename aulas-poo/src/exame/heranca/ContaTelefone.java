package exame.heranca;

import java.time.LocalDate;

public class ContaTelefone extends Conta{

	private int minutosLocais;
	private int minutosLongaDistancia;

	public ContaTelefone(LocalDate vencimento, double valorDevido, int minutosLocais, int minutosLongaDistancia) {
		super(vencimento, valorDevido);
		this.minutosLocais = minutosLocais;
		this.minutosLongaDistancia = minutosLongaDistancia;
	}
	
	@Override
	public void imprimir() {
		System.out.println("Conta Telef�nica");
		System.out.println("Vencimento: " + this.getVencimento());
		System.out.println("Minutos em liga��es locais: " + this.minutosLocais);
		System.out.println("Minutos em liga��es de longa dist�ncia: " + this.minutosLongaDistancia);
		System.out.println("Valor a pagar: R$ " + this.getValorDevido());
	}
}
