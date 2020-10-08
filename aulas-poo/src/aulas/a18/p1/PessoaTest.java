package aulas.a18.p1;

public class PessoaTest {

	public static void main(String[] args) {

		Estudante est = new Estudante();
		est.setIdade(21);
		est.oi();
		est.estudar("Java");

		Professor pro = new Professor();
		pro.setIdade(45);
		pro.oi();
		pro.explicar("Banco de dados");

	}

}
