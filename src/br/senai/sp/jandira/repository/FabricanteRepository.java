package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {
	
	private Fabricante[] fabricantes;
	
	public FabricanteRepository() {
		fabricantes = new Fabricante[12];
		
		fabricantes[0] = new Fabricante("Nintendo");
		fabricantes[1] = new Fabricante("Sony");
		fabricantes[2] = new Fabricante("Sega");
		fabricantes[3] = new Fabricante("Capcom");
		fabricantes[4] = new Fabricante("Namco Bandai");
		fabricantes[5] = new Fabricante("Valve Corporation");
		fabricantes[6] = new Fabricante("Ubisoft");
		fabricantes[7] = new Fabricante("Microsoft");
		fabricantes[8] = new Fabricante("Rockstar Games");
		fabricantes[9] = new Fabricante("EA");
		fabricantes[10] = new Fabricante("Epic Games");
		fabricantes[11] = new Fabricante("Outro...");
		
		
	}

	public Fabricante[] getFabricantes() {
		return fabricantes;
	}
	
	public int getTamanho() {
		return fabricantes.length;
	}
	
	public void gravar(Fabricante fabricante, int posicao) {
		fabricantes[posicao] = fabricante;
	}
	
	public Fabricante listarFabricante(int posicao) {
		return fabricantes[posicao];
	}
	
	public Fabricante[] listarTodos() {
		return fabricantes;
	}
	
}


