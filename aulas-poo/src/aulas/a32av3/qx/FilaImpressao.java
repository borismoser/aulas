package aulas.a32av3.qx;

import java.util.ArrayList;

public class FilaImpressao {

	private ArrayList<Imprimivel> fila;
	
	public FilaImpressao() {
		// TODO Auto-generated constructor stub
	}

	public void imprimirTodos() {
		for (Imprimivel imp : fila) {
			(new Impressora()).imprimir(imp);
		}
	}
}
