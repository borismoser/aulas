package aulas.a02;

public class TiposPrimitivos {

	public static void main(String[] args) {

		// byte (inteiro com 8 bits): -128 a 127
		byte bt1 = 3, bt2;
		System.out.println("bt1 = " + bt1);
		bt1++;
		System.out.println("bt1 = " + bt1);
		bt1 = 127;
		System.out.println("bt1 = " + bt1);

		// Ao exceder o valor máximo, o valor volta para o limite inferior
		bt1++;
		System.out.println("bt1 = " + bt1);

		// Ao exceder o valor mínimo, o valor volta para o limite superior
		bt1--;
		System.out.println("bt1 = " + bt1);

		bt2 = bt1++;
		System.out.println("bt1 = " + bt1 + "; bt2 = " + bt2);

		// short (inteiro com 16 bits): -32768 a 32767
		short sh1, sh2;
		sh1 = 32767;
		System.out.println("sh1 = " + sh1);
		// Ao exceder o valor máximo, o valor volta para o limite inferior (e
		// vice-versa)
		sh1++;
		System.out.println("sh1 = " + sh1);

		// Um valor short pode receber um valor byte diretamente,
		// pois tem "espaço" para armazenar esse valor ser perder precisão:
		sh2 = bt2;
		System.out.println("sh2 = " + sh2);

		// Um valor byte não pode receber um valor short sem uma conversão explícita,
		// pois pode acontecer uma perda de precisão:
		sh1 = 555;
		bt1 = (byte) sh1;
		System.out.println("bt1 = " + bt1);

		// int (inteiro com 32 bits): -2147483648 a 2147483647
		int in1, in2;

		// Uma valor de precisão menor pode ser atribuída a uma variável de precisão
		// maior:
		in1 = sh1;
		System.out.println("in1 = " + in1);

		// Variáveis de precisão maior precisam ser convertidas
		// para que possam ser atribuídas a precisões menores:
		in2 = 123456;
		bt1 = (byte) in2;
		sh1 = (short) in2;
		System.out.println("in2 = " + in2 + "; bt1 = " + bt1 + "; sh1 = " + sh1);

		// A conversão é necessária mesmo que o valor de maior precisão "caiba" no
		// menor:
		in1 = 0;
		bt1 = (byte) in1;

		// long (inteiro com 64 bits): -9223372036854775808 a 9223372036854775807
		long lo1 = in2;
		bt1 = (byte) lo1;
		sh1 = (short) lo1;
		in1 = (int) lo1;

		// float (ponto flutuante 32 bits)
		float fl1, fl2;

		// O caracter 'f' é necessário para indicar que o número é um float.
		// Números decimais são double, por padrão.
		fl1 = 5.0f;
		System.out.println("fl1 = " + fl1);

		in2 = 5;
		in1 = 2;
		// A divisão de tipos inteiros gera um resultado também inteiro:
		fl2 = in2 / in1;
		System.out.println("fl2 = " + fl2);

		// A divisão de um tipo decimal por um inteiro gera um resultado decimal:
		fl2 = fl1 / in1;
		System.out.println("fl2 = " + fl2);

		// O mesmo resultado pode ser obtido com o casting de um dos elementos:
		fl2 = (float) in2 / in1;
		System.out.println("fl2 = " + fl2);

		fl2 = in2 / (float) in1;
		System.out.println("fl2 = " + fl2);

		// Um resultado decimal deve sofrer cast para ser atribuído a um inteiro:
		fl2 = 2.6f;
		in1 = (int) (fl2 * 3);
		System.out.println("in1 = " + in1);

		// double (ponto flutuante 64 bits)
		// Segue as mesmas regras de um float.
		// Não é necessário identificados após a atribuição, embora possa-se usar 'd'.
		double db1, db2;
		db1 = 6.66;
		db2 = db1 * fl2;
		System.out.println("db2 = " + db2);

		db2 = 1.33d;
		System.out.println("db2 = " + db2);
		in1 = (int) (db1 + db2);
		System.out.println("in1 = " + in1);
		db2 += db1;
		System.out.println("db2 = " + db2);

		// Tipo caracter (16 bits Unicode)
		char ch1, ch2;
		ch1 = '1';
		System.out.println("ch1 = " + ch1);
		ch2 = (char) 123;
		System.out.println("ch1 + ch2 = " + ch1 + ch2);

		// Tipo lógico (16 bits Unicode)
		boolean bo1 = false, bo2 = true;
		System.out.println("bo1 = " + bo1);
		System.out.println("bo1 ou bo2 = " + (bo1 || bo2));

	}

}
