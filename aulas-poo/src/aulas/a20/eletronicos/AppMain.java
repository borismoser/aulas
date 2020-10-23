package aulas.a20.eletronicos;

public class AppMain {

	public static void main(String[] args) {

		Televisor sony = new Televisor("Sony", "Bravia", 40);
		sony.onOff();
		sony.setCanal(33);
		sony.onOff();
		sony.setCanal(35);
		sony.onOff();
		sony.canalMais();
		sony.setCanal(88);
		sony.canalMais();
		sony.onOff();
		
		BluRay br = new BluRay("LG", "BR-400");
		br.onOff();
		br.inserirDisco("Pulp Fiction");
		br.onOff();
		br.onOff();
		br.eject();
		br.eject();
		br.play();
		br.inserirDisco("Avengers");
		br.play();
		br.stop();
		br.play();
		br.pause();
		br.eject();
		br.pause();

	}

}
