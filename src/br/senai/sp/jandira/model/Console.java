package br.senai.sp.jandira.model;

public enum Console {
	
	ATARI("Atari"),
	NINTENDO("Nintendo"),
	PS("Playstation"),
	XBOX("XBox"),
	SWITCH("Nintendo Switch"),
	GAMEBOY("Nintendo");
	
private String descricao;
	
	private Console(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
