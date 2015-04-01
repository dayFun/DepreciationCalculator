package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DepOptionPanel extends JPanel {

    private static final long serialVersionUID = 222350806862423649L;

    private JLabel depTypeLabel;
    private JRadioButton straightLineRButton;
    private JRadioButton doubleDecliningRButton;

    public DepOptionPanel() {
        setLayout(new GridBagLayout());
        // setMaximumSize(new Dimension(100, 100));
        setSize(100, 100);

        depTypeLabel = new JLabel("Depreciation Type:");

        straightLineRButton = new JRadioButton("Straight Line");
        doubleDecliningRButton = new JRadioButton("Double Declining");

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.CENTER;
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

        add(straightLineRButton, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(5, 0, 0, 10);

        add(doubleDecliningRButton, gc);
    }
}
