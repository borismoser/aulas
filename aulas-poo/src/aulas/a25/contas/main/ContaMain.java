package aulas.a25.contas.main;

import aulas.a25.contas.model.Consumidor;
import aulas.a25.contas.model.Conta;
import aulas.a25.contas.model.ContaAgua;
import aulas.a25.contas.model.ContaEletricidade;
import aulas.a25.contas.model.ContaTelefone;
import aulas.a25.contas.model.Status;

public class ContaMain {

	public static void main(String[] args) {

		Consumidor con = new Consumidor("Cidadão Pagador de Contas");

		ContaEletricidade ce = new ContaEletricidade(con, 155.71, 135.99);
		ContaAgua ca = new ContaAgua(con, 88.43, 5.4);
		ContaTelefone ct = new ContaTelefone(con, 75.65, 15, 8);

		incluir(con, ce);
		incluir(con, ca);
		incluir(con, ct);

		ce = new ContaEletricidade(con, 185.00, 215.11);
		ca = new ContaAgua(con, 97.50, 8.5);
		ct = new ContaTelefone(con, 275.65, 115, 58);

		incluir(con, ce);
		incluir(con, ca);
		incluir(con, ct);

		ce = new ContaEletricidade(con, 185.00, 215.11);
		incluir(con, ce);

		Consumidor con2 = new Consumidor("Outro Pagador de Contas");
		incluir(con2, ce);
	}

	private static void incluir(Consumidor consumidor, Conta conta) {
		Status st = consumidor.novaConta(conta);
		if (st == Status.CONTA_ACEITA) {
			System.out.println("Ok, vou pagar essa conta:");
			conta.imprimir();
		} else if (st == Status.CONTA_DUPLICADA) {
			System.out.println("Ops, essa conta eu já tenho!");
		} else {
			System.out.println("Epa, essa conta não é minha!");
		}
	}

}
