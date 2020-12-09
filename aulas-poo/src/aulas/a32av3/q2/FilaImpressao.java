package aulas.a32av3.q2;

import java.util.ArrayList;

public class FilaImpressao {

	private ArrayList<Imprimivel> fila;
	
	public FilaImpressao() {
		// TODO Auto-generated constructor stub
	}

	public void incluirNaFila(Imprimivel imp) {
		fila.add(imp);
	}
	
	public void imprimirTodos() {
		for (Imprimivel imp : fila) {
			(new Impressora()).imprimir(imp);
		}
	}
}
