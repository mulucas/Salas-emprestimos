package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.tabela.TabelaSala;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblControleDeSalas = new JLabel("CONTROLE DE SALAS");
		lblControleDeSalas.setFont(new Font("Verdana", Font.PLAIN, 26));
		lblControleDeSalas.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDeSalas.setBounds(150, 24, 289, 58);
		contentPane.add(lblControleDeSalas);
		
		JButton btnSala1 = new JButton("sala01");
		btnSala1.setBounds(50, 108, 89, 53);
		contentPane.add(btnSala1);
		btnSala1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abreTabela(btnSala1.getText());
			}
		});
		
		JButton btnSala2 = new JButton("sala02");
		btnSala2.setBounds(150, 108, 89, 53);
		contentPane.add(btnSala2);
		btnSala2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abreTabela(btnSala2.getText());
			}
		});
		JButton btnSala3 = new JButton("sala03");
		btnSala3.setBounds(250, 108, 89, 53);
		contentPane.add(btnSala3);
		btnSala3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abreTabela(btnSala3.getText());
			}
		});
		JButton btnSala4 = new JButton("sala04");
		btnSala4.setBounds(350, 108, 89, 53);
		contentPane.add(btnSala4);
		btnSala4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abreTabela(btnSala4.getText());
			}
		});
		JButton btnSala5 = new JButton("sala05");
		btnSala5.setBounds(450, 108, 89, 53);
		contentPane.add(btnSala5);
		btnSala5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abreTabela(btnSala5.getText());
			}
		});
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/ufersa.png"));
		JLabel lblNewLabel_4 = new JLabel(logo);
		lblNewLabel_4.setBounds(10, 113, 560, 225);
		contentPane.add(lblNewLabel_4);
		
		JButton btnEmprestimosMateriais = new JButton("Materiais");
		btnEmprestimosMateriais.setBounds(240, 278, 109, 53);
		contentPane.add(btnEmprestimosMateriais);
		btnEmprestimosMateriais.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abreTabela(btnEmprestimosMateriais.getText());
			}
		});
	}
	private void abreTabela(String nSala) {
		TabelaSala sala01 = new TabelaSala(nSala);
		sala01.setVisible(true);
	}
}
