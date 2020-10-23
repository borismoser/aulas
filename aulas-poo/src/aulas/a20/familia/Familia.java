package aulas.a20.familia;

public class Familia {

	public static void main(String[] args) {

		Pessoa eu = new Pessoa("eu");
		Pessoa pai = new Pessoa("meu pai");
		Pessoa mae = new Pessoa("minha mãe");
		Pessoa irmao = new Pessoa("meu irmão");
		Pessoa paiDoPai = new Pessoa("meu avô paterno");

		eu.setPai(pai);
		eu.setMae(mae);
		
		irmao.setPai(pai);
		irmao.setMae(mae);
		
		pai.setPai(paiDoPai);
		
		System.out.println(eu);
		System.out.println(pai);
		System.out.println(mae);
		System.out.println(irmao);
	}

}
