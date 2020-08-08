package av3.correcao.andrei;

import java.util.Scanner;

import av3.Banco;

public class Av3
{
    public static void main(final String[] args) throws Exception {
        Banco.inicializar();
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Informe a letra da quest\u00e3o: ");
        Resolucao.Criar(teclado.next().toUpperCase().charAt(0));
    }
}