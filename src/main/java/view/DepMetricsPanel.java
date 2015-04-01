package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0;
        gc.weighty = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(75, 50, 5, 20);
        gc.anchor = GridBagConstraints.PAGE_START;

        add(assetNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(75, 20, 5, 20);

        add(costLabel, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(75, 20, 5, 20);

        add(salvageValueLabel, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        gc.insets = new Insets(75, 20, 5, 20);

        add(lifeYearsLabel, gc);

        gc.gridheight = 2;
        gc.gridx = 4;
        gc.gridy = 0;
        gc.insets = new Insets(90, 0, 0, 0);

        add(clearButton, gc);

        gc.weightx = 0;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 50, 0, 20);

        add(assetField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(costField, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(salvageValueField, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(lifeYearsField, gc);
    }
}
