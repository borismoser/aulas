package controleRemoto.classes.controle;

import controleRemoto.classes.tv.TVSamsung;

public class ControleSamsung extends ControleTV {

	public ControleSamsung(TVSamsung tv) {
		super(tv);
	}
	
	public void timer(int minutos) {
		((TVSamsung) this.getTv()).setTimer(minutos);
	}

}
