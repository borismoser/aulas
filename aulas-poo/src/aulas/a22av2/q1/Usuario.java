package aulas.a22av2.q1;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

	private String usuario;
	private ArrayList<String> senhasUtilizadas = new ArrayList<>(5);

	public Usuario(String usuario, String senhaInicial) {
		this.usuario = Objects.requireNonNull(usuario);
		this.senhasUtilizadas.add(0, Objects.requireNonNull(senhaInicial));
	}

	public boolean loginOK(String senha) {
		return Objects.equals(senhasUtilizadas.get(0), senha);
	}

	public boolean trocarSenha(String senhaAtual, String senhaNova) {
		if (senhaNova == null)
			return false;
		if (!loginOK(senhaAtual))	return false;
		if (senhasUtilizadas.contains(senhaNova))
			return false;
		if (senhasUtilizadas.size() == 5)
			senhasUtilizadas.remove(4);
		senhasUtilizadas.add(0, senhaNova);
		return true;
	}

	public String getUsuario() {
		return usuario;
	}
}
