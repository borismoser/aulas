package controleRemoto.classes.controle;

import controleRemoto.classes.tv.ITV;

public abstract class ControleTV implements IControleTV {

	private ITV tv;

	public ControleTV(ITV tv) {
		this.tv = tv;
	}

	@Override
	public String toString() {
		return "Novo controle remoto para a TV " + tv;
	}

	@Override
	public void volumeUp() {
		tv.aumentarVolume();
	}

	@Override
	public void volumeDown() {
		tv.diminuirVolume();
	}

	@Override
	public void ChannelUp() {
		tv.aumentarCanal();
	}

	@Override
	public void ChannelDown() {
		tv.diminuirCanal();
	}

	@Override
	public void onOff() {
		tv.ligarDesligar();
	}

	@Override
	public void mute() {
		tv.comSomSemSom();
	}
	
	ITV getTv() {
		return tv;
	}

}
