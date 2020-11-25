package aulas.a29.aparelhos.model;

public class ReceptorTVCabo extends Aparelho implements ControlarCanal {

	private String provedor;

	public ReceptorTVCabo(String marca, String modelo, String provedor) {
		super(marca, modelo);
		this.provedor = provedor;
	}

	@Override
	public int getCanal() {
		return 0;
	}

	@Override
	public void setCanal(int canal) {
	}

	@Override
	public void canalMais() {
	}

	@Override
	public void canalMenos() {
	}

	public String getProvedor() {
		return provedor;
	}

}
