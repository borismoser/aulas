package bingo;

import java.security.SecureRandom;
import java.util.Arrays;

public class BingoAppArray {

	private static int[] numerosDisponiveis = new int[75];

	private static SecureRandom sr = new SecureRandom();

	public static void main(String[] args) {

		for (int k = 0; k < 75; k++) {
			numerosDisponiveis[k] = k + 1;
		}

		int qtJogadores = 50;
		int qtCartelas = 15;

		int[][][][] jogadores = new int[qtJogadores][qtCartelas][5][5];

		for (int jog = 0; jog < jogadores.length; jog++) {
			for (int cart = 0; cart < jogadores[jog].length; cart++) {
				do {
					montarCartela(jogadores[jog][cart]);
				} while (ehCartelaRepetida(jogadores, jog, cart));
			}
		}

		int[] disponivel = new int[75];
		System.arraycopy(numerosDisponiveis, 0, disponivel, 0, 75);
		int[] numerosSorteados = new int[75];
		for (int i = 0; i < 25; i++) {
			int n;
			do {
				n = sortearNumero(1, 75);
			} while (disponivel[n - 1] == 0);
			disponivel[n - 1] = 0;
			numerosSorteados[n - 1] = n;
		}

		while (!haVencedor(jogadores, numerosSorteados)) {
			int n;
			do {
				n = sortearNumero(1, 75);
			} while (disponivel[n - 1] == 0);
			disponivel[n - 1] = 0;
			numerosSorteados[n - 1] = n;
		}
		System.out.println(Arrays.toString(numerosSorteados));

	}

	private static boolean haVencedor(int[][][][] jogadores, int[] sorteio) {
		boolean temVencedor = false;
		for (int i = 0; i < jogadores.length; i++) {
			for (int j = 0; j < jogadores[i].length; j++) {
				if (cartelaVencedora(jogadores[i][j], sorteio)) {
					temVencedor = true;
					imprimirCartela(jogadores[i][j]);
				}

			}
		}
		return temVencedor;
	}

	private static boolean cartelaVencedora(int[][] cartela, int[] sorteio) {
		for (int y = 0; y < 5; y++) {
			for (int z = 0; z < 5; z++) {
				boolean achou = false;
				if (cartela[y][z] == 0) {
					achou = true;
				} else {
					for (int x : sorteio) {
						if (cartela[y][z] == x) {
							achou = true;
						}
					}
				}
				if (!achou) {
					return false;
				}
			}
		}
		return true;
	}

	private static void montarCartela(int[][] cartela) {
		int[] disponivel = new int[75];
		for (int i = 0; i < 5; i++) {
			System.arraycopy(numerosDisponiveis, 0, disponivel, 0, 75);
			int n;
			for (int j = 0; j < 5; j++) {
				do {
					n = (15 * i + 1);
					n = sortearNumero(n, n+14);
				} while (disponivel[n - 1] == 0);
				disponivel[n - 1] = 0;
				cartela[i][j] = n;
			}
			Arrays.sort(cartela[i]);
		}
		// o elemento central da cartela não contém um número válido para o bingo.
		cartela[2][2] = 0;
	}
	
	private static int sortearNumero(int inicio, int fim) {
		int escala = fim - inicio + 1;
		return inicio + sr.nextInt(escala);
	}

	private static boolean ehCartelaRepetida(int[][][][] jogadores, int jogador, int cartela) {
		for (int i = 0; i <= jogador; i++) {
			for (int j = 0; j < cartela; j++) {
				if (Arrays.deepEquals(jogadores[i][j], jogadores[jogador][cartela])) {
					System.out.println("Cartela repetida!");
					return true;
				}
			}
		}
		return false;
	}

	private static void imprimirCartela(int[][] cartela) {
		System.out.println("----------------------");
		System.out.println("   B   I   N   G   O");
		System.out.println("----------------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%4d", cartela[j][i]);
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

}
