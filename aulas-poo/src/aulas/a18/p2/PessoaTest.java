package aulas.a18.p2;

public class PessoaTest {

	public static void main(String[] args) {

		Professor pro = new Professor("Yoda");
		pro.setIdade(950);
		pro.oi();
		pro.explicar("A For�a");

		Estudante est = new Estudante("Luke");
		est.setIdade(25);
		est.oi();
		est.estudar("A For�a");
		
	}

}
