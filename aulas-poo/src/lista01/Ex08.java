package lista01;

public class Ex08 {

	public static void main(String[] args) {
		int tabuada = Ex00.lerInt("Informe a tabuada que deseja exibir: ");
		int inicio = Ex00.lerInt("Início da tabuada: ");
		int fim = Ex00.lerInt("Final da tabuada: ");

		for (int i=inicio; i<=fim; i++) {
			System.out.printf("%d x %d = %d %n", tabuada, i, tabuada*i);
		}

	}

}
