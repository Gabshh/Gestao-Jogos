package br.senai.sp.jandira.model;

public class Fabricante {
	
	String nome;
	String fundacao;
	String outrosJogos;
	
	public Fabricante(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFundacao() {
		return fundacao;
	}
	public void setFundacao(String fundacao) {
		this.fundacao = fundacao;
	}
	public String getOutrosJogos() {
		return outrosJogos;
	}
	public void setOutrosJogos(String outrosJogos) {
		this.outrosJogos = outrosJogos;
	}
	
	@Override
	public String toString() {
		return "Fabricante { \n nome: " + nome + "}";
	
	}
	
	

}
