package av3.correcao.pagel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Acoes {

	private String nome;
	private String simbolo;
	private List<Cotacao> cotacao;

	public Acoes() {
		this.cotacao = new ArrayList<Cotacao>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public List<Cotacao> getCotacao() {
		return cotacao;
	}

	public void setCotacao(List<Cotacao> cotacao) {
		this.cotacao = cotacao;
	}

	public LocalDate retornaDiaMaiorPercentual() {

		LocalDate dataMaiorPercentual = LocalDate.now();

		double maiorPercentual = 0;

		double percentual;

		for (Cotacao cotacao2 : cotacao) {

			if (cotacao2.getFechamento().doubleValue() > cotacao2.getAbertura().doubleValue()) {
				percentual = ((100 * cotacao2.getFechamento().doubleValue()) / cotacao2.getAbertura().doubleValue())
						- 100;

				if (percentual > maiorPercentual) {
					maiorPercentual = percentual;
					dataMaiorPercentual = cotacao2.getData();
				}

			}
		}

		return dataMaiorPercentual;

	}

	public double calculaPercentual() {

		double maiorPercentual = 0;

		double percentual;

		for (Cotacao cotacao2 : cotacao) {

			if (cotacao2.getFechamento().doubleValue() > cotacao2.getAbertura().doubleValue()) {
				percentual = ((100 * cotacao2.getFechamento().doubleValue()) / cotacao2.getAbertura().doubleValue())
						- 100;

				if (percentual > maiorPercentual)
					maiorPercentual = percentual;
			}

		}
		return maiorPercentual;
	}
}
