package depCalc.utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

import depCalc.view.DepMetricsPanel;

public class AssetMetricsInputerVerifier extends InputVerifier {
    private JTextField assetCost;
    private JTextField assetSalvageValue;
    private JTextField assetLifeYearsLeft;

    private double doubleValue;
    private int intValue;

    public AssetMetricsInputerVerifier(DepMetricsPanel depMetricsPanel) {
        this.assetCost = depMetricsPanel.getAssetCostTF();
        this.assetSalvageValue = depMetricsPanel.getAssetSalvageValueTF();
        this.assetLifeYearsLeft = depMetricsPanel.getAssetLifeYearsTF();
    }

    public void validateParameters() {
        shouldYieldFocus(assetCost);
        // shouldYieldFocus(assetSalvageValue);
        // shouldYieldFocus(assetLifeYearsLeft);
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        if (verify(input)) {
            // textField.setText(String.valueOf(value));
            return true;
        } else {
            // textField.setText(ZERO);
            // textField.selectAll();
            return false;
        }
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;

        if (textField.getName().equals("JTF Cost")) {
            validateDouble(assetLifeYearsLeft);
        }

        if (textField.getName().equals("JTF Life")) {
            validateInt(assetLifeYearsLeft);
        }

        // if (component.getName().equals("Cost")) {
        // validateInt(assetLifeYearsLeft);
        // }

        return false;
    }

    private boolean validateDouble(JTextField textField) {
        try {
            Double.parseDouble(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateInt(JTextField textField) {
        try {
            Integer.parseInt(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
