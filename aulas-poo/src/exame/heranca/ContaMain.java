package exame.heranca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaMain {

	public static void main(String[] args) {

		List<Conta> contas = new ArrayList<>();
		
		ContaEletricidade ce = new ContaEletricidade(LocalDate.now(), 155.71, 135.99);
		ContaAgua ca = new ContaAgua(LocalDate.now().plusWeeks(1), 88.43, 5.4);
		ContaTelefone ct = new ContaTelefone(LocalDate.now().plusWeeks(2), 75.65, 15, 8);
		
		contas.add(ce);
		contas.add(ca);
		contas.add(ct);
		
		for (Conta c : contas) {
			c.imprimir();
			System.out.println();
		}
	}

}
