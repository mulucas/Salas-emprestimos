package view.tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CVSTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<String> linhas = new ArrayList<String>();
	private String[] columnNames;

	public CVSTableModel(String... columnNames) {
		this.columnNames = columnNames;
	}
	/*
	 * adiciona cada linha dentro da tabela
	 */
	public void adiciciona(String linha) {
		linhas.add(linha);
		fireTableRowsInserted(linhas.size() - 1, linhas.size() - 1);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return linhas.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// Usamos novamente o split para separar as colunas da linha desejada
		String[] colunas = linhas.get(rowIndex).split(",");

		// Retornamos a coluna desejada
		return colunas[columnIndex];
	}
	//PEGA O NOME DA COLUNA E JOGA NA TABELA
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
