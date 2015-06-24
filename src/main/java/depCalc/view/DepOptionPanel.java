package depCalc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import depCalc.DepreciationMethodConstants;
import depCalc.listeners.DepreciationMethodListener;

public class DepOptionPanel extends JPanel {

    private static final long serialVersionUID = 222350806862423649L;

    private JLabel depTypeLabel;
    private ButtonGroup depTypeButtonGroup;
    private JRadioButton straightLineRadioButton;
    private JRadioButton doubleDecliningRadioButton;

    public DepOptionPanel() {
        setLayout(new GridBagLayout());

        depTypeLabel = new JLabel("Depreciation Type:");

        straightLineRadioButton = new JRadioButton("Straight Line");
        straightLineRadioButton.setActionCommand(DepreciationMethodConstants.STRAIGHT_LINE);

        doubleDecliningRadioButton = new JRadioButton("Double Declining");
        doubleDecliningRadioButton.setActionCommand(DepreciationMethodConstants.DOUBLE_DECLINE);

        depTypeButtonGroup = new ButtonGroup();
        depTypeButtonGroup.add(straightLineRadioButton);
        depTypeButtonGroup.add(doubleDecliningRadioButton);

        initLayout();
    }

    public void setListener(DepreciationMethodListener listener) {
        straightLineRadioButton.addActionListener(listener);
        doubleDecliningRadioButton.addActionListener(listener);
    }



    private void initLayout() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridwidth = 2;
        gc.gridheight = 1;

        gc.gridx = 0;
        gc.gridy = 0;

        add(depTypeLabel, gc);

        gc.gridwidth = 1;
        gc.gridheight = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(5, 0, 0, 10);

        add(straightLineRadioButton, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(5, 0, 0, 10);

        add(doubleDecliningRadioButton, gc);
    }
}
