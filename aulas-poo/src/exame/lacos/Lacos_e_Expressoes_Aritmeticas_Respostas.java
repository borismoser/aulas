package exame.lacos;

public class Lacos_e_Expressoes_Aritmeticas_Respostas {

	public static void main(String[] args) {
		System.out.println("Expressão 1 = " + expressaoS1());
		System.out.println("Expressão 2 = " + expressaoS2());
		System.out.println("Expressão 3 = " + expressaoS3());
	}

	private static double expressaoS1() {
		double resultado = 0;
		int n = 1;
		for (int i = 1; i <= 50; i++) {
			resultado += (double) n / i;
			n += 2;
		}
		return resultado;
	}

	private static double expressaoS2() {
		double resultado = 0;
		for (int i = 1; i <= 50; i++) {
			resultado += Math.pow(2, i) / (50 - i + 1);
		}
		return resultado;
	}

	private static double expressaoS3() {
		double resultado = 0;
		int n = 1;
		int inc = 3;
		boolean somar = true;
		for (int i = 1; i <= 10; i++) {
			if (somar) {
				resultado += (double) i / n;
			} else {
				resultado -= (double) i / n;
			}
			somar = !somar;
			n += inc;
			inc += 2;
		}
		return resultado;
	}

}
