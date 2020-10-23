package aulas.a22av2;

public class LojaApp {

	public static void main(String[] args) {

		Nacional pdq = new Nacional(1, "Pão de Queijo", 0.45, Categoria.ARTESANAL);
		System.out.println(pdq);
		Nacional pam = new Nacional(2, "Pamonha", 3.5, Categoria.ARTESANAL);
		System.out.println(pam);
		Nacional cac = new Nacional(3, "Cachaça", 15.0, Categoria.INDUSTRIALIZADO);
		System.out.println(cac);

		Importado vod = new Importado(4, "Vodka", 43.8, 120.0);
		System.out.println(vod);
		Importado aif = new Importado(5, "Ai Fone", 199.99, 800.0);
		System.out.println(aif);
		Importado bmw = new Importado(6, "850i", 350000, 75.0);
		System.out.println(bmw);
		
		Loja loja = new Loja("Varejista SA");
		
		System.out.println(loja.novoProduto(cac)); // deve ser true
		System.out.println(loja.novoProduto(pdq)); // deve ser true
		System.out.println(loja.novoProduto(pam)); // deve ser true
		
		Nacional pdq2 = new Nacional(1, "Pão de Queijo", 0.45, Categoria.ARTESANAL);
		System.out.println(loja.novoProduto(pdq2)); // deve ser false
		Nacional cac2 = new Nacional(3, "Cachaça", 15.0, Categoria.INDUSTRIALIZADO);
		System.out.println(loja.novoProduto(cac2)); // deve ser false

		System.out.println(loja.novoProduto(aif)); // deve ser true
		System.out.println(loja.novoProduto(bmw)); // deve ser true
		System.out.println(loja.novoProduto(vod)); // deve ser true
		
		Importado bmw2 = new Importado(6, "850i", 350000, 75.0);
		System.out.println(loja.novoProduto(bmw2)); // deve ser false
		
		System.out.println(loja.nacionalMaisCaro()); // deve ser a cachaça
		System.out.println(loja.importadoMaisBarato()); // deve ser a vodka
	}

}
