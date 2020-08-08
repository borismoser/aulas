package folhaPagamento.app;

import java.util.ArrayList;
import java.util.List;

import folhaPagamento.classes.BaseMaisComissao;
import folhaPagamento.classes.Comissionado;
import folhaPagamento.classes.Empregado;
import folhaPagamento.classes.Fatura;
import folhaPagamento.classes.Horista;
import folhaPagamento.classes.Mensalista;
import folhaPagamento.classes.NotaFiscalSC;
import folhaPagamento.classes.Pagavel;
import folhaPagamento.classes.Tributavel;

public class folhaApp {

	public static void main(String[] args) {
		List<Empregado> emp = new ArrayList<>();
		emp.add(new Mensalista("mensalista", "", "", 2000));
		emp.add(new Horista("horista", "", "", 50, 40));
		emp.add(new Horista("horista", "", "", 40, 50));
		emp.add(new Horista("horista", "", "", 120, 22));
		emp.add(new Comissionado("comissionado", "", "", 12345, 0.05));
		emp.add(new BaseMaisComissao("base+comissão", "", "", 8666, 0.03, 1500));

		for (Empregado e : emp) {
			System.out.println(e.getNome() + " --> " + e.getSalarioBruto() + " --> " + e.getTotalDevido());
		}

		Fatura fat = new Fatura("000", 25, 9.24);
		System.out.println("Fatura do item " + fat.getCodigoItem() + " --> " + fat.getTotalDevido());
		System.out.println(fat instanceof Pagavel);
		
		List<Pagavel> pagar = new ArrayList<>();
		pagar.add(fat);
		pagar.addAll(emp);
		pagar.add(new Fatura("001", 33, 1.5));
		
		NotaFiscalSC nsc = new NotaFiscalSC();

		for (Pagavel pag : pagar) {
			if (pag instanceof Fatura) {
				System.out.println("Fatura do item " + ((Fatura) pag).getCodigoItem() + " --> " + pag.getTotalDevido());
				System.out.println("Imposto da fatura " + " --> " + ((Tributavel) pag).getImpostoDevido());
			} else if (pag instanceof Empregado) {
				System.out.println(((Empregado) pag).getNome() + " --> " + pag.getTotalDevido());
				System.out.println("Imposto de renda " + " --> " + ((Tributavel) pag).getImpostoDevido());
			}
		}

	}

}
