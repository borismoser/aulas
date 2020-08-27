package outros;

public class CPF {
	private String digitos;

	public String getDigitos() {
		return digitos;
	}

	public void setDigitos(String digitos) {
		if (digitos == null) return;
		if (digitos.length() == 11) {
			for (int i=0; i<11; i++) {
				if (!Character.isDigit(digitos.charAt(0))) {
					return;
				}
			}
			this.digitos = digitos;
		}
	}
}
