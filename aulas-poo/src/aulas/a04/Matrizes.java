package aulas.a04;

public class Matrizes {

	public static void main(String[] args) {

		// declara��o de uma matrix 3x4
		int[][] m = new int[3][4];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = (int) (Math.random() * 100);
			}
		}
		mostrarMatrizTabela(m);

		// declara��o de uma matrix 2x2
		int[][] b = { { 1, 2 }, { 3, 4 } };
		mostrarMatrizTabela(b);

		// declara��o de uma matriz irregular
		int[][] c = new int[2][]; // cria��o de 2 linhas
		c[0] = new int[5]; // cria��o de 5 colunas na linha 0
		c[1] = new int[3]; // cria��o de 3 colunas na linha 1
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = (int) (Math.random() * 100);
			}
		}
		mostrarMatrizTabela(c);

		mostrarVetorTabelaVar(1, 2, 3, 4, 5, 6);

	}

	private static void mostrarVetorTabela(int[] v) {
		System.out.printf("%6s%8s%n", "�ndice", "Valor");
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%6d%8d%n", i, v[i]);
		}
	}

	private static void mostrarVetorTabelaVar(int... v) {
		System.out.printf("%6s%8s%n", "�ndice", "Valor");
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%6d%8d%n", i, v[i]);
		}
	}

	private static void mostrarMatrizTabela(int[][] w) {
		System.out.println("--------------------");
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w[i].length; j++) {
				System.out.printf("%5d", w[i][j]);
			}
			System.out.println();
		}
	}

}
