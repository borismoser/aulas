package aulas.a17.semheranca;

public class ContasSemHeranca {

	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente("eu", 500);
		cc.depositar(1000);
		cc.sacar(300);
		cc.setLimite(-1000);
		cc.sacar(2000);
		System.out.println("Saldo em conta corrente: " + cc.getSaldo());
		
		ContaPoupanca cp = new ContaPoupanca("tu", 15);
		cp.depositar(750);
		cp.sacar(600);
		System.out.println("Saldo em conta poupança: " + cp.getSaldo());
	}

}
