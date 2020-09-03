package aulas.a08;

import java.util.Arrays;

public class VetorUtil {

	public static long maiorElemento(long[] vetor) {
		long maior = vetor[0];
		for (long n : vetor) {
			if (n > maior) {
				maior = n;
			}
		}
		return maior;
	}

	public static double maiorElemento(double[] vetor) {
		double maior = vetor[0];
		for (double n : vetor) {
			if (n > maior) {
				maior = n;
			}
		}
		return maior;
	}

	public static String maiorElemento(String[] vetor) {
		if (vetor == null) {
			return null;
		}
		String maior = "";
		for (String s : vetor) {
			if (s != null) {
				if (s.length() > maior.length()) {
					maior = s;
				}
			}
		}
		return maior;
	}
	
	public static char maiorElemento(char[] vetor) {
		char maior = 0;
		for (char c : vetor) {
			if (c > maior) {
				maior = c;
			}
		}
		return maior;
	}
	
	public static long somaVetor(long[] vetor) {
		long soma = 0;
		for (long n : vetor) {
			soma += n;
		}
		return soma;
	}
	
	public static double somaVetor(double[] vetor) {
		double soma = 0;
		for (double n : vetor) {
			soma += n;
		}
		return soma;
	}
	
	public static long[] somentePares(long[] vetor) {
		if (vetor == null) {
			return null;
		}
		int contPar = 0;
		long[] saida = new long[vetor.length];
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] % 2 == 0) {
				saida[contPar] = vetor[i];
				contPar++;
			}
		}
		if (contPar > 0) {
			return Arrays.copyOfRange(saida, 0, contPar);
		}
		return null;
	}
	
	public static double[] somentePares(double[] vetor) {
		if (vetor == null) {
			return null;
		}
		int contPar = 0;
		double[] saida = new double[vetor.length];
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] % 2 == 0) {
				saida[contPar] = vetor[i];
				contPar++;
			}
		}
		if (contPar > 0) {
			return Arrays.copyOfRange(saida, 0, contPar);
		}
		return null;
	}
	
	public static long[] somenteImpares(long[] vetor) {
		if (vetor == null) {
			return null;
		}
		int contPar = 0;
		long[] saida = new long[vetor.length];
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] % 2 != 0) {
				saida[contPar] = vetor[i];
				contPar++;
			}
		}
		if (contPar > 0) {
			return Arrays.copyOfRange(saida, 0, contPar);
		}
		return null;
	}
	
	public static double[] somenteImpares(double[] vetor) {
		if (vetor == null) {
			return null;
		}
		int contPar = 0;
		double[] saida = new double[vetor.length];
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] % 2 != 0) {
				saida[contPar] = vetor[i];
				contPar++;
			}
		}
		if (contPar > 0) {
			return Arrays.copyOfRange(saida, 0, contPar);
		}
		return null;
	}
}
