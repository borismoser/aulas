package aulas.a22av2.q1;

public class Q1 {

	public static void main(String[] args) {

		// Usuario n = new Usuario(null, null);

		Usuario u = new Usuario("k", "x");

		System.out.println(u.loginOK("x"));

		System.out.println(u.trocarSenha("x", "y"));
		System.out.println(u.loginOK("y"));
		System.out.println(u.trocarSenha("y", null));
	}

}
