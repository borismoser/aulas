package aulas.a19.contas;

import java.util.ArrayList;

public class ContaMain {

	public static void main(String[] args) {

		ArrayList<Conta> contas = new ArrayList<>();
		
		Consumidor con = new Consumidor("Fulano Cidadão");
		ContaEletricidade ce = new ContaEletricidade(con, 155.71, 135.99);
		ContaAgua ca = new ContaAgua(con, 88.43, 5.4);
		ContaTelefone ct = new ContaTelefone(con, 75.65, 15, 8);
		
		contas.add(ce);
		contas.add(ca);
		contas.add(ct);
		
		for (Conta c : contas) {
			c.imprimir();
			System.out.println();
		}
	}

}
