package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.tabela.TabelaSala01;

import javax.swing.JButton;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel = null;
	private JButton btnsala01 = null;
	private JButton btnsala02 = null;
	private JButton btnsala03 = null;
	private JButton btnsala04 = null;
	private JButton btnsala05 = null;

	public TelaInicial() {
		//super();
		inicializaJanela();
	}
	private void inicializaJanela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 679, 471);
		this.setContentPane(getPainel());
	}
	private JPanel getPainel(){
		if (painel==null) {
			painel = new JPanel();
			painel.setBorder(new EmptyBorder(5, 5, 5, 5));
			painel.setLayout(null);
			//painel.add(btnSala01());
		}
		return painel;
	}
	private JButton btnSala01() {
		if (btnsala01 == null ) {
			btnsala01 = new JButton("SALA 01");
			btnsala01.setBounds(60, 162, 89, 69);
			getPainel().add(btnsala01);
			btnsala01.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabelaSala01();
					
				}
			});
		}
		return btnsala01;
	}
	private JButton btnSala02() {
		if (btnsala02 == null ) {
			btnsala02 = new JButton("SALA 02");
			btnsala02.setBounds(160, 162, 89, 69);
			getPainel().add(btnsala02);
			btnsala02.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabelaSala01();
					
				}
			});
		}
		return btnsala02;
	}
	private JButton btnSala03() {
		if (btnsala03 == null ) {
			btnsala03 = new JButton("SALA 03");
			btnsala03.setBounds(270, 162, 89, 69);
			getPainel().add(btnsala03);
			btnsala03.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabelaSala01();
				}
			});
		}
		return btnsala03;
	}
	private JButton btnSala04() {
		if (btnsala04 == null ) {
			btnsala04 = new JButton("SALA 04");
			btnsala04.setBounds(380, 162, 89, 69);
			getPainel().add(btnsala04);
			btnsala04.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabelaSala01();
					
				}
			});
		}
		return btnsala04;
	}
	private JButton btnSala05() {
		if (btnsala05 == null ) {
			btnsala05 = new JButton("SALA 05");
			btnsala05.setBounds(490, 162, 89, 69);
			getPainel().add(btnsala05);
			btnsala05.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					tabelaSala01();
				}
			});
		}
		return btnsala05;
	}
	private void tabelaSala01() {
		//TabelaSala01 sala01 = new TabelaSala01();
		//sala01.setVisible(true);//----------------------------onde parei
	}
	public void TelaInicial() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 679, 471);
//		painel = new JPanel();
//		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(painel);
//		painel.setLayout(null);
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 722, 432);
//		painel.add(panel);
//		panel.setLayout(null);
		
		JButton btnSala01 = new JButton("SALA 01");
		btnSala01.setBounds(63, 162, 89, 69);
//		panel.add(btnSala01);
		
		JButton btnSala02 = new JButton("SALA 02");
		btnSala02.setBounds(173, 162, 89, 69);
//		panel.add(btnSala02);
		
		JButton btnSala03 = new JButton("SALA 03");
		btnSala03.setBounds(285, 162, 89, 69);
//		panel.add(btnSala03);
		
		JButton btnSala04 = new JButton("SALA 04");
		btnSala04.setBounds(397, 162, 89, 69);
//		panel.add(btnSala04);
		
		JButton btnSala05 = new JButton("SALA 05");
		btnSala05.setBounds(511, 162, 89, 69);
//		panel.add(btnSala05);
		
		btnSala01.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cadastro cadastro = new Cadastro("sala01");
				cadastro.setVisible(true);
			}
		});
		btnSala02.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cadastro cadastro = new Cadastro("sala02");
				cadastro.setVisible(true);
			}
		});
		btnSala03.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cadastro cadastro = new Cadastro("sala03");
				cadastro.setVisible(true);
			}
		});
		btnSala04.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cadastro cadastro = new Cadastro("sala04");
				cadastro.setVisible(true);
			}
		});
		btnSala05.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cadastro cadastro = new Cadastro("sala05");
				cadastro.setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
