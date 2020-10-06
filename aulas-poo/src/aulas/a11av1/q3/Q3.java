package aulas.a11av1.q3;

import java.util.Random;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int qtdNumero1 = 0;
        int qtdNumero2 = 0;
        int qtdNumero3 = 0;
        int qtdNumero4 = 0;
        int qtdNumero5 = 0;
        int qtdNumero6 = 0;

        System.out.println("Digite a quantidade de vezes que o dado será lançado: ");
        int qtd = sc.nextInt();

        if (qtd < 1 || qtd > 150000) {
            System.out.println("O número deve estar entre 1 e 150.000");
            System.exit(0);
        }

        for (int i = 0; i < qtd; i++) {
            int numero = 1 + ran.nextInt(6);
            switch (numero) {
                case 1: qtdNumero1++; break;
                case 2: qtdNumero2++; break;
                case 3: qtdNumero3++; break;
                case 4: qtdNumero4++; break;
                case 5: qtdNumero5++; break;
                case 6: qtdNumero6++; break;
            }
        }

        System.out.println("Quantidade de vezes do dado 1: " + qtdNumero1);
        System.out.println("Quantidade de vezes do dado 2: " + qtdNumero2);
        System.out.println("Quantidade de vezes do dado 3: " + qtdNumero3);
        System.out.println("Quantidade de vezes do dado 4: " + qtdNumero4);
        System.out.println("Quantidade de vezes do dado 5: " + qtdNumero5);
        System.out.println("Quantidade de vezes do dado 6: " + qtdNumero6);
    }
}