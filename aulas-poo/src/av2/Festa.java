package av2;

import java.util.ArrayList;

public class Festa {
	private Pessoa organizador;
	private String motivo;
	private ArrayList<Convidado> convidados;

	public Festa(String motivo) {
		this.motivo = motivo;
		this.convidados = new ArrayList<>();
	}
	public void setOrganizador(Pessoa pessoa) {
		this.organizador = pessoa;
	}
	public void convidar(Pessoa pessoa, boolean temAcompanhante, boolean confirmouPresenca) {
		Convidado convidado = new Convidado(pessoa, temAcompanhante, confirmouPresenca);
		convidados.add(convidado);
	}
	
	public int getQtdeConvidados() {
		return convidados.size();
	}
	
	public int getQtdeConvidados(Sexo sexo) {
		int n = 0;
		for (Convidado con : convidados) {
			if (con.getPessoaConvidada().getSexo() == sexo) {
				n++;
			}
		}
		return n;
	}
	
	public int getQtdePessoasConfirmadas() {
		int n = 0;
		for (Convidado con : convidados) {
			if (con.isConfirmouPresenca()) {
				n++;
			}
		}
		return n;
	}
	
	public int getQtdePessoasConfirmadas(Sexo sexo) {
		int n = 0;
		for (Convidado con : convidados) {
			if (con.isConfirmouPresenca() && con.getPessoaConvidada().getSexo() == sexo) {
				n++;
			}
		}
		return n;
	}
	
	public void imprimirConvites() {
		for (Convidado con : convidados) {
			String convite = "Olá, %s!%nConto com a sua presença na festa %s.%nAtt, %s%n%n";
			System.out.printf(String.format(convite, con.getPessoaConvidada().getNome(),
					this.motivo, this.organizador.getNome()));
		}
	}
}
