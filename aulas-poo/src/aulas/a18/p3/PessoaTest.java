package aulas.a18.p3;

public class PessoaTest {

	public static void main(String[] args) {

		Professor pro = new Professor("Yoda", 950);
		pro.oi();
		pro.explicar("A For�a");
		System.out.println();
		Estudante est = new Estudante("Luke");
		est.setIdade(25);
		est.oi();
		est.estudar("A For�a");
		System.out.println();
		est = new Estudante("Obi-Wan", 33);
		est.oi();
		est.estudar("Algoritmos");

	}

}
