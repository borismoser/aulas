package arquivos.lorem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class LerImprimirArquivo {

	public static void main(String[] args) {
		String lorem = "D:\\eclipse\\workspace\\git\\aulas-poo\\aulas-poo\\src\\arquivos\\lorem\\lorem-ipsum.txt";
		exemploTryFinally(lorem);
		exemploTryWithResources(lorem);
	}

	private static void exemploTryFinally(String arquivo) {
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(arquivo));
			System.out.println(lerLinhaPorLinha(reader));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String lerLinhaPorLinha(BufferedReader br) throws IOException {
		StringBuilder conteudo = new StringBuilder();
		String linha;
		while ((linha = br.readLine()) != null) {
			conteudo.append(linha);
			conteudo.append(System.lineSeparator());
		}
		return conteudo.toString();
	}

	private static void exemploTryWithResources(String arquivo) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(arquivo))) {
			System.out.println(lerTodasAsLinhas(reader));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String lerTodasAsLinhas(BufferedReader br) {
		return br.lines().collect(Collectors.joining(System.lineSeparator()));
	}

}
