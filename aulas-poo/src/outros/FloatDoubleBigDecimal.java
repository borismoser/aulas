package outros;

import java.math.BigDecimal;

public class FloatDoubleBigDecimal {

	public static void main(String[] args) {

		// As duas expressões abaixo deveria ser matematicamente iguais, porém...
		System.out.println(0.3 * 3); // 0.8999999999999999
		System.out.println((0.1 + 0.1 + 0.1) * 3); // 0.9000000000000001

		// Os tipos float e double não conseguem representam precisamente todos os
		// números de ponto flutuante.
		testeComFloats();
		testeComDoubles();

		// O tipo BigDecimal provê precisão aritmética, sendo indicado especialmente em
		// cálculos financeiros.
		testeComBigDecimals();

		calculoDeJurosDouble();
		calculoDeJurosBigDecimal();

		System.out.println(somaRecursiva(10, 6));
		System.out.println(somaRecursiva(-5, 5));
		System.out.println(somaRecursiva(1, 10));
	}

	private static int somaRecursiva(int inicio, int fim) {
		if (inicio > fim) {
			return 0;
		}
		if (inicio < fim) {
			return inicio + somaRecursiva(inicio+1, fim);
		} else {
			return fim;
		}
	}

	private static void testeComFloats() {

		System.out.println("Resultados com Floats:\n");
		float a = 0.1f;
		float b = 0.1f;
		float c = 0.1f;
		float d = a + b + c;
		System.out.println("a + b + c = d = " + d);
		float e = d * 3;
		System.out.println("e = d * 3 = " + e);
		float f = d * 100000;
		System.out.println("f = d * 100000 = " + f);
		System.out.println("");
	}

	private static void testeComDoubles() {
		System.out.println("Resultados com Doubles\n");

		double a = 0.1;
		double b = 0.1;
		double c = 0.1;
		double d = a + b + c;
		System.out.println("a + b + c = d = " + d);
		double e = d * 3;
		System.out.println("e = d * 3 = " + e);
		double f = d * 100000;
		System.out.println("f = d * 100000 = " + f);
		System.out.println("");
	}

	private static void testeComBigDecimals() {
		System.out.println("Resultados com BigDecimals:\n");

		BigDecimal a = new BigDecimal("0.1");
		BigDecimal b = new BigDecimal("0.1");
		BigDecimal c = new BigDecimal("0.1");
		BigDecimal d = a.add(b).add(c);
		System.out.println("a + b + c = d = " + d);
		BigDecimal e = d.multiply(new BigDecimal("3"));
		System.out.println("e = d * 3 = " + e);
		BigDecimal f = d.multiply(new BigDecimal("100000"));
		System.out.println("f = d * 100000 = " + f);
		System.out.println();
		// A comparação entre valores BigDecimal não deve ser feita com os operadores ==
		// ou !=
		System.out.println("(" + a + ") a == b (" + b + ") ? --> " + (a == b));
		System.out.println("(" + a + ") a != b (" + b + ") ? --> " + (a != b));
		// Utilize equals() ou, preferencialmente, compareTo()
		System.out.println("(" + a + ") a.equals(b) (" + b + ") ? --> " + (a.equals(b)));
		System.out.println("(" + a + ") a.compareTo(b) (" + b + ") --> " + a.compareTo(b));
		System.out.println("(" + a + ") a.compareTo(d) (" + d + ") --> " + a.compareTo(d));
		System.out.println("(" + d + ") d.compareTo(a) (" + a + ") --> " + d.compareTo(a));
		System.out.println();
	}

	private static void calculoDeJurosDouble() {
		System.out.println("Juros compostos com variáveis Double:");

		double inicial = 1000;
		double montante = inicial;
		double juros = 0;
		double taxa = 0.5;
		int periodos = 12;
		System.out.println("Valor inicial: " + inicial);
		for (int i = 1; i <= periodos; i++) {
			juros = montante * taxa / 100;
			montante = montante + juros;
			System.out.println("Juros (" + i + "): " + juros + " Valor atualizado: " + montante);
		}
		System.out.println("Montante Double (cálculo manual) :     " + montante);
		// fórmula de juros compostos: M = C * ((1 + i) ^ n)
		System.out.println("Montante Double (cálculo fórmula):     " + inicial * Math.pow((1 + taxa / 100), periodos));

		JurosCompostosDbl jc = new JurosCompostosDbl(inicial, taxa, periodos);
		System.out.println("Montante Double (cálculo método) :     " + jc.getValorFuturo());
		System.out.println();
	}

	private static void calculoDeJurosBigDecimal() {
		System.out.println("Juros compostos com variáveis BigDecimal:");

		BigDecimal inicial = new BigDecimal(1000.0);
		BigDecimal montante = inicial;
		BigDecimal juros = new BigDecimal(0);
		BigDecimal taxa = new BigDecimal(0.5);
		int periodos = 12;
		System.out.println("Valor inicial: " + inicial);
		for (int i = 1; i <= periodos; i++) {
			juros = montante.multiply(taxa).divide(new BigDecimal(100));
			montante = montante.add(juros);
			System.out.println("Juros (" + i + "): " + juros + " Valor atualizado: " + montante);
		}
		System.out.println("Montante BigDecimal (cálculo manual) : " + montante);
		// fórmula de juros compostos: M = C * ((1 + i) ^ n)
		System.out.println("Montante BigDecimal (cálculo fórmula): "
				+ inicial.multiply((taxa.divide(new BigDecimal(100)).add(BigDecimal.ONE).pow(periodos))));
		JurosCompostosBig jc = new JurosCompostosBig(inicial, taxa, periodos);
		System.out.println("Montante BigDecimal (cálculo método) : " + jc.getValorFuturo());
		System.out.println();
	}

	private static class JurosCompostosDbl {
		double valorPresente;
		double taxaJuros;
		int periodo;

		public JurosCompostosDbl(double valorPresente, double taxaJuros, int periodo) {
			this.valorPresente = valorPresente;
			this.taxaJuros = taxaJuros;
			this.periodo = periodo;
		}

		public double getValorFuturo() {
			return valorPresente * Math.pow((1 + taxaJuros / 100), periodo);
		}
	}

	private static class JurosCompostosBig {
		BigDecimal valorPresente;
		BigDecimal taxaJuros;
		int periodo;

		public JurosCompostosBig(BigDecimal valorPresente, BigDecimal taxaJuros, int periodo) {
			this.valorPresente = valorPresente;
			this.taxaJuros = taxaJuros;
			this.periodo = periodo;
		}

		public BigDecimal getValorFuturo() {
			BigDecimal taxaReal = taxaJuros.divide(new BigDecimal(100));
			taxaReal = taxaReal.add(BigDecimal.ONE);
			return valorPresente.multiply(taxaReal.pow(periodo));
		}
	}
}
