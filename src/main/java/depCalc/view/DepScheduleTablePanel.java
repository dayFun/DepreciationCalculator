package depCalc.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import depCalc.model.DepreciationCalculator;

public class DepScheduleTablePanel extends JPanel {

    private static final long serialVersionUID = -8681869005309787613L;
    private JTable table;
    private DepScheduleTableModel tableModel;

    public DepScheduleTablePanel() {
        tableModel = new DepScheduleTableModel();
        table = new JTable(tableModel);

        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new BorderLayout());

        add(new JScrollPane(table));
    }

    public void setData(DepreciationCalculator depreciationCalculator) {
        tableModel.setData(depreciationCalculator);
        tableModel.fireTableDataChanged();
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public void clear() {
        tableModel.clear();
        refresh();
    }
}
