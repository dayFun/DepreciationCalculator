package depCalc.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import depCalc.listeners.IAssetEntryListener;
import depCalc.listeners.IAssetValidatorListener;
import depCalc.model.Asset;
import depCalc.utils.AssetValidator;


public class DepCalcView extends JFrame {

    private static final long serialVersionUID = 1L;
    private MainMenuBar menuBar;
    private DepMetricsPanel depMetricsPanel;
    private DepOptionPanel depOptionPanel;
    private DepScheduleTablePanel depTablePanel;
    private JButton calculateButton;
    private JLabel errorMessageLabel;
    private AssetValidator validator;

    public DepCalcView() {
        menuBar = new MainMenuBar();
        setJMenuBar(menuBar);

        errorMessageLabel = new JLabel();
        depMetricsPanel = new DepMetricsPanel();
        depOptionPanel = new DepOptionPanel();
        depTablePanel = new DepScheduleTablePanel();
        depTablePanel.setPreferredSize(new Dimension(300, 300));
        calculateButton = new JButton("Calculate");

        validator = new AssetValidator();

        initLayout();
        setWindowOptions();
    }


    public void attachViewListeners(final IAssetEntryListener viewListener) {
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

                validator.setValidationListener(new IAssetValidatorListener() {

                    @Override
                    public void validationPassed(String assetName, double assetCost, double salvageValue, int lifeYearsLeft) {
                        viewListener.handleCalculateButtonClicked(new Asset(assetName, assetCost, salvageValue, lifeYearsLeft));
                    }

                    @Override
                    public void validationFailed(String errorMessage) {
                        errorMessageLabel.setText(errorMessage + "\n");
                    }
                });

                validator.validate(assetName, assetCost, salvageValue, lifeYearsLeft);
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

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(25, 0, 75, 0);
        add(errorMessageLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(25, 0, 25, 0);

        add(depMetricsPanel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(depOptionPanel, gc);

        setWeights(gc, 0, 0.1);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(calculateButton, gc);

        setWeights(gc, 0, 1);

        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 3;
        add(depTablePanel, gc);
    }

    private void setWeights(GridBagConstraints gc, double x, double y) {
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
