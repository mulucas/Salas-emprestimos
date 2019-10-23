package view.tabela;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.Cadastro;

public class TabelaSala extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel = null;
	private JButton btnCadastrarHorario = null;
	private JButton btnApagarHorarios = null;
	private JButton btnDevolverMaterial = null;
	private JScrollPane scrlTabela = null;
	private JTable tblTabela = null;
	private String salaRecebida;
	private String path = System.getProperty("user.home");

	public TabelaSala(String sala) {
		super();
		salaRecebida = sala;
		initialize();
	}

	/**
	 * Este metodo inicia a janela
	 * 
	 * @return o metodo ler do CVS
	 */
	private void initialize() {
		this.setSize(900, 600);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Listagem " + salaRecebida);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lerDoCVS();
	}

	/**
	 * Este metodo inicia o painel
	 * 
	 * @return painel
	 */
	private JPanel getJContentPane() {
		if (painel == null) {
			painel = new JPanel();
			painel.setLayout(new BorderLayout());

			JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnPnl.add(getBtnLerDoCvs());
			if (salaRecebida.equals("Materiais")) {
				btnPnl.add(getBtnDevolverDoCvs());
			}
			btnPnl.add(getBtnApagarDoCvs());

			painel.add(btnPnl, BorderLayout.SOUTH);
			painel.add(getScrlTabela(), BorderLayout.CENTER);
		}
		return painel;
	}

	/**
	 * Este metodo inicia o botao de CADASTRAR na Janela
	 * 
	 * @return JButton
	 */
	private JButton getBtnLerDoCvs() {
		if (btnCadastrarHorario == null) {
			btnCadastrarHorario = new JButton();
			btnCadastrarHorario.setText("Cadastrar");
			btnCadastrarHorario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Cadastro cadastro = new Cadastro(salaRecebida);
					cadastro.setVisible(true);
				}
			});
		}
		return btnCadastrarHorario;
	}

	/**
	 * Este metodo inicia o botao de APAGAR na Janela
	 * @return JButton
	 */
	private JButton getBtnApagarDoCvs() {
		if (btnApagarHorarios == null) {
			btnApagarHorarios = new JButton();
			btnApagarHorarios.setText("Apagar");
			btnApagarHorarios.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esta lista?",
							"Confirmação", JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {
						dispose();
						apagaLista();
					}
				}
			});
		}
		return btnApagarHorarios;
	}
	
	/**
	 * Este metodo inicia o botao de Devolver na Janela somente dos materiais
	 * @return JButton
	 */
	private JButton getBtnDevolverDoCvs() {
		if (btnDevolverMaterial == null) {
			btnDevolverMaterial = new JButton();
			btnDevolverMaterial.setText("Devolver Material");
			btnDevolverMaterial.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente devolver esse material?",
							"Confirmação", JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {
						System.out.println(tblTabela.getModel().getValueAt(tblTabela.getSelectedRow() ,5));
						try {
							alteraLinha(tblTabela.getSelectedRow());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnDevolverMaterial;
	}

	/**
	 * Este metodo ler do arquivo .txt a sala selecionada, ou o material
	 */
	protected void lerDoCVS() {

		try {
			BufferedReader reader = null;
			try {
				if (salaRecebida.equals("sala01")) {
					reader = new BufferedReader(new FileReader(path + "/" + salaRecebida + ".txt"));
				} else if (salaRecebida.equals("sala02")) {
					reader = new BufferedReader(new FileReader(path + "/" + salaRecebida + ".txt"));
				} else if (salaRecebida.equals("sala03")) {
					reader = new BufferedReader(new FileReader(path + "/" + salaRecebida + ".txt"));
				} else if (salaRecebida.equals("sala04")) {
					reader = new BufferedReader(new FileReader(path + "/" + salaRecebida + ".txt"));
				} else if (salaRecebida.equals("sala05")) {
					reader = new BufferedReader(new FileReader(path + "/" + salaRecebida + ".txt"));
				} else if (salaRecebida.equals("Materiais")) {
					reader = new BufferedReader(new FileReader(path + "/" + salaRecebida + ".txt"));
				}

				// Leitura do cabecalho
				String linha = reader.readLine();

				// Criamos nosso model com o cabecalho
				// O split separa as colunas. Ler a primeira linha
				CVSTableModel model = new CVSTableModel(linha.split(","));

				// Leitura das linhas seguintes
				linha = reader.readLine();
				while (linha != null) {
					model.adiciciona(linha); // Cada linha lida entra no model
					linha = reader.readLine();
				}
				// Definimos nosso model na table.
				getTblTabela().setModel(model);
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		} catch (Exception e) {
			BufferedWriter bw;
			String palavrasDasColunas = "";
			if (salaRecebida.equals("Materiais")) {
				palavrasDasColunas = "Nome,Matricula,Data,Piloto,Apagador,Status";
			} else {
				palavrasDasColunas = "Nome,Matricula,Horario de entrada,Horario de Saida,Piloto,Apagador";
			}
			try {
				bw = new BufferedWriter(new FileWriter(path + "/" + salaRecebida + ".txt", true));
				// Escreve e fecha arquivo
				bw.write(palavrasDasColunas);
				bw.close();
				JOptionPane.showMessageDialog(this, "iniciando o arquivo para guardar todos os horarios");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	/*
	 * apaga toda a lista da tabela
	 */
	protected void apagaLista() {
		Writer out;
		try {
			out = new FileWriter(path + "/" + salaRecebida + ".txt");
			// limpa
			out.write("");
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 
	 */
	public void alteraLinha(int numeroDaLinha) throws IOException {
	    String arquivo = path + "/" + salaRecebida + ".txt";
	    
	    BufferedReader reader = new BufferedReader(new FileReader(arquivo));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));

	    String linha;
	    int i = 0;
	    while ((linha = reader.readLine()) != null) {
	        if (i == numeroDaLinha) {
	            linha = linha.replace("emprestrado", "devolvido");
	            break;
	        }
	        i++;
	        bw.write(linha + "\n");
	    }

	    bw.close();        
	    reader.close();

	}

	private JScrollPane getScrlTabela() {
		if (scrlTabela == null) {
			scrlTabela = new JScrollPane();
			scrlTabela.setViewportView(getTblTabela());
		}
		return scrlTabela;
	}

	private JTable getTblTabela() {
		if (tblTabela == null) {
			tblTabela = new JTable();
			if (salaRecebida.equals("Materiais")) {
				tblTabela.setDefaultRenderer(Object.class, new ColorRender(1, 5));
			}
		}
		return tblTabela;
	}
}