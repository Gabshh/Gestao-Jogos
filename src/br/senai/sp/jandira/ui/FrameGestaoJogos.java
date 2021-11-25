package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.model.Console;
import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class FrameGestaoJogos extends JFrame {

	private JPanel contentPane;
	private JTextField txtTituloJogo;
	private JTextField txtValor;

	private int posicao = 0;
	
	public FrameGestaoJogos() {
		setResizable(false);
		setTitle("Gest\u00E3o de Jogos");
		setBackground(new Color(204, 204, 255));

		Font text = new Font("Corbel Light", Font.BOLD, 16);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(117, 133, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTituloJogo = new JLabel("T\u00EDtulo do jogo:");
		lblTituloJogo.setForeground(Color.BLACK);
		lblTituloJogo.setBounds(7, 20, 116, 30);
		lblTituloJogo.setFont(text);
		contentPane.add(lblTituloJogo);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(Color.BLACK);
		lblFabricante.setBounds(30, 52, 96, 30);
		lblFabricante.setFont(text);
		contentPane.add(lblFabricante);

		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(542, 6, 59, 44);
		lblIcon.setFont(text);
		contentPane.add(lblIcon);

		ImageIcon imgGame = new ImageIcon(getClass().getResource("../images/" + "gameIcon.png"));
		lblIcon.setIcon(imgGame);

		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setForeground(Color.BLACK);
		lblConsole.setBounds(49, 137, 78, 30);
		lblConsole.setFont(text);
		contentPane.add(lblConsole);

		JLabel lblValorEstimado = new JLabel("Valor estimado:");
		lblValorEstimado.setForeground(Color.BLACK);
		lblValorEstimado.setBounds(0, 170, 121, 30);
		lblValorEstimado.setFont(text);
		contentPane.add(lblValorEstimado);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setForeground(Color.BLACK);
		lblObservaes.setBounds(12, 211, 111, 30);
		lblObservaes.setFont(text);
		contentPane.add(lblObservaes);

		txtTituloJogo = new JTextField();
		txtTituloJogo.setBounds(126, 23, 198, 20);
		contentPane.add(txtTituloJogo);
		txtTituloJogo.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(117, 133, 254));
		btnSalvar.setForeground(new Color(255, 255, 255));

		btnSalvar.setBounds(10, 352, 314, 38);
		btnSalvar.setBorder(new RoundBtn(25));
		contentPane.add(btnSalvar);

		JButton btnAnterior = new JButton("\u2191");
		btnAnterior.setForeground(Color.WHITE);
		btnAnterior.setBorder(new br.senai.sp.jandira.ui.RoundBtn(25));
		btnAnterior.setBackground(new Color(117, 133, 254));
		btnAnterior.setBounds(410, 352, 70, 38);
		contentPane.add(btnAnterior);

		JButton btnSeguinte = new JButton("\u2193");
		btnSeguinte.setForeground(Color.WHITE);
		btnSeguinte.setBorder(new br.senai.sp.jandira.ui.RoundBtn(25));
		btnSeguinte.setBackground(new Color(117, 133, 254));
		btnSeguinte.setBounds(490, 352, 70, 38);
		contentPane.add(btnSeguinte);

		JLabel lblMeusJogos = new JLabel("Meus Jogos:");
		lblMeusJogos.setForeground(Color.BLACK);
		lblMeusJogos.setFont(new Font("Corbel Light", Font.BOLD, 16));
		lblMeusJogos.setBounds(382, 20, 116, 30);
		contentPane.add(lblMeusJogos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 49, 232, 292);
		contentPane.add(scrollPane);

		JList listJogos = new JList();
		scrollPane.setViewportView(listJogos);

		DefaultListModel<String> listaModel = new DefaultListModel<String>();
		listJogos.setModel(listaModel);

		// DEFINIR DESCRIÇÃO DO ENUM CONSOLES

		JComboBox comboConsole = new JComboBox();

		DefaultComboBoxModel<String> modelConsoles = new DefaultComboBoxModel<String>();

		for (Console c : Console.values()) {

			modelConsoles.addElement(c.getDescricao());

		}

		comboConsole.setModel(modelConsoles);

		comboConsole.setBackground(new Color(117, 133, 254));
		comboConsole.setForeground(new Color(255, 255, 255));
		comboConsole.setBounds(126, 139, 198, 22);
		contentPane.add(comboConsole);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(126, 173, 198, 20);
		contentPane.add(txtValor);

		JCheckBox cbZerado = new JCheckBox("Zerado");
		cbZerado.setBounds(129, 96, 78, 23);
		contentPane.add(cbZerado);
		
		FabricanteRepository fabricantes = new FabricanteRepository();
		JComboBox comboFabricante = new JComboBox();
		comboFabricante.setBackground(new Color(117, 133, 254));
		comboFabricante.setForeground(new Color(255, 255, 255));
		DefaultComboBoxModel<String> modelFabricantes = new DefaultComboBoxModel<String>();
		for (Fabricante f : fabricantes.getFabricantes()) {
			modelFabricantes.addElement(f.getNome());
		}
		
		
		comboFabricante.setModel(modelFabricantes);
		
		
		comboFabricante.setBounds(126, 54, 198, 22);
		contentPane.add(comboFabricante);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(126, 212, 198, 129);
		contentPane.add(scrollPane_1);
		
		JTextArea txtObservacoes = new JTextArea();
		scrollPane_1.setViewportView(txtObservacoes);
		txtObservacoes.setLineWrap(true);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(FrameGestaoJogos.class.getResource("/br/senai/sp/jandira/images/background.png")));
		lblBackground.setBounds(0, 0, 654, 431);
		contentPane.add(lblBackground);

		JogoRepository colecao = new JogoRepository();

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Jogo jogo = new Jogo();
				jogo.setTitulo(txtTituloJogo.getText());
				
				FabricanteRepository fabricantes = new FabricanteRepository();
//				jogo.setFabricante(comboFabricante.getSelectedIndex());

				jogo.setFabricante(fabricantes.getFabricantes()[comboFabricante.getSelectedIndex()]);
				
				// Boolean
				if (cbZerado.isSelected()) {
					jogo.setZerado(true);
				} else {
					jogo.setZerado(false);
				}
				
				jogo.setConsole(Console.values()[comboConsole.getSelectedIndex()]);
				
				double valor = Double.parseDouble(txtValor.getText());

				
				jogo.setValor(valor);
				
				jogo.setObservacoes(txtObservacoes.getText());

				colecao.gravar(jogo, posicao);
				posicao++;

				// Adicionar o titulo do jogo ao model da lista
				listaModel.addElement(jogo.getTitulo());

				if (posicao == colecao.getTamanho()) {
					btnSalvar.setEnabled(false);

					JOptionPane.showMessageDialog(null, "Sua coleção está cheia!!", "Cheio",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (listJogos.getSelectedIndex() > 0) {
					int indiceAnterior = listJogos.getSelectedIndex() - 1;
					listJogos.setSelectedIndex(indiceAnterior);
				} else {
					listJogos.setSelectedIndex(listJogos.getLastVisibleIndex());
				}
			}
				
				
			});
		
		btnSeguinte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (listJogos.getSelectedIndex() < listJogos.getLastVisibleIndex()) {
					int indiceSeguinte = listJogos.getSelectedIndex() + 1;
					listJogos.setSelectedIndex(indiceSeguinte);
				} else {
					listJogos.setSelectedIndex(0);
				}
				
			}
		});
		
		
		// Mostrar os detalhes do item selecionado:
		
		listJogos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				Jogo jogo = colecao.listarJogo(listJogos.getSelectedIndex());
				txtTituloJogo.setText(jogo.getTitulo());
				
//				comboFabricante.setSelectedIndex(fabricantes.getIndexOf(jogo.getFabricante()));
				comboFabricante.setSelectedIndex(Arrays.asList(fabricantes.getFabricantes()).indexOf(jogo.getFabricante()));
				
				cbZerado.setSelected(jogo.isZerado());
				
				txtValor.setText("" + jogo.getValor());
				
				comboConsole.setSelectedIndex(jogo.getConsole().ordinal());
				
				txtObservacoes.setText(jogo.getObservacoes());
				
			}
		});
		


	}
}

class RoundBtn implements Border {
	private int r;

	RoundBtn(int r) {
		this.r = r;
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
	}

	public boolean isBorderOpaque() {
		return true;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.drawRoundRect(x, y, width - 1, height - 1, r, r);
	}
}
