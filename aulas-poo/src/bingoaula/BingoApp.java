package bingoaula;

public class BingoApp {

	public static void main(String[] args) {

		final int NR_JOGADORES = 50;
		final int NR_CARTELAS = 150;

		Bingo jogo = new Bingo(NR_JOGADORES, NR_CARTELAS);

		/*
		Cartela c1 = new Cartela();
		System.out.println(c1);
		Cartela c2 = new Cartela();
		System.out.println(c2);
		
		ArrayList<Integer> nc1 = c1.getNumeros();
		ArrayList<Integer> nc2 = new ArrayList<>(nc1);
		
		System.out.println(c1.hashCode());
		System.out.println(nc1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(nc2.hashCode());

		System.out.println(nc1.equals(nc2));
		System.out.println(nc1.containsAll(nc2));
		System.out.println(nc1 == nc2);
		*/
		
	}

}
