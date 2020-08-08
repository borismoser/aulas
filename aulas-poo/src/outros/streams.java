package outros;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class streams {

	public static void main(String[] args) {

		Random rd = new Random();
		Instant inicio, fim;
		long duracao;
		int tamanho = 150_000_000;

		int[] ints = null;
		ints = new int[tamanho];

		inicio = Instant.now();
		for (int i = 0; i < ints.length; i++) {
			ints[i] = rd.nextInt();
		}
		fim = Instant.now();
		duracao = Duration.between(inicio, fim).toMillis();
		System.out.println("Geração do array com FOR: " + duracao);

		inicio = Instant.now();
		ints = rd.ints(tamanho).toArray();
		fim = Instant.now();
		duracao = Duration.between(inicio, fim).toMillis();
		System.out.println("Geração do array com STREAM: " + duracao);

		long soma = 0;
		inicio = Instant.now();
		for (int i = 0; i < ints.length; i++) {
			soma += ints[i];
		}
		fim = Instant.now();
		System.out.println(soma);
		duracao = Duration.between(inicio, fim).toMillis();
		System.out.println("Soma do array com FOR: " + duracao);

		soma = 0;
		inicio = Instant.now();
		for (int n : ints) {
			soma += n;
		}
		fim = Instant.now();
		System.out.println(soma);
		duracao = Duration.between(inicio, fim).toMillis();
		System.out.println("Soma do array com ENHANCED FOR: " + duracao);

		inicio = Instant.now();
		soma = Arrays.stream(ints).sum();
		fim = Instant.now();
		System.out.println(soma);
		duracao = Duration.between(inicio, fim).toMillis();
		System.out.println("Soma do array com STREAM: " + duracao);

		System.exit(0);

		String[] letras = new String[] { "a", "b", "c" };
		System.out.println(Arrays.toString(letras));
		Stream<String> st = Arrays.stream(letras);

		st.forEach(s -> System.out.print(s));
		System.out.println();

		st = Stream.of("a", "b", "c");
		System.out.println(st.distinct().count());
		System.out.println(st.anyMatch(s -> s.contains("a")));
	}

}
