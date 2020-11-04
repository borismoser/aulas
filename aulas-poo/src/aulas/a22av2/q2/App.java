package aulas.a22av2.q2;

public class App {

	public static void main(String[] args) {

		System.out.println("Instanciar produtos nacionais:\n");
		Nacional pdq = new Nacional(1, "Pão de Queijo", 0.45, Categoria.ARTESANAL);
		System.out.println(pdq);
		Nacional pam = new Nacional(2, "Pamonha", 3.5, Categoria.ARTESANAL);
		System.out.println(pam);
		Nacional cac = new Nacional(3, "Cachaça", 15.0, Categoria.INDUSTRIALIZADO);
		System.out.println(cac);
		System.out.println(cac.getPrecoFinal() == 19.5 ? "OK" : "FALHOU 1");
//		System.out.println(cac.getPrecoCusto() == 15.0 ? "OK" : "FALHOU 2");
//		System.out.println(cac.getCodigo() == 3 ? "OK" : "FALHOU 3");
//		System.out.println("Cachaça".equals(cac.getDescricao()) ? "OK" : "FALHOU 4");
		System.out.println(cac.getCategoria().equals(Categoria.INDUSTRIALIZADO) ? "OK" : "FALHOU 5");

		System.out.println("\nInstanciar produtos importados:\n");
		Importado vod = new Importado(4, "Vodka", 43.8, 120.0);
		System.out.println(vod);
		Importado aif = new Importado(5, "Ai Fone", 199.99, 800.0);
		System.out.println(aif);
		Importado bmw = new Importado(6, "850i", 350000, 75.0);
		System.out.println(bmw);
		System.out.println(bmw.getPrecoMinimo() == 612500.0 ? "OK" : "FALHOU 6");
//		System.out.println(bmw.getPrecoCusto() == 350000.0 ? "OK" : "FALHOU 7");
//		System.out.println(bmw.getCodigo() == 6 ? "OK" : "FALHOU 8");
//		System.out.println("850i".equals(bmw.getDescricao()) ? "OK" : "FALHOU 9");

		System.out.println("\nOperação da loja:\n");
		Loja loja = new Loja("Varejista SA");
		System.out.println("Varejista SA".equals(loja.getNomeLoja()) ? "OK" : "FALHOU 10");

		System.out.println(loja.novoProduto(pdq) ? "OK" : "FALHOU 12"); // deve ser true
		System.out.println(loja.novoProduto(pam) ? "OK" : "FALHOU 13"); // deve ser true
		System.out.println(loja.novoProduto(cac) ? "OK" : "FALHOU 11"); // deve ser true

		Nacional pdq2 = new Nacional(1, "Pão de Queijo", 0.45, Categoria.ARTESANAL);
		System.out.println(!loja.novoProduto(pdq2) ? "OK" : "FALHOU 14"); // deve ser false
		Nacional cac2 = new Nacional(3, "Cachaça", 15.0, Categoria.INDUSTRIALIZADO);
		System.out.println(!loja.novoProduto(cac2) ? "OK" : "FALHOU 15"); // deve ser false

		System.out.println(loja.novoProduto(aif) ? "OK" : "FALHOU 16"); // deve ser true
		System.out.println(loja.novoProduto(vod) ? "OK" : "FALHOU 18"); // deve ser true
		System.out.println(loja.novoProduto(bmw) ? "OK" : "FALHOU 17"); // deve ser true

		Importado bmw2 = new Importado(6, "850i", 350000, 75.0);
		System.out.println(!loja.novoProduto(bmw2) ? "OK" : "FALHOU 19"); // deve ser false

		//System.out.println(loja.nacionalMaisCaro().equals(cac) ? "OK" : "FALHOU 20"); // deve ser a cachaça
		//System.out.println(loja.importadoMaisBarato().equals(vod) ? "OK" : "FALHOU 21"); // deve ser a vodka
	}

}
