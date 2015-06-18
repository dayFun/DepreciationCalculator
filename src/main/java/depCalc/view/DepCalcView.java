package depCalc.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import depCalc.listeners.IAssetEntryListener;
import depCalc.utils.AssetValidator;


public class DepCalcView extends JFrame {

    private static final long serialVersionUID = 1L;
    private MainMenuBar menuBar;
    private DepMetricsPanel depMetricsPanel;
    private DepOptionPanel depOptionPanel;
    private DepScheduleTablePanel depTablePanel;
    private JButton calculateButton;

    public DepCalcView() {
        menuBar = new MainMenuBar();
        setJMenuBar(menuBar);

        depMetricsPanel = new DepMetricsPanel();
        depOptionPanel = new DepOptionPanel();
        depTablePanel = new DepScheduleTablePanel();
        depTablePanel.setPreferredSize(new Dimension(300, 300));
        calculateButton = new JButton("Calculate");

        initLayout();
        setWindowOptions();
    }

    public void attachListeners(final IAssetEntryListener viewListener) {
        menuBar.getExitMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handleExitButtonClicked();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String assetName = depMetricsPanel.getAssetNameTF().getText();
                String assetCost = depMetricsPanel.getAssetCostTF().getText();
                String salvageValue = depMetricsPanel.getAssetSalvageValueTF().getText();
                String lifeYearsLeft = depMetricsPanel.getAssetLifeYearsTF().getText();

                AssetValidator validator = new AssetValidator(assetName, assetCost, salvageValue, lifeYearsLeft);

                if (validator.validate()) {
                    //                    Asset newAsset = depMetricsPanel.createAsset();
                    //                    viewListener.handleCalculateButtonClicked(newAsset);
                } else {

                }
            }
        });

        depMetricsPanel.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depMetricsPanel.clearTextFields();
            }
        });
    }

    public DepMetricsPanel getDepMetricsPanel() {
        return depMetricsPanel;
    }

    public DepOptionPanel getDepOptionPanel() {
        return depOptionPanel;
    }

    public DepScheduleTablePanel getDepTablePanel() {
        return depTablePanel;
    }

    private void initLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        setWeights(gc, 0, 0);

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(25, 0, 25, 0);

        add(depMetricsPanel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(depOptionPanel, gc);

        setWeights(gc, 0, 1);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(calculateButton, gc);

        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 3;
        add(depTablePanel, gc);
    }

    private void setWeights(GridBagConstraints gc, int x, int y) {
        gc.weightx = x;
        gc.weighty = y;
    }

    private void setWindowOptions() {
        setTitle("Depreciation Calculator");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
