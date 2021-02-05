package aulas.a32av3.gabarito.q2;

import java.util.ArrayList;

public class FilaImpressao {

	private ArrayList<Imprimivel> fila;

	public FilaImpressao() {
		fila = new ArrayList<>();
	}

	public void incluirNaFila(Imprimivel imp) {
		fila.add(imp);
	}

	public void imprimirTodos() {
		Impressora prn = new Impressora();
		for (Imprimivel imp : fila) {
			prn.imprimir(imp);
		}
	}
}
