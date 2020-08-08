package texto;

import java.util.Scanner;

public class TestStrings {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		strings();
		stringBuilders();
		characters();
		regex();
		tokenSplit();

	}

	private static void tokenSplit() {
		System.out.print("Digite uma frase e pressione <Enter>: ");
		String s = scanner.nextLine();
		String[] tokens = s.split("\\s");
		System.out.println("Número de elementos: " + tokens.length);
		for (String tk : tokens) {
			System.out.println(tk);
		}
	}

	private static void regex() {
		System.out.print("Digite seu primeiro nome e pressione <Enter>: ");
		String nome = scanner.nextLine();
		// Inicial maiúscula e uma sequência mista de letras maiúsculas ou minúsculas
		if (nome.matches("[A-Z][a-zA-Z]*")) {
			System.out.println("Nome válido");
		} else {
			System.out.println("Nome inválido");
		}

		System.out.print("Digite o nome da cidade e pressione <Enter>: ");
		String cidade = scanner.nextLine();
		// uma ou mais palavras separadas 
		if (cidade.matches("([a-zA-Z]+(\\s[a-zA-Z]+)*)")) {
			System.out.println("Nome válido para cidade");
		} else {
			System.out.println("Nome inválido para cidade");
		}

		System.out.print("Digite um CEP e pressione <Enter>: ");
		String cep = scanner.nextLine();
		// Cinco dígitos seguidos de um hífen e mais três dígitos
		if (cep.matches("\\d{5}-\\d{3}")) {
			System.out.println("CEP válido");
		} else {
			System.out.println("CEP inválido");
		}
	}

	private static void characters() {
		System.out.print("Digite um caracter [0 (zero) para sair] e depois <Enter>: ");
		char c = scanner.nextLine().charAt(0);
		while (c != '0') {
			System.out.printf("é um dígito: %b%n", Character.isDigit(c));
			System.out.printf("é uma letra: %b%n", Character.isLetter(c));
			System.out.printf("é uma letra ou um dígito: %b%n", Character.isLetterOrDigit(c));
			System.out.printf("é minúsculo: %b%n", Character.isLowerCase(c));
			System.out.printf("é maiúsculo: %b%n", Character.isUpperCase(c));
			System.out.printf("convertido para maiúsculo: %s%n", Character.toUpperCase(c));
			System.out.printf("convertido para minúsculo: %s%n", Character.toLowerCase(c));
			System.out.printf("pode ser usado para iniciar nomes de identificadores Java: %b%n",
					Character.isJavaIdentifierStart(c));
			System.out.printf("pode ser usado com parte do nome de identificadores Java: %b%n",
					Character.isJavaIdentifierPart(c));
			System.out.println();
			System.out.print("Digite um caracter [0 (zero) para sair] e depois <Enter>: ");
			c = scanner.nextLine().charAt(0);
		}
	}

	private static void strings() {
		char[] vetChar = { 'b', 'o', 'm', ' ', 'd', 'i', 'a' };
		String s = new String("Feliz Aniversário!");

		String s1 = new String();
		String s2 = new String(s);
		String s3 = new String(vetChar);
		String s4 = new String(vetChar, 4, 3);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

		System.out.println("Tamanho de s2: " + s2.length());

		for (int i = s3.length() - 1; i >= 0; i--) {
			System.out.printf("%c ", s3.charAt(i));
		}
		System.out.println();

		s.getChars(6, 13, vetChar, 0);
		for (char c : vetChar) {
			System.out.print(c);
		}
		System.out.println();
		System.out.println(s.startsWith("Fe"));
		System.out.println(s.startsWith("An", 6));
		System.out.println(s.endsWith("!"));
		System.out.println(s.indexOf('e'));
		System.out.println(s.indexOf('e', 5));
		System.out.println(s.lastIndexOf('i'));
		System.out.println(s.lastIndexOf('i', 7));
		System.out.println(s.substring(6));
		System.out.println(s.substring(6, 8));
		System.out.println(s.contains("niver"));

		System.out.println(s3.concat(s));
		System.out.println(s.replace('i', ' '));
		System.out.println(s.toLowerCase());
		System.out.println(s.toUpperCase());
		System.out.println("[" + "      x  y      ".trim() + "]");

	}

	private static void stringBuilders() {

		String s = new String("Feliz Aniversário!");

		StringBuilder sb1 = new StringBuilder(); // conteúdo vazio, 16 caracteres de capacidade
		StringBuilder sb2 = new StringBuilder(10); // conteúdo vazio, 10 caracteres de capacidade
		StringBuilder sb3 = new StringBuilder("Conteúdo textual"); // conteúdo + 16 caracteres de capacidade

		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.length() + ", " + sb3.capacity());
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
		sb3.setLength(5);
		System.out.println(sb3);
		System.out.println(sb3.length() + ", " + sb3.capacity());
		sb3.ensureCapacity(256);
		System.out.println(sb3.length() + ", " + sb3.capacity());
		sb3.setLength(15); // Aumentando o tamanho além do conteúdo de texto, são adicionados caracteres
							// nulos.
		System.out.println(sb3);
		System.out.println(sb3.length() + ", " + sb3.capacity());
		sb3.reverse();
		System.out.println(sb3);

		sb1.append("Algum texto");
		System.out.println(sb1);
		sb1.append(' ').append(1000).append(s);
		System.out.println(sb1);
		sb1.insert(16, " ** ");
		System.out.println(sb1);
		sb1.deleteCharAt(18);
		System.out.println(sb1);
		sb1.delete(11, 16);
		System.out.println(sb1);
	}

}
