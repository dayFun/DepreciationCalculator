package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;


public class DepCalcView extends JFrame {

    private static final long serialVersionUID = 1L;

    private DepMetricsPanel depMetricsPanel;
    private DepOptionPanel depOptionPanel;

    public DepCalcView() {
        depMetricsPanel = new DepMetricsPanel();
        depOptionPanel = new DepOptionPanel();


        initLayout();
        setWindowOptions();
    }

    private void initLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(25, 0, 25, 0);

        add(depMetricsPanel, gc);


        gc.weightx = 2;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        add(depOptionPanel, gc);
    }

    private void setWindowOptions() {
        setTitle("Depreciation Calculator");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
