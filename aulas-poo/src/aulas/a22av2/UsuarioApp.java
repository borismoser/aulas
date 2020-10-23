package aulas.a22av2;

public class UsuarioApp {

	public static void main(String[] args) {

		Usuario u = new Usuario("eu", "xx");
		System.out.println(u.loginOK("xx"));
		System.out.println(u.trocarSenha("xx", "y"));
		System.out.println(u.trocarSenha("y", "yy"));
		System.out.println(u.trocarSenha("yy", "xx"));
		System.out.println(u.trocarSenha("yy", "xxx"));
		System.out.println(u.trocarSenha("xxx", "abcd"));

	}

}
