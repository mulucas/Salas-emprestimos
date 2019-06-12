package view.tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CVSTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<String> lines = new ArrayList<String>();
	private String[] columnNames;

	public CVSTableModel(String... columnNames) {
		this.columnNames = columnNames;
	}
	/*
	 * adiciona cada linha dentro da tabela
	 */
	public void adiciciona(String line) {
		lines.add(line);
		fireTableRowsInserted(lines.size() - 1, lines.size() - 1);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return lines.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// Usamos novamente o split para separar as colunas da linha desejada
		String[] colunas = lines.get(rowIndex).split(",");

		// Retornamos a coluna desejada
		return colunas[columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
