package aulas.a19.dindin;

public class DinheiroMain {

	public static void main(String[] args) {

		Dinheiro receita = new Dinheiro(500, "R$");
		Dinheiro despesa = new Dinheiro(500, "R$");

		if (receita.equals(despesa)) {
			System.out.println("Orçamento equilibrado.");
		}

		System.out.println(receita + " " + receita.hashCode());
		System.out.println(despesa + " " + despesa.hashCode());
	}

}
