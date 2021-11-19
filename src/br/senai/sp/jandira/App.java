package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.ui.FrameGestaoJogos;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FabricanteRepository fabricantes = new FabricanteRepository();
//		Jogo jogo = new Jogo();
//		jogo.setFabricante(fabricantes.getFabricantes("Sega"));
//		System.out.println(jogo.getFabricante());
		
		
		FrameGestaoJogos frame = new FrameGestaoJogos();
		frame.setVisible(true);
		

	}

}
