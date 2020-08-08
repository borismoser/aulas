package folhaPagamentoHerancaInterface.app;

import java.util.ArrayList;
import java.util.List;

import folhaPagamentoHerancaInterface.classes.BaseMaisComissao;
import folhaPagamentoHerancaInterface.classes.Comissionado;
import folhaPagamentoHerancaInterface.classes.Empregado;
import folhaPagamentoHerancaInterface.classes.Fatura;
import folhaPagamentoHerancaInterface.classes.Horista;
import folhaPagamentoHerancaInterface.classes.Mensalista;
import folhaPagamentoHerancaInterface.classes.Pagavel;

public class folhaApp {

	public static void main(String[] args) {
		Empregado emp;
		List<Empregado> empregados = new ArrayList<>();

		emp = new Empregado("mensalista", "i", "000");
		emp.setModeloPagamento(new Mensalista(2050));
		empregados.add(emp);

		emp = new Empregado("mensalista", "ii", "001");
		emp.setModeloPagamento(new Mensalista(3100));
		empregados.add(emp);

		emp = new Empregado("horista", "i", "002");
		emp.setModeloPagamento(new Horista(50, 40));
		empregados.add(emp);

		emp = new Empregado("horista", "ii", "003");
		emp.setModeloPagamento(new Horista(40, 50));
		empregados.add(emp);

		emp = new Empregado("comissionado", "i", "004");
		emp.setModeloPagamento(new Comissionado(12345, 0.05));
		empregados.add(emp);

		emp = new Empregado("base+comissão", "i", "005");
		emp.setModeloPagamento(new BaseMaisComissao(8666, 0.03, 1500));
		empregados.add(emp);

		for (Empregado e : empregados) {
			System.out.println(e + " --> " + e.getModeloPagamento().getSalarioBruto());
		}

		Fatura fat = new Fatura("111", 25, 9.24);
		List<Pagavel> pagar = new ArrayList<>();

		pagar.add(fat);
		pagar.addAll(empregados);
		fat = new Fatura("222", 33, 1.5);
		pagar.add(fat);

		for (Pagavel pag : pagar) {
			if (pag instanceof Fatura) {
				System.out.print("Fatura ");
			} else if (pag instanceof Empregado) {
				System.out.print("Empregado ");
			}
			System.out.println(pag + " --> " + pag.getTotalDevido());
		}

	}

}
