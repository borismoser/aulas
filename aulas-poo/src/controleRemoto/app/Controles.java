package controleRemoto.app;

import controleRemoto.classes.controle.ControleSamsung;
import controleRemoto.classes.controle.ControleSony;
import controleRemoto.classes.tv.TVSamsung;
import controleRemoto.classes.tv.TVSony;

public class Controles {

	public static void main(String[] args) {
		TVSony sony = new TVSony(100, 1, 300);
		TVSamsung sam = new TVSamsung(50, 1, 500);
		System.out.println(sony);
		System.out.println(sam);

		ControleSony cson = new ControleSony(sony);
		cson.onOff();
		cson.pretoEBranco();

		ControleSamsung csam = new ControleSamsung(sam);
		csam.onOff();
		csam.timer(30);
		
	}

}
