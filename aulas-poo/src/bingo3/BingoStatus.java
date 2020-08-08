package bingo3;

public enum BingoStatus {
	preGame("Aguardando Jogadores..."),
	inGame("Bingo em andamento..."),
	postGame("Bingo encerrado...");

	private final String mensagem;

	BingoStatus(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}
}
