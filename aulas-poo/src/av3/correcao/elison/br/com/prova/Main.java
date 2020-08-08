package av3.correcao.elison.br.com.prova;

import av3.correcao.elison.br.com.prova.components.Menu;
import av3.correcao.elison.br.com.prova.core.Banco;

public class Main {

    public static void main(String[] args) {
        Banco.inicializar();
        Menu.showMenu();
    }
}
