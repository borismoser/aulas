package aulas.a32av3.gabarito.q2;

public class MainApp {

	public static void main(String[] args) {
		FilaImpressao fi = new FilaImpressao();
		Arquivo arq = new Arquivo("teste.txt");
		arq.setConteudo("abc-123");
		fi.incluirNaFila(arq);
		fi.incluirNaFila(new ContaBancaria("eu", 666.66));
		fi.incluirNaFila(new Sequencia(2, 11));
		fi.imprimirTodos();
	}

}
