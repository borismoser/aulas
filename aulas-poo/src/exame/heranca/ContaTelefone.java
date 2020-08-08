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
		System.out.println("Conta Telefônica");
		System.out.println("Vencimento: " + this.getVencimento());
		System.out.println("Minutos em ligações locais: " + this.minutosLocais);
		System.out.println("Minutos em ligações de longa distância: " + this.minutosLongaDistancia);
		System.out.println("Valor a pagar: R$ " + this.getValorDevido());
	}
}
