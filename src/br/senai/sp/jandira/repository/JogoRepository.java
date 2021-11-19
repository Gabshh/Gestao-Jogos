package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Jogo;

public class JogoRepository {
	
private Jogo[] colecao;
	
	// Construtor Padr�o:

	public JogoRepository() {
		colecao = new Jogo[3];
	}
	
	// Construtor flex�vel:
	
	public JogoRepository(int quantidadeJogos) {
		colecao = new Jogo[quantidadeJogos];
	}
	
	public void gravar(Jogo jogo, int posicao) {
		colecao[posicao] = jogo;
	}
	
	public Jogo listarJogo(int posicao) {
		return colecao[posicao];
	}
	
	public Jogo[] listarTodos() {
		return colecao;
	}
	
	public int getTamanho() {
		return colecao.length;
	}

}


