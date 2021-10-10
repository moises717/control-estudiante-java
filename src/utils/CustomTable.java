package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        setHorizontalAlignment(SwingConstants.CENTER);

        switch (table.getValueAt(row, column).toString()) {
            case "REPROBADO":
                setBackground(Color.red);
                setForeground(Color.white);
                break;
            case "APROBADO":
                setBackground(Color.green);
                setForeground(Color.black);
                break;

            default:
                setBackground(Color.white);
                setForeground(Color.black);
                break;
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
