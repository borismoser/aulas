package aulas.a34.arq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class InverterArquivo {

	public static void main(String[] args) {
		String lorem = "./src/aulas/a34/arq/lorem-ipsum.txt";
		String lorem2 = "./src/aulas/a34/arq/lorem-ipsum-inv.txt";
		inverterArquivoNEW(lorem, lorem2);
		inverterArquivoAPPEND(lorem, lorem2);
	}

	private static String inverterLinhas(BufferedReader br) throws IOException {
		StringBuilder conteudo = new StringBuilder();
		String linha;
		while ((linha = br.readLine()) != null) {
			conteudo.insert(0, linha + System.lineSeparator());
		}
		return conteudo.toString();
	}

	private static void inverterArquivoNEW(String arqOrigem, String arqDestino) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(arqOrigem));
				BufferedWriter writer = Files.newBufferedWriter(Paths.get(arqDestino), //
						StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
			writer.append(inverterLinhas(reader));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void inverterArquivoAPPEND(String arqOrigem, String arqDestino) {
		Path input = Paths.get(arqOrigem);
		Path output = Paths.get(arqDestino);
		try {
			List<String> linhas = new ArrayList<>(Files.readAllLines(input));
			for (int i = linhas.size() - 1; i >= 0; i--) {
				Files.write(output, (linhas.get(i)+System.lineSeparator()).getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
