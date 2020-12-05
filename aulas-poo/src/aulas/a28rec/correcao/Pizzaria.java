package aulas.a28rec.correcao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pizzaria {

	private String nomePizzaria;
	
	private ArrayList<PedidoPizzaPequena> pequenas = new ArrayList<>();
	private ArrayList<PedidoPizzaMedia> medias = new ArrayList<>();
	private ArrayList<PedidoPizzaGrande> grandes = new ArrayList<>();
	
	public Pizzaria(String nomePizzaria) {
		this.nomePizzaria = nomePizzaria;
	}


	public boolean novoPedido(PedidoPizzaPequena pedidoPq) {
		if(pequenas.contains(pedidoPq)) {
			System.out.println("Este pedido já foi inserido!");
			return false;
		} else {
			pequenas.add(pedidoPq);
			System.out.println("O pedido foi inserido com sucesso");
		}
		return true;
	}
	
	public boolean novoPedido(PedidoPizzaMedia pedidoMed) {
		if(medias.contains(pedidoMed)) {
			System.out.println("Este pedido já foi inserido!");
			return false;
		} else {
			medias.add(pedidoMed);
			System.out.println("O pedido foi inserido com sucesso");
		}
		return true;
	}
	
	public boolean novoPedido(PedidoPizzaGrande pedidoGr) {
		if(grandes.contains(pedidoGr)) {
			System.out.println("Este pedido já foi inserido!");
			return false;
		} else {
			grandes.add(pedidoGr);
			System.out.println("O pedido foi inserido com sucesso");
		}
		return true;
	}

	public String getNomePizzaria() {
		return nomePizzaria;
	}
	
	public double getValorTotalPedidos() {
		double aux = 0;
		//Começa listagem de pedidos
		for (PedidoPizzaGrande pedidoPizzaGrande : grandes) {
			aux += pedidoPizzaGrande.getPreco();
		}
		for (PedidoPizzaMedia pedidoPizzaMedia : medias) {
			aux += pedidoPizzaMedia.getPreco();
		}
		for (PedidoPizzaPequena pedidoPizzaPequena : pequenas) {
			aux += pedidoPizzaPequena.getPreco();
		}
		
		return aux;
	}
	
	
}
