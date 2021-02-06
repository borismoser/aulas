package aulas.a32av3.q2;

import java.util.ArrayList;

public class FilaImpressao {
    private ArrayList<Imprimivel> filaParaImprimir;
    private Impressora impressora;

    public FilaImpressao() {
        filaParaImprimir = new ArrayList<>();
        impressora = new Impressora();
    }

    public void incluirNaFila(Imprimivel imprimivel) {
        filaParaImprimir.add(imprimivel);
    }

    public void imprimirTodos() {
        filaParaImprimir.forEach(imprimivel -> {
            impressora.imprimir(imprimivel);
        });

        filaParaImprimir.clear();
    }
}
