package controleRemoto.classes.controle;

import controleRemoto.classes.tv.TVSony;

public class ControleSony extends ControleTV {

	public ControleSony(TVSony tv) {
		super(tv);
	}
	
	public void pretoEBranco() {
		((TVSony) this.getTv()).modoPretoEBranco();
	}
}
