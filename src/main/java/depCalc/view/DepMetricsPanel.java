package depCalc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import depCalc.model.Asset;
import depCalc.utils.UserInputValidator;

public class DepMetricsPanel extends JPanel {

    private static final long serialVersionUID = -4104415642801279530L;

    private JLabel assetNameLabel;
    private JLabel costLabel;
    private JLabel salvageValueLabel;
    private JLabel lifeYearsLabel;
    private JTextField assetName;
    private JTextField assetCost;
    private JTextField assetSalvageValue;
    private JTextField assetLifeYearsLeft;
    private JButton clearButton;
    private UserInputValidator inputVerifier;
    private JDialog errorDialog;

    public DepMetricsPanel() {
        assetNameLabel = new JLabel("Asset Name:");
        costLabel = new JLabel("Cost:");
        salvageValueLabel = new JLabel("Salvage Value:");
        lifeYearsLabel = new JLabel("Life (years):");

        assetName = new JTextField(10);
        assetName.setName("Asset Name");
        assetName.setInputVerifier(inputVerifier);

        assetCost = new JTextField(10);
        assetCost.setName("Cost");
        assetCost.setInputVerifier(inputVerifier);

        assetSalvageValue = new JTextField(10);
        assetSalvageValue.setName("Salvage Value");
        // assetSalvageValue.setInputVerifier(inputVerifier);

        assetLifeYearsLeft = new JTextField(10);
        assetLifeYearsLeft.setName("Life Years");
        assetLifeYearsLeft.setInputVerifier(inputVerifier);

        clearButton = new JButton("Clear");

        errorDialog = new JDialog();
        inputVerifier = new UserInputValidator(errorDialog, assetCost, "");

        initLayout();
    }

    public Asset createAssetFromTextFields() {
        Asset asset = new Asset();
        asset.setName(assetName.getText());
        asset.setCost(Double.valueOf(assetCost.getText()));
        asset.setSalvageValue((Double.valueOf(assetSalvageValue.getText())));
        asset.setLifeYearsLeft(Integer.valueOf(assetLifeYearsLeft.getText()));

        return asset;
    }

    public JTextField getAssetName() {
        return assetName;
    }

    public JTextField getAssetCost() {
        return assetCost;
    }

    public JTextField getAssetSalvageValue() {
        return assetSalvageValue;
    }

    public JTextField getAssetLifeYears() {
        return assetLifeYearsLeft;
    }

    public JButton getClearButton() {
        return clearButton;
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
        gc.insets = new Insets(50, 50, 5, 20);
        gc.anchor = GridBagConstraints.PAGE_START;

        add(assetNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(50, 20, 5, 20);

        add(costLabel, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(50, 20, 5, 20);

        add(salvageValueLabel, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        gc.insets = new Insets(50, 20, 5, 20);

        add(lifeYearsLabel, gc);

        gc.gridheight = 2;
        gc.gridx = 4;
        gc.gridy = 0;
        gc.insets = new Insets(65, 0, 0, 0);

        add(clearButton, gc);

        gc.weightx = 0;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 50, 0, 20);

        add(assetName, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(assetCost, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(assetSalvageValue, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(assetLifeYearsLeft, gc);
    }
}
