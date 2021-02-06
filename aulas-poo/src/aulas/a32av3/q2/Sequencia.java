package aulas.a32av3.q2;

public class Sequencia implements Imprimivel {

    private int inicio;
    private int fim;

    public Sequencia(int inicio, int fim) {
        if (inicio != 0 && fim != 0) {
            this.inicio = inicio;
            this.fim = fim;
        }
    }

    @Override
    public String formatoImpressao() {
        StringBuilder formatoImpressao = new StringBuilder();
        final String SEPARADOR = ", ";

        for (int i = this.inicio; i <= fim; i++) {
            if (i == fim) {
                formatoImpressao.append(String.valueOf(i));
            } else {
                formatoImpressao.append(String.valueOf(i) + SEPARADOR);
            }
        }

        return formatoImpressao.toString();
    }
}
