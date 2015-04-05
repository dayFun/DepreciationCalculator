package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.DepScheduleTableModel;

public class DepScheduleTablePanel extends JPanel {

    private static final long serialVersionUID = -8681869005309787613L;
    private JTable table;
    private DepScheduleTableModel depTableModel;

    public DepScheduleTablePanel() {
        depTableModel = new DepScheduleTableModel();
        table = new JTable(depTableModel);

        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new BorderLayout());

        add(new JScrollPane(table));
    }
}
