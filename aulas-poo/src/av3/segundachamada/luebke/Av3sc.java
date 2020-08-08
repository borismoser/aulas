package av3.segundachamada.luebke;

public class Av3sc {

	public static void main(String[] args) {
		Banco.inicializar();
		
		boolean fim = false;
		
		do {
			fim = Metodos.menuOpcoes();
		} while (!fim);
	}
	
}