package aulas.a22av2.q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TstUsuario {

	@Test
	void testUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testLoginOK() {
		Usuario u = new Usuario("eu", "senha");
		assertTrue(u.loginOK("senha"));
	}
	
	@Test
	void testLoginOKAposTrocarSenha() {
		Usuario u = new Usuario("eu", "senha");
		u.trocarSenha("senha", "xyz");
		assertTrue(u.loginOK("xyz"));
	}
	
	@Test
	void testLoginNaoOK() {
		Usuario u = new Usuario("eu", "senha");
		assertFalse(u.loginOK("abc123"));
	}

	@Test
	void testTrocarSenha() {
		Usuario u = new Usuario("eu", "senha");
		assertTrue(u.trocarSenha("senha", "xyz"));
	}

	@Test
	void testTrocarSenhaComAtualErrada() {
		Usuario u = new Usuario("eu", "senha");
		assertFalse(u.trocarSenha("abc", "xyz"));
	}

	@Test
	void testTrocarSenhaParaNull() {
		Usuario u = new Usuario("eu", "senha");
		assertFalse(u.trocarSenha("abc", null));
	}
	
	@Test
	void testGetUsuario() {
		Usuario u = new Usuario("eu", "senha");
		assertEquals("eu", u.getUsuario());
	}

}
