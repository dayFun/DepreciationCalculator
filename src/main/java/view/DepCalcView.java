package view;

import javax.swing.JFrame;


public class DepCalcView extends JFrame {

    private static final long serialVersionUID = 1L;

    private DepMetricsPanel depMetricsPanel;

    public DepCalcView() {

        depMetricsPanel = new DepMetricsPanel();
        add(depMetricsPanel);

        setWindowOptions();
    }

    private void setWindowOptions() {
        setTitle("Depreciation Calculator");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
