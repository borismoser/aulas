package aulas.a22av2.q1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class UsuarioTest {

	private static final String NOME_USUARIO = "Nome Válido";
	private static String SENHA_USUARIO = "q1w2e3";
	private static final Usuario USU = new Usuario(NOME_USUARIO, SENHA_USUARIO);

	private static String senhaAtual() {
		return SENHA_USUARIO;
	}
	
	private static String novaSenha(String pwd) {
		SENHA_USUARIO = pwd;
		return SENHA_USUARIO;
	}
	
	@DisplayName("Usuário não pode ter nome nulo.")
	@Order(1)
	@Test
	void testUsuarioNomeNulo() {
		assertThrows(NullPointerException.class, () -> {
			new Usuario(null, "");
		});
	}

	@DisplayName("Usuário não pode ter senha nula.")
	@Order(2)
	@Test
	void testUsuarioSenhaNula() {
		assertThrows(NullPointerException.class, () -> {
			new Usuario("ok", null);
		});
	}

	@DisplayName("Criar um usuário válido.")
	@Order(3)
	@Test
	void testUsuario() {
		Usuario u = new Usuario("Nome Válido", "q1w2e3");
		assertNotNull(u);
	}

	@DisplayName("Retornar o nome do usuário.")
	@Order(6)
	@Test
	void testGetUsuario() {
		assertEquals(NOME_USUARIO, USU.getUsuario());
	}

	@DisplayName("Primeira troca de senha.")
	@Order(7)
	@Test
	void testTrocarSenha1() {
		assertTrue(USU.trocarSenha(senhaAtual(), novaSenha("a1s2d3")));
	}

	@DisplayName("Login correto após troca de senha.")
	@Order(8)
	@Test
	void testLoginOK() {
		assertTrue(USU.loginOK(senhaAtual()));
	}
	
	@DisplayName("Login incorreto após troca de senha.")
	@Order(9)
	@Test
	void testLoginNOK() {
		assertFalse(USU.loginOK("xyz"));
	}
	
	@DisplayName("Segunda troca de senha.")
	@Order(10)
	@Test
	void testTrocarSenha2() {
		assertTrue(USU.trocarSenha(senhaAtual(), novaSenha("qwerty")));
	}
	
	@DisplayName("Tentativa de troca de senha igual à atual.")
	@Order(11)
	@Test
	void testTrocarSenha3() {
		assertFalse(USU.trocarSenha(senhaAtual(), senhaAtual()));
	}
	
	@DisplayName("Tentativa de troca de senha igual a uma anterior.")
	@Order(12)
	@Test
	void testTrocarSenha4() {
		assertFalse(USU.trocarSenha(senhaAtual(), "a1s2d3"));
	}
	
	@DisplayName("Terceira troca de senha.")
	@Order(13)
	@Test
	void testTrocarSenha5() {
		assertTrue(USU.trocarSenha(senhaAtual(), novaSenha("h6g5f4")));
	}
	
	@DisplayName("Quarta troca de senha.")
	@Order(14)
	@Test
	void testTrocarSenha6() {
		assertTrue(USU.trocarSenha(senhaAtual(), novaSenha("c9v8b7")));
	}
	
	@DisplayName("Quinta troca de senha.")
	@Order(15)
	@Test
	void testTrocarSenha7() {
		assertTrue(USU.trocarSenha(senhaAtual(), novaSenha("n3b4v5")));
	}
	
	@DisplayName("Sexta troca de senha: tentativa de colocar a primeira novamente.")
	@Order(16)
	@Test
	void testTrocarSenha8() {
		assertTrue(USU.trocarSenha(senhaAtual(), novaSenha("q1w2e3")));
	}
	
	@DisplayName("Tentativa de troca de senha com a atual incorreta.")
	@Order(17)
	@Test
	void testTrocarSenha9() {
		assertFalse(USU.trocarSenha("senha errada", novaSenha("000000x")));
	}
	
	@DisplayName("Tentativa de troca de senha nula.")
	@Order(18)
	@Test
	void testTrocarSenha10() {
		assertFalse(USU.trocarSenha("senha errada", null));
	}
}

