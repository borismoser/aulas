package aulas.a32av3.q2;

public class MainApp {

	public static void main(String[] args) throws Exception {
		FilaImpressao fi = new FilaImpressao();
		Arquivo arq = new Arquivo("teste.txt");
		arq.setConteudo("abc-123");
		fi.incluirNaFila(arq);
		fi.incluirNaFila(new ContaBancaria("Boris Moser", 1666.66));
		fi.incluirNaFila(new Sequencia(-5, 11));
		fi.imprimirTodos();
	}

}
