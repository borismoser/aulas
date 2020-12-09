package aulas.a33.excecoes;

public class CodigoDescricaoTest {

	public static void main(String[] args) {

		CodigoDescricao zero = new CodigoDescricao(0, "");
		System.out.println(zero);

		CodigoDescricao um = new CodigoDescricao(1, "um");
		System.out.println(um);

		CodigoDescricao dois = new CodigoDescricao(2, null);
		System.out.println(dois);
	}

}
