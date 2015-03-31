package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepMetricsPanel extends JPanel {

    private static final long serialVersionUID = -4104415642801279530L;

    private JLabel assetNameLabel;
    private JLabel costLabel;
    private JLabel salvageValueLabel;
    private JLabel lifeYearsLabel;
    private JTextField assetField;
    private JTextField costField;
    private JTextField salvageValueField;
    private JTextField lifeYearsField;
    private JButton clearButton;

    public DepMetricsPanel() {
        assetNameLabel = new JLabel("Asset Name:");
        costLabel = new JLabel("Cost:");
        salvageValueLabel = new JLabel("Salvage Value:");
        lifeYearsLabel = new JLabel("Life (years):");

        assetField = new JTextField(10);
        costField = new JTextField(10);
        salvageValueField = new JTextField(10);
        lifeYearsField = new JTextField(10);

        clearButton = new JButton("Clear");

        initLayout();
    }

    private void initLayout() {
        JPanel labelsPanel = layoutLabels();
        JPanel textFieldsPanel = layoutTextFields();

        add(labelsPanel);
        add(textFieldsPanel);

    }

    private JPanel layoutLabels() {
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        labelsPanel.add(assetNameLabel);
        labelsPanel.add(costLabel);
        labelsPanel.add(salvageValueLabel);
        labelsPanel.add(lifeYearsLabel);

        return labelsPanel;
    }

    private JPanel layoutTextFields() {
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        fieldsPanel.add(assetField);
        fieldsPanel.add(costField);
        fieldsPanel.add(salvageValueField);
        fieldsPanel.add(lifeYearsField);
        fieldsPanel.add(clearButton);

        return fieldsPanel;
    }
}
