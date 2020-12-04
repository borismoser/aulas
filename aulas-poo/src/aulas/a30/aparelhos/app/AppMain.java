package aulas.a30.aparelhos.app;

import java.util.ArrayList;

import aulas.a30.aparelhos.cls.Aparelho;
import aulas.a30.aparelhos.cls.BluRay;
import aulas.a30.aparelhos.cls.ControlarCanal;
import aulas.a30.aparelhos.cls.ControlarReproducao;
import aulas.a30.aparelhos.cls.LigarDesligar;
import aulas.a30.aparelhos.cls.MP3Player;
import aulas.a30.aparelhos.cls.ReceptorTVCabo;
import aulas.a30.aparelhos.cls.Televisor;

public class AppMain {

	public static void main(String[] args) {

		MP3Player mp3 = new MP3Player("", "", 50);
		mp3.carregarMusica("M0");
		mp3.carregarMusica("M1");
		mp3.selecionarMusica(0);
		mp3.play();
		mp3.proxima();
		mp3.play();
		mp3.anterior();

		BluRay dvd = new BluRay("bluray b", "mod br1");
		dvd.onOff();
		dvd.inserirDisco("DVD 1234");

		ControlarReproducao cr = dvd;
		cr.play();
		
		
		System.exit(0);

		Aparelho ap1 = new Televisor("tv a", "mod a1", 33);
		Aparelho ap2 = new BluRay("bluray b", "mod br1");

		System.out.println("ap1 = " + ap1.getMarca() + " - " + ap1.getModelo());
		System.out.println("ap2 = " + ap2.getMarca() + " - " + ap2.getModelo());

		ap1.onOff();
		ap2.onOff();

		ReceptorTVCabo rec = new ReceptorTVCabo("GatoNet", "xyz", "Oi");
		rec.onOff();
		rec.canalMais();
		rec.canalMenos();
		rec.onOff();

		Televisor tvv = new Televisor("TV", "X", 55);

		ControlarCanal cc = rec;
		cc.canalMais();

		LigarDesligar ld = rec;
		ld.onOff();

		ld = tvv;
		ld.onOff();

		System.out.println("Classe de ap1: " + ap1.getClass().getSimpleName());
		System.out.println("Classe de ap2: " + ap2.getClass().getSimpleName());

		System.out.println("ap1 é equivalente ao ap2? --> " + ap1.equals(ap2));

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

		for (Aparelho aa : lista) {
			aa.onOff();
		}

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
