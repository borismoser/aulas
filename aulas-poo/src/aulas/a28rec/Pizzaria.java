package aulas.a28rec;

import java.util.ArrayList;
import java.util.Objects;

public class Pizzaria {

	private String nomePizzaria;
	private ArrayList<PedidoPizzaPequena> pedidosP;
	private ArrayList<PedidoPizzaMedia> pedidosM;
	private ArrayList<PedidoPizzaGrande> pedidosG;

	public Pizzaria(String nomePizzaria) {
		this.nomePizzaria = Objects.requireNonNull(nomePizzaria);
		pedidosP = new ArrayList<>();
		pedidosM = new ArrayList<>();
		pedidosG = new ArrayList<>();
	}

	public boolean novoPedido(PedidoPizzaPequena pq) {
		if (pedidosP.contains(pq))
			return false;
		return pedidosP.add(pq);
	}

	public boolean novoPedido(PedidoPizzaMedia md) {
		if (pedidosM.contains(md))
			return false;
		return pedidosM.add(md);
	}

	public boolean novoPedido(PedidoPizzaGrande gr) {
		if (pedidosG.contains(gr))
			return false;
		return pedidosG.add(gr);
	}

	public String getNomePizzaria() {
		return nomePizzaria;
	}
	
	public double getValorTotalPedidos() {
		return 0.0;
	}
}
