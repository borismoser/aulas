package outros;

public class Igualdades {

	public static void main(String[] args) {
		igualdadeDeStrings();
		igualdadeNumerica();
		igualdadeDeObjetos();
	}

	private static void igualdadeNumerica() {
		System.out.println("** IGUALDADES NUM�RICAS **\n");
		Integer n1 = 5;
		Integer n2 = 5;
		int i = 5;
		System.out.printf("n1 (%d) == n2 (%d) ? %b%n", n1, n2, n1 == n2); // mesma refer�ncia
		System.out.printf("n1 (%d) .equals() n2 (%d) ? %b%n", n1, n2, n1.equals(n2)); // mesmo valor
		System.out.printf("n1 (%d) == i (%d) ? %b%n", n1, i, n1 == i); // mesmo valor
		System.out.printf("n1 (%d) .equals() i (%d) ? %b%n", n1, i, n1.equals(i)); // mesmo valor
		System.out.println();
		n2 = new Integer(5);
		System.out.printf("n1 (%d) == n2 (%d) ? %b%n", n1, n2, n1 == n2); // refer�ncias diferentes
		System.out.printf("n1 (%d) .equals() n2 (%d) ? %b%n", n1, n2, n1.equals(n2)); // mesmo valor
		System.out.println();
	}

	private static void igualdadeDeObjetos() {
		System.out.println("** IGUALDADES DE OBJETOS **\n");
		Pessoa p1 = new Pessoa("Peter");
		Pessoa p2 = new Pessoa("Parker");

		System.out.println("p1 = " + p1 + " HashCode = " + p1.hashCode());
		System.out.println("p2 = " + p2 + " HashCode = " + p2.hashCode());
		System.out.printf("p1 (%s) == p2 (%s) ? %b%n", p1, p2, p1 == p2); // refer�ncias diferentes
		System.out.printf("p1 (%s) equals() p2 (%s) ? %b%n", p1, p2, p1.equals(p2)); // refer�ncias diferentes
		System.out.println();
		p2 = new Pessoa("Peter");
		System.out.println("p2 = " + p2 + " HashCode = " + p2.hashCode());
		System.out.printf("p1 (%s) equals() p2 (%s) ? %b%n", p1, p2, p1.equals(p2));
		System.out.println();

		PessoaComEquals pe1 = new PessoaComEquals("Peter");
		PessoaComEquals pe2 = new PessoaComEquals("Parker");

		System.out.println("pe1 = " + pe1 + " HashCode = " + pe1.hashCode());
		System.out.println("pe2 = " + pe2 + " HashCode = " + pe2.hashCode());
		System.out.printf("pe1 (%s) == pe2 (%s) ? %b%n", pe1, pe2, pe1 == pe2); // refer�ncias diferentes
		System.out.printf("pe1 (%s) equals() pe2 (%s) ? %b%n", pe1, pe2, pe1.equals(pe2));
		System.out.println();
		
		pe2 = new PessoaComEquals("Peter");
		System.out.println("pe2 = " + pe2 + " HashCode = " + pe2.hashCode());
		System.out.printf("pe1 (%s) == pe2 (%s) ? %b%n", pe1, pe2, pe1 == pe2); // refer�ncias diferentes
		System.out.printf("pe1 (%s) equals() pe2 (%s) ? %b%n", pe1, pe2, pe1.equals(pe2));
		System.out.println();

	}

	private static class Pessoa {
		private String nome;

		public Pessoa(String nome) {
			this.nome = nome;
		}

	}

	private static class PessoaComEquals {
		private String nome;

		public PessoaComEquals(String nome) {
			this.nome = nome;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof PessoaComEquals) {
				PessoaComEquals p = (PessoaComEquals) o;
				return this.nome.equals(p.nome);
			}
			return false;
		}
	}

	private static void igualdadeDeStrings() {
		/*
		 * Compara��o de Strings
		 * 
		 * � poss�vel comparar a igualdade por valor [m�todo equals()] e por refer�ncia
		 * [operador ==]:
		 */
		System.out.println("** IGUALDADES DE STRINGS **\n");
		String nome1 = "Peter";
		String nome2 = "Parker";
		
		nome1.equals(nome2);

		System.out.printf("nome1 (%s) == nome2 (%s) ? %b%n", nome1, nome2, nome1 == nome2); // refer�ncias diferentes
		System.out.printf("nome1 (%s) .equals() nome2 (%s) ? %b%n", nome1, nome2, nome1.equals(nome2)); // valores diferentes
		System.out.println();

		nome2 = "Peter";
		System.out.printf("nome1 (%s) == nome2 (%s) ? %b%n", nome1, nome2, nome1 == nome2); // refer�ncias iguais
		System.out.printf("nome1 (%s) .equals() nome2 (%s) ? %b%n", nome1, nome2, nome1.equals(nome2)); // valores id�nticos
		System.out.println();

		nome2 = nome1;
		System.out.printf("nome1 (%s) == nome2 (%s) ? %b%n", nome1, nome2, nome1 == nome2); // refer�ncias iguais
		System.out.printf("nome1 (%s) .equals() nome2 (%s) ? %b%n", nome1, nome2, nome1.equals(nome2)); // valores id�nticos
		System.out.println();

		nome2 = new String("Peter");
		System.out.printf("nome1 (%s) == nome2 (%s) ? %b%n", nome1, nome2, nome1 == nome2); // refer�ncias diferentes
		System.out.printf("nome1 (%s) .equals() nome2 (%s) ? %b%n", nome1, nome2, nome1.equals(nome2)); // valores id�nticos
		System.out.printf("nome1 (%s) .equalsIgnoreCase() nome2 (%s) ? %b%n", nome1, nome2,
				nome1.equalsIgnoreCase(nome2)); // valores id�nticos
		System.out.println();

		nome1 = new String("PETER");
		System.out.printf("nome1 (%s) == nome2 (%s) ? %b%n", nome1, nome2, nome1 == nome2); // refer�ncias diferentes
		System.out.printf("nome1 (%s) .equals() nome2 (%s) ? %b%n", nome1, nome2, nome1.equals(nome2)); // valores diferentes
		System.out.printf("nome1 (%s) .equalsIgnoreCase() nome2 (%s) ? %b%n", nome1, nome2,
				nome1.equalsIgnoreCase(nome2)); // valores id�nticos
		System.out.printf("nome1 (%s) .equalsIgnoreCase() nome2 (%s) ? %b%n", nome1, nome2,
				nome1.equalsIgnoreCase(nome2)); // valores id�nticos
		System.out.println();

		/*
		 * Tamb�m � poss�vel comparar em termos de qual string � "maior" (no sentido
		 * alfab�tico). O m�todo compareTo() retorna 0 quando iguais, um valor positivo
		 * quando a primeira � maior e negativo quando a primeira � menor.
		 */
		nome1 = "Peter";
		nome2 = "Parker";
		System.out.printf("nome1 (%s) .compareTo() nome2 (%s) ? %d%n", nome1, nome2, nome1.compareTo(nome2));
		System.out.printf("nome2 (%s) .compareTo() nome1 (%s) ? %d%n", nome2, nome1, nome2.compareTo(nome1));
		nome1 = "Parker";
		System.out.printf("nome2 (%s) .compareTo() nome1 (%s) ? %d%n", nome2, nome1, nome2.compareTo(nome1));
		System.out.println();
	}

}
