package teste;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LineSelectionTableCellRenderer extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (isSelected) {
			result.setFont(new Font("arial", Font.BOLD, 12));
			result.setForeground(Color.white);
			result.setBackground(Color.blue);
		} else {
			result.setFont(new Font("arial", Font.PLAIN, 12));
			result.setForeground(Color.black);
			result.setBackground(Color.white);
		}
		return result;
	}
}
