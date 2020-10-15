package aulas.a20.contas;

public class ContaMain {

	public static void main(String[] args) {

		Consumidor con = new Consumidor("Cidad�o Pagador de Contas");
		
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
		
		Consumidor con2 = new Consumidor("Outro Cidad�o Pagador de Contas");
		incluir(con2, ce);
	}
	
	private static void incluir(Consumidor consumidor, ContaEletricidade conta) {
		Status st = consumidor.novaConta(conta); 
		if (st == Status.CONTA_ACEITA) {
			System.out.println("Ok, vou pagar essa conta de eletricidade:");
			conta.imprimir();
		} else if (st == Status.CONTA_DUPLICADA) {
			System.out.println("Ops, essa conta de eletricidade eu j� tenho!");
		} else {
			System.out.println("Epa, essa conta n�o � minha!");
		}
	}

	private static void incluir(Consumidor consumidor, ContaAgua conta) {
		Status st = consumidor.novaConta(conta); 
		if (st == Status.CONTA_ACEITA) {
			System.out.println("Ok, vou pagar essa conta de �gua:");
			conta.imprimir();
		} else if (st == Status.CONTA_DUPLICADA) {
			System.out.println("Ops, essa conta de �gua eu j� tenho!");
		} else {
			System.out.println("Epa, essa conta de �gua n�o � minha!");
		}
	}
	
	private static void incluir(Consumidor consumidor, ContaTelefone conta) {
		Status st = consumidor.novaConta(conta); 
		if (st == Status.CONTA_ACEITA) {
			System.out.println("Ok, vou pagar essa conta de telefone:");
			conta.imprimir();
		} else if (st == Status.CONTA_DUPLICADA) {
			System.out.println("Ops, essa conta de telefone eu j� tenho!");
		} else {
			System.out.println("Epa, essa conta de telefone n�o � minha!");
		}
	}
	
}
