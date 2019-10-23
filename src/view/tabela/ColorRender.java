package view.tabela;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorRender extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	private final int codTabela;
	private final int columnAlter;

	public ColorRender(int codTabela, int columnAlter) {
		this.codTabela = codTabela;
		this.columnAlter = columnAlter;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (isSelected) {
			// define cor e fonte caso a linha esteja selecionada
			setBackground(table.getSelectionBackground());
			setForeground(Color.BLACK);
		} else {// caso nao esteja selecionado...
			setForeground(Color.BLACK); // Volta para cor fonte default
			// define cor zebrada da tabela
			if (row % 2 == 0) { // pinta a linha de branco quando a linha for par
				setBackground(Color.WHITE);
			} else { // pinta a linha de cinza quando for impar
				setBackground(new Color(235, 235, 235));
			}

			try {
				if (codTabela == 1) { // Regra da Tabela 1 ambas pintam colunas
					// pega o status da ultima coluna
					String a = (String) table.getValueAt(row, columnAlter);
					// se estiver emprestado, pinta de vermelho
					if (a.equals("emprestado")) {
						setForeground(new Color(150, 0, 0));
					}
					// se estiver devolvido, pinta de verde
					if (a.equals("devolvido")) {
						setForeground(new Color(0, 150, 0));
					}
				}
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "erro nullPointerException ColorRender");
			}
		}
		return this;
	}
}
