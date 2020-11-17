package aulas.a27.app;

import java.util.ArrayList;

import aulas.a27.modelo.BaseMaisComissao;
import aulas.a27.modelo.Comissionado;
import aulas.a27.modelo.Empregado;
import aulas.a27.modelo.Horista;
import aulas.a27.modelo.Mensalista;

public class folhaApp {

	public static void main(String[] args) {

		ArrayList<Empregado> emp = new ArrayList<>();
		
		emp.add(new Mensalista("mensalista", 2000));
		emp.add(new Horista("horista", 50, 40));
		emp.add(new Horista("horista", 40, 50));
		emp.add(new Horista("horista", 120, 22));
		emp.add(new Comissionado("comissionado", 12345, 0.05));
		emp.add(new BaseMaisComissao("base+comissão", 8666, 0.03, 1500));

		for (Empregado e : emp) {
			System.out.println(e.getNome() + " --> " + e.getSalarioBruto() + " --> " + e.getSalarioLiquido());
		}

	}

}
