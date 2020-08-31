package aulas.a07;

public class SalarioApp {

	public static void main(String[] args) {

		Vendedor bg = new Vendedor("Bill Gates", 3000, 15);
		Vendedor em = new Vendedor("Elon Musk", 1500, 25);
		Vendedor jb = new Vendedor("Jeff Bezos", 2500, 12.5);

		novaVenda(bg, 2000);
		novaVenda(em, 900);
		novaVenda(jb, 555);

		mostrarFolhaPagamento(bg);
		mostrarFolhaPagamento(em);
		mostrarFolhaPagamento(jb);

	}

	private static void novaVenda(Vendedor vend, double valor) {
		vend.incluirVenda(valor);
	}

	private static void mostrarFolhaPagamento(Vendedor vend) {
		System.out.println();
		System.out.println("Funcionário            Fixo     Comissão        Total");
		System.out.println("----------------   --------     --------    ---------");
		System.out.printf("%-16s %,10.2f   %,10.2f %,12.2f  %n", //
				vend.getNome(), vend.getSalarioFixo(), vend.totalComissao(), vend.totalSalario());
	}

}
