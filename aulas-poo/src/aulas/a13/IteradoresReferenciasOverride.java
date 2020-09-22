package aulas.a13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class IteradoresReferenciasOverride {

	public static void main(String[] args) {

		final int QT_APOSTAS = 100;

		System.out.printf("Simulando um concurso com %d apostas:%n%n", QT_APOSTAS);

		int qt;
		ALAposta ap;
		Random rd = new Random();

		// lista contendo todas as apostas simuladas:
		ArrayList<ALAposta> apostas = new ArrayList<>(QT_APOSTAS);
		for (int i = 0; i < QT_APOSTAS; i++) {
			qt = 6 + rd.nextInt(10);
			ap = new ALAposta("Aposta " + i + "/" + qt, qt);
			apostas.add(ap);
		}

		// Sorteia e exibe o resultado oficial do concurso:
		System.out.println("Números sorteados: " + ALConcurso.numerosSorteados());
		System.out.println();

		int[] resumo = new int[3]; // Totais por quantidade de acertos

		// Utilizando um Iterator para percorrer a lista de apostas.
		// Iterator é uma classe com recursos para navegar em uma coleção de elementos.
		// O método hasNext() nos diz se ainda existem elementos não lidos na coleção.
		// O método next() retorna o próximo elemento não lido.

		Iterator<ALAposta> it = apostas.iterator();
		while (it.hasNext()) {
			ap = it.next();
			qt = ALConcurso.quantidadeAcertos(ap);
			if (qt >= 4) {
				System.out.println("" + qt + " acertos: " + ap);
				resumo[qt - 4]++;
			}
		}
		System.out.println();
		System.out.println("4 acertos: " + resumo[0] + " apostadores.");
		System.out.println("5 acertos: " + resumo[1] + " apostadores.");
		System.out.println("6 acertos: " + resumo[2] + " apostadores.");

		// O 'for' utilizado abaixo faz a mesma coisa que o iterator acima.
		// Esse tipo de for, quando aplicado em coleções, também utiliza
		// um Iterator, porém faz isso internamente, sem precisarmos declará-lo.
		// Não é possível, porém, usando esse 'for', alterar estruturalmente a coleção.
		// Operações como add() e remove() provocam um erro no laço.

		System.out.println();
		Arrays.fill(resumo, 0);
		for (ALAposta a : apostas) {
			qt = ALConcurso.quantidadeAcertos(a);
			if (qt >= 4) {
				System.out.println("" + qt + " acertos: " + a);
				resumo[qt - 4]++;
			}
			// apostas.remove(0); // provoca erro na próxima iteração.
		}
		System.out.println();
		System.out.println("4 acertos: " + resumo[0] + " apostadores.");
		System.out.println("5 acertos: " + resumo[1] + " apostadores.");
		System.out.println("6 acertos: " + resumo[2] + " apostadores.");

		// Um Iterator permite alterar a coleção enquanto a percorre.
		// O exemplo abaixo elimina da lista todas as apostas que tiveram
		// menos do que 4 acertos, deixando somente as que têm direito à premiação:

		Arrays.fill(resumo, 0);

		// Um Iterator não pode ser reutilizado. Para percorrer novamente
		// a coleção, é necessário solicitar uma nova instância do iterador.
		it = apostas.iterator();
		while (it.hasNext()) {
			qt = ALConcurso.quantidadeAcertos(it.next());
			if (qt >= 4) {
				resumo[qt - 4]++;
			} else {
				it.remove();
			}
		}
		System.out.println();
		// exibindo conteúdo restante da lista de apostas:
		System.out.println(apostas);

		System.out.println();
		System.out.println("4 acertos: " + resumo[0] + " apostadores.");
		System.out.println("5 acertos: " + resumo[1] + " apostadores.");
		System.out.println("6 acertos: " + resumo[2] + " apostadores.");

		System.out.println();
		// Imprimindo cada aposta vencedora:
		for (ALAposta a : apostas) {
			System.out.println(a); // chamada automática de a.toString();
		}

		// Quando temos acesso à referência de um objeto,
		// podemos acessar qualquer um de seus métodos públicos:
		System.out.println();
		ap = new ALAposta("Uma Aposta", 6);
		System.out.println(ap);
		ArrayList<Integer> nums = ap.getNumeros(); // referência da lista interna de números
		nums.set(0, 99); // alteração de um elemento da lista
		System.out.println(ap);
		ap.getNumeros().add(999); // inclusão de um elemento na lista
		System.out.println(ap);

		System.out.println();
		ap = new ALAposta("Outra Aposta", 6);
		System.out.println(ap);
		nums = ap.getNumerosApostados(); // referência a uma cópia da lista
		nums.set(0, 123);
		System.out.println(nums);
		System.out.println(ap); // as alterações não são feitas internamente.
		ap.getNumerosApostados().add(1111);
		System.out.println(ap);

	}

}
