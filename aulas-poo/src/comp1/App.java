package comp1;

public class App {

	public static void main(String[] args) {

		Pais brasil = new Pais("Brasil");
		Estado sc = new Estado("Santa Catarina", "SC", brasil);
		Cidade blumenau = new Cidade("Blumenau", sc);
		Cidade itajai = new Cidade("Itajaí", sc);

		Endereco endereco = new Endereco();
		endereco.setCidade(blumenau);
		endereco.setTipoLogradouro(TipoLogradouro.RUA);
		endereco.setLogradouro("7 de Setembro");
		endereco.setNumero(1147);
		endereco.setComplemento("Bloco A");
		
		Pessoa eu = new Pessoa();
		eu.setNome("Eu Mesmo");
		eu.setEndereco(endereco);
		eu.setIdade(40);
		eu.setMae(new Pessoa("Minha Mãe", 70));
		eu.setPai(new Pessoa("Meu Pai", 75));
		eu.addDependente(new Pessoa("Meu Filho", 5));
		eu.addDependente(new Pessoa("Minha Filha", 8));
		//eu.listarDependente();

		eu.getDependentes().get(0).setPai(eu);

		System.out.println("Pai de "+
				eu.getDependentes().get(0).getNome() + " = " +
				eu.getDependentes().get(0).getPai().getNome());
		
		/*
		System.out.println(eu.getEndereco());

		endereco = new Endereco();
		endereco.setCidade(itajai);
		endereco.setTipoLogradouro(TipoLogradouro.AVENIDA);
		endereco.setLogradouro("Beira Rio");
		endereco.setNumero(5678);
		endereco.setComplemento("");
		
		Pessoa tu = new Pessoa("Tu Tu", 25);
		tu.setEndereco(endereco);
		System.out.println(tu.getEndereco());
		
		Endereco meuEndereco = eu.getEndereco(); 
		
		System.out.println(eu.getEndereco());
		*/
	}

}
