package aulas.a25.aparelhos.app;

import java.util.ArrayList;

import aulas.a25.aparelhos.modelagem.Aparelho;
import aulas.a25.aparelhos.modelagem.BluRay;
import aulas.a25.aparelhos.modelagem.Televisor;

public class AppMain {

	public static void main(String[] args) {

		// Após declarar uma classe como abstrata,
		// não é mais possível instanciá-la.
		// Descomentar a linha abaixo gera erro de compilação:

		// Aparelho aaa = new Aparelho("Aparelho","abstrato");

		// Polimorfismo é a capacidade de a linguagem
		// lidar com objetos de classes diferentes
		// como se fossem da mesma classe.

		// Para isso, tais objetos devem possuir características
		// em comum a partir de algum tipo de herança.

		// Nestes exemplos, tanto o Televisor quanto
		// o Bluray são subclasses de Aparelho, o que
		// permite que ambos sejam tratados como a superclasse.
		// Dessa forma, é possível armazenar referências a
		// objetos "subclasse" em variáveis "superclasse":

		Aparelho ap1 = new Televisor("tv a", "mod a1", 33);
		Aparelho ap2 = new BluRay("bluray b", "mod br1");
		
		// Ao tratar objetos através de polimorfismo, ficam
		// disponíveis apenas os métodos comuns à classe que contém
		// as referências. Neste caso, os métodos da classe Aparelho:

		System.out.println("ap1 = " + ap1.getMarca() + " - " + ap1.getModelo());
		System.out.println("ap2 = " + ap2.getMarca() + " - " + ap2.getModelo());

		ap1.onOff();

		// Apesar de armazenados em uma variável de classe diferente daquela
		// em que foram criados, cada objeto sabe a qual classe pertence:

		System.out.println("Classe de ap1: " + ap1.getClass().getSimpleName());
		System.out.println("Classe de ap2: " + ap2.getClass().getSimpleName());

		// Por conhecerem as classes a que pertencem, os objetos
		// respondem corretamente ao método equals():

		System.out.println("ap1 é equivalente ao ap2? --> " + ap1.equals(ap2));

		// Para poder acessar os métodos do objetos que estão
		// definidos em sua classe original, é necessário fazer
		// um 'cast' para o tipo correto, semelhante aos tipos numéricos.

		// O operador instanceof verifica se uma referência é
		// compatível com uma determinada classe:


		if (ap1 instanceof Televisor) {
			Televisor ap3 = (Televisor) ap1;
			System.out.println("Classe de ap3: " + ap3.getClass().getSimpleName());
			ap3.canalMais();
			System.out.println("A TV está no canal " + ap3.getCanal());
			ap3.onOff();
		}

		if (ap2 instanceof BluRay) {
			BluRay ap4 = (BluRay) ap2;
			System.out.println("Classe de ap4: " + ap4.getClass().getSimpleName());
			ap4.eject();
		}

		// A atribuição direta de uma referência de superclasse
		// para uma variável de subclasse não é permitida e
		// gera um erro de compilação:

		// Televisor umaTV = ap1;

		// Fazer cast para um tipo incompatível não gera erro de compilação,
		// mas gera uma exceção:

		// BluRay umBR = (BluRay) ap1;  // ClassCastException
		// umBR.onOff();

		// Um uso comum de polimorfismo é o armazenamento
		// de objetos de diferentes tipos em coleções
		// de tipos compatíveis:


		ArrayList<Aparelho> lista = new ArrayList<>();

		Televisor tv;
		BluRay br;

		tv = new Televisor("Sony", "Bravia", 40);
		lista.add(tv);

		tv = new Televisor("LG", "LXX", 50);
		lista.add(tv);

		br = new BluRay("Philips", "BR-400");
		lista.add(br);

		br = new BluRay("Philco", "P900");
		lista.add(br);


		// É possível percorrer a lista de aparelhos e ligar
		// todos eles, independentemente do tipo original,
		// pois o método onOff() está na classe Aparelho:

		for (Aparelho aa : lista) {
			aa.onOff();
		}

		// Também é possível verificar o tipo de cada aparelho
		// e chamar métodos específicos:

		for (Aparelho aa : lista) {
			if (aa instanceof Televisor) {
				tv = (Televisor) aa; // Podemos fazer o cast para uma variável...
				tv.canalMenos();
				tv.setCanal(123);
			} else if (aa instanceof BluRay) {
				((BluRay) aa).eject(); // ...ou anonimamente (sem variável).
			}
			aa.onOff();
		}

	}

}
