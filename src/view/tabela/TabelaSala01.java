package view.tabela;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.Cadastro;

public class TabelaSala01 extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel painel = null;
    private JButton btnCadastrarHorario = null;
    private JScrollPane scrlTabela = null;
    private JTable tblTabela = null;
    String salaRecebida;
  
    public TabelaSala01(String sala) {
    	super();
    	salaRecebida = sala;
        initialize();
    }
    /**
     * Este metodo inicia a janela
     * @return void
     */
    private void initialize() {
        this.setSize(900, 600);
        this.setResizable(false);
        this.setContentPane(getJContentPane());
        this.setTitle("Listagem "+salaRecebida);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lerDoCVS();
    }
    /**
     * Este metodo inicia o painel
     * @return painel
     */
    private JPanel getJContentPane() {
        if (painel == null) {
            painel = new JPanel();
            painel.setLayout(new BorderLayout());
            painel.add(getBtnLerDoCvs(), BorderLayout.SOUTH);
            painel.add(getScrlTabela(), BorderLayout.CENTER);
        }
        return painel;
    }

    /**
     * Este metodo inicia o botao
     * @return JButton
     */
    private JButton getBtnLerDoCvs() {
        if (btnCadastrarHorario == null) {
            btnCadastrarHorario = new JButton();
            btnCadastrarHorario.setText("Cadastrar Horario");
            btnCadastrarHorario.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    dispose();
                	Cadastro cadastro =new Cadastro(salaRecebida);
                    cadastro.setVisible(true);
                }
            });
        }
        return btnCadastrarHorario;
    }

    /**
     * Este metodo ler do arquivo selecionado
     */
    protected void lerDoCVS() {
        try {
            BufferedReader reader = null;
            try {
            	if (salaRecebida.equals("sala01")) {
            		reader = new BufferedReader(new FileReader(salaRecebida+".txt"));					
				}
            	else if(salaRecebida.equals("sala02")) {
            		reader = new BufferedReader(new FileReader(salaRecebida+".txt"));
            	}
            	else if(salaRecebida.equals("sala03")) {
            		reader = new BufferedReader(new FileReader(salaRecebida+".txt"));
            	}
            	else if(salaRecebida.equals("sala04")) {
            		reader = new BufferedReader(new FileReader(salaRecebida+".txt"));
            	}
            	else if(salaRecebida.equals("sala05")) {
            		reader = new BufferedReader(new FileReader(salaRecebida+".txt"));
            	}

                //Leitura do cabecalho
                String linha = reader.readLine();
                if (linha == null) {
                	BufferedWriter writer = new BufferedWriter(new FileWriter(salaRecebida+".txt"));
                	writer.write("Nome,Matricula,Horario de entrada,Horario de Saida,piloto,marcador");
                }

                //Criamos nosso model com o cabecalho
                //O split separa as colunas. Ler a primeira linha 
                CVSTableModel model = new CVSTableModel(linha.split(","));

                //Leitura das linhas seguintes
                linha = reader.readLine();
                while (linha != null) {
                    model.adiciciona(linha); // Cada linha lida entra no model
                    linha = reader.readLine();
                }
                //Definimos nosso model na table.
                getTblTabela().setModel(model);
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
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
        }
        return tblTabela;
    }

//    public static void main(String[] args) {
//        new TabelaSala01().setVisible(true);
//    }
}
