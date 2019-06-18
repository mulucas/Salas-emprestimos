package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.tabela.TabelaSala01;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTextField txtHoraEntrada;
	private JTextField txtHoraSaida;
	private JCheckBox cbxPiloto;
	private JCheckBox chckApagador;

	public Cadastro() {

	}

	public Cadastro(String sala) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 434);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(25, 64, 95, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(25, 89, 305, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatricula.setBounds(25, 120, 95, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(25, 145, 305, 20);
		contentPane.add(txtMatricula);

		JLabel lblHorarioDeEntrada = new JLabel("Horario de entrada:");
		lblHorarioDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHorarioDeEntrada.setBounds(25, 176, 139, 14);
		contentPane.add(lblHorarioDeEntrada);

		txtHoraEntrada = new JTextField();
		txtHoraEntrada.setColumns(10);
		txtHoraEntrada.setBounds(25, 201, 139, 20);
		contentPane.add(txtHoraEntrada);

		JLabel lblHorarioDeSaida = new JLabel("Horario de saida:");
		lblHorarioDeSaida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHorarioDeSaida.setBounds(191, 176, 139, 14);
		contentPane.add(lblHorarioDeSaida);

		txtHoraSaida = new JTextField();
		txtHoraSaida.setColumns(10);
		txtHoraSaida.setBounds(191, 201, 139, 20);
		contentPane.add(txtHoraSaida);

		JLabel lblResevarSala = new JLabel("RESERVAR SALA");
		lblResevarSala.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		lblResevarSala.setBounds(98, 11, 160, 14);
		contentPane.add(lblResevarSala);

		JLabel lblDados = new JLabel("DADOS");
		lblDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDados.setBounds(145, 36, 95, 14);
		contentPane.add(lblDados);

		JLabel lblMateriais = new JLabel("MATERIAIS");
		lblMateriais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMateriais.setBounds(131, 232, 95, 14);
		contentPane.add(lblMateriais);

		cbxPiloto = new JCheckBox("Piloto");
		cbxPiloto.setBounds(67, 263, 97, 23);
		contentPane.add(cbxPiloto);

		chckApagador = new JCheckBox("Apagador");
		chckApagador.setBounds(190, 263, 97, 23);
		contentPane.add(chckApagador);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(67, 320, 97, 23);
		contentPane.add(btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sala.equals("sala01")) {
					armazenaSala(sala);
					// metodo para cadastrar na sala 01
				} else if (sala.equals("sala02")) {
					armazenaSala(sala);
					// metodo para cadastrar na sala 02
				} else if (sala.equals("sala03")) {
					armazenaSala(sala);
					// metodo para cadastrar na sala 02
				} else if (sala.equals("sala04")) {
					armazenaSala(sala);
					// metodo para cadastrar na sala 02
				} else if (sala.equals("sala05")) {
					armazenaSala(sala);
					// metodo para cadastrar na sala 02
				} else {
					JOptionPane.showInputDialog(null, "nao ta pegando o numero da sala certo aqui em cadastro");
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(191, 320, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public void armazenaSala(String sala) {
		String piloto, marcador;
		try {
			if (cbxPiloto.isSelected()) {
				piloto = "SIM";
			} else {
				piloto = "NÃO";
			}
			if (chckApagador.isSelected()) {
				marcador = "SIM";
			} else {
				marcador = "NÃO";
			}
			
			// Prepara para escrever no arquivo
			String path = System.getProperty("user.home");
			BufferedWriter gravarArq = new BufferedWriter(new FileWriter(path + "/" + sala + ".txt", true));
			
			// Escreve e fecha arquivo
			gravarArq.write("\r\n" + txtNome.getText() + "," + txtMatricula.getText() + "," + txtHoraEntrada.getText()
					+ "," + txtHoraSaida.getText() + "," + piloto + "," + marcador);
			gravarArq.close();
			
            //exibe a tabela com os dados atualizados
			TabelaSala01 sala01 = new TabelaSala01(sala);
			this.dispose();
			sala01.setVisible(true);

		} catch (IOException erro1) {
			JOptionPane.showMessageDialog(this, "erro1 - deu erro no metodo armazenaSala - classe cadastro");
		} catch (Exception erro2) {
			JOptionPane.showMessageDialog(this,"erro2 - deu erro no metodo armazenaSala - classe cadastro");
		}
	}
}