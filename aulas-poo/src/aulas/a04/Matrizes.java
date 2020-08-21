package aulas.a04;

import java.util.Arrays;

public class Matrizes {

	public static void main(String[] args) {

		// Declaração completa de um array bidimensional - uma matriz - em uma única
		// linha. Após declarado, não é possível alterar o comprimento das dimensões.

		int[][] m1 = new int[3][4];

		// A propriedade 'length' existe para cada linha e coluna, individualmente.
		// Isso acontece porque um array bidimensional não precisa ser retangular.

		for (int lin = 0; lin < m1.length; lin++) {
			for (int col = 0; col < m1[lin].length; col++) {
				m1[lin][col] = (int) (Math.random() * 100);
			}
		}

		System.out.println("Conteúdo de m1:");
		System.out.println("--------------------");
		for (int lin = 0; lin < m1.length; lin++) {
			for (int col = 0; col < m1[lin].length; col++) {
				System.out.printf("%5d", m1[lin][col]);
			}
			System.out.println();
		}
		System.out.println();

		// Declaração de uma matrix 2x2 com elementos pré-definidos.
		// OS comprimentos não são declarados explicitamente,
		// pois são decorrentes da quantidade de elementos especificados:

		int[][] m2 = { { 1, 2 }, { 4, 3 } };

		System.out.println("Conteúdo de m2:");
		System.out.println("--------------------");
		for (int lin = 0; lin < m2.length; lin++) {
			for (int col = 0; col < m2[lin].length; col++) {
				System.out.printf("%5d", m2[lin][col]);
			}
			System.out.println();
		}
		System.out.println();

		// Declaração de uma matriz irregular,
		// em que nem todas as colunas têm o mesmo comprimento:

		int[][] m3 = new int[2][]; // alocação de 2 linhas
		m3[0] = new int[5]; // alocação de 5 colunas na linha 0
		m3[1] = new int[3]; // alocação de 3 colunas na linha 1

		for (int i = 0; i < m3.length; i++) {
			for (int j = 0; j < m3[i].length; j++) {
				m3[i][j] = (int) (Math.random() * 100);
			}
		}

		System.out.println("Conteúdo de m3:");
		System.out.println("--------------------------");
		for (int lin = 0; lin < m3.length; lin++) {
			for (int col = 0; col < m3[lin].length; col++) {
				System.out.printf("%5d", m3[lin][col]);
			}
			System.out.println();
		}
		System.out.println();

		// A classe "Arrays" também lida com objetos multidimensionais,
		// porém o comportamento e os métodos podem diferir dos unidimensionais:

		// Obtendo um String com os elementos de array multidimensional:
		String texto = Arrays.deepToString(m1);
		System.out.println("Conteúdo de m1: " + texto);
		texto = Arrays.deepToString(m2);
		System.out.println("Conteúdo de m2: " + texto);
		texto = Arrays.deepToString(m3);
		System.out.println("Conteúdo de m3: " + texto);

		// A cópia deve tratar cada dimensão individualmente:
		int[][] m4 = Arrays.copyOf(m2, m2.length);
		m4[0] = Arrays.copyOf(m2[0], m2[0].length);
		m4[1] = Arrays.copyOf(m2[1], m2[1].length);
		texto = Arrays.deepToString(m4);
		System.out.println("Conteúdo de m4: " + texto);

		// A igualdade de conteúdo deve utilizar 'deepEquals()':
		System.out.println("m2 e m4 são iguais? " + Arrays.deepEquals(m2, m4));

		// A classificação pode ser feita dimensões simples:
		Arrays.sort(m4[1]);
		texto = Arrays.deepToString(m4);
		System.out.println("Conteúdo de m4: " + texto);

		System.out.println("m2 e m4 são iguais? " + Arrays.deepEquals(m2, m4));
		System.out.println(Arrays.equals(m2[0], m4[0]));
		System.out.println(Arrays.equals(m2[1], m4[1]));
	}

}
