package controleRemoto.classes.tv;

public class TVSamsung extends TV {

	public TVSamsung(int maxVolume, int minCanal, int maxCanal) {
		super(maxVolume, minCanal, maxCanal);
	}

	@Override
	public String toString() {
		return "TV Samsung " + this.getSerial();
	}

	public void setTimer(int minutos) {
		//
	}

}
