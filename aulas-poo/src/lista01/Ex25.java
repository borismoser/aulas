/*
Um determinado jogo termina quando um dos dois jogadores consegue fazer 7 (sete) 
pontos e a diferença para o outro jogador for de pelo menos (dois) 2 pontos. Se a 
diferença for menor, o jogo continua até que um deles obtenha tal diferença em 
relação ao outro. 
Escreva um algoritmo que registre jogada a jogada qual jogador pontuou, até que um 
deles vença a partida. 
O placar atualizado deve ser mostrado a cada jogada, e no final da partida deve ser 
mostrado o vencedor.
*/
package lista01;

public class Ex25 {

	public static void main(String[] args) {
		int placar1 = 0;
		int placar2 = 0;
		boolean acabou = false;
		do {
			String ponto = Ex00.lerString("Qual jogador pontuou (1 ou 2) ? ").trim();
			if (ponto.equals("1")) {
				placar1++;
			} else if (ponto.equals("2")) {
				placar2++;
			}
			System.out.printf("Placar: Jogador 1 (%d) x (%d) Jogador 2%n%n", placar1, placar2);
			if (placar1 >= 7 || placar2 >= 7) {
				if (Math.abs(placar1 - placar2) >= 2) {
					acabou = true;
				}
			}
		} while (!acabou);
		System.out.printf("Vitória do Jogador %d", placar1 > placar2 ? 1 : 2);
	}

}
