package aulas.a32av3.q2;

public class ContaBancaria implements Imprimivel {

    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
                this.titular = titular;
                this.saldo = saldo;
    }

    @Override
    public String formatoImpressao() {
        return "Nome: " + this.titular + ". Saldo: + " + this.saldo;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
