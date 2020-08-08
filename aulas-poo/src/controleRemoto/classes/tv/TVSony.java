package controleRemoto.classes.tv;

public class TVSony extends TV {

	public TVSony(int maxVolume, int minCanal, int maxCanal) {
		super(maxVolume, minCanal, maxCanal);
	}

	@Override
	public String toString() {
		return "TV Sony " + this.getSerial();
	}

	public void modoPretoEBranco() {
		//
	}
}
