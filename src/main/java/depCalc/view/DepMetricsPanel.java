package depCalc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import depCalc.model.Asset;

public class DepMetricsPanel extends JPanel {

    private static final long serialVersionUID = -4104415642801279530L;

    private JLabel assetNameLabel;
    private JLabel costLabel;
    private JLabel salvageValueLabel;
    private JLabel lifeYearsLabel;
    private JTextField assetNameTF;
    private JTextField assetCostTF;
    private JTextField assetSalvageValueTF;
    private JTextField assetLifeYearsLeftTF;
    private JButton clearButton;

    public DepMetricsPanel() {
        assetNameLabel = new JLabel("Asset Name:");
        costLabel = new JLabel("Cost:");
        salvageValueLabel = new JLabel("Salvage Value:");
        lifeYearsLabel = new JLabel("Life (years):");

        assetNameTF = new JTextField(10);

        assetCostTF = new JTextField(10);
        assetCostTF.setName("JTF Cost");

        assetSalvageValueTF = new JTextField(10);
        assetSalvageValueTF.setName("JTF Salvage");

        assetLifeYearsLeftTF = new JTextField(10);
        assetLifeYearsLeftTF.setName("JTF Life");

        clearButton = new JButton("Clear");

        initLayout();
    }

    public Asset createAsset() {
        Asset asset = new Asset();
        asset.setName(assetNameTF.getText());
        asset.setCost(Double.valueOf(assetCostTF.getText()));
        asset.setSalvageValue((Double.valueOf(assetSalvageValueTF.getText())));
        asset.setLifeYearsLeft(Integer.valueOf(assetLifeYearsLeftTF.getText()));
        return asset;
    }

    public JTextField getAssetNameTF() {
        return assetNameTF;
    }

    public JTextField getAssetCostTF() {
        return assetCostTF;
    }

    public JTextField getAssetSalvageValueTF() {
        return assetSalvageValueTF;
    }

    public JTextField getAssetLifeYearsTF() {
        return assetLifeYearsLeftTF;
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

        add(assetNameTF, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(assetCostTF, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(assetSalvageValueTF, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        gc.insets = new Insets(0, 20, 0, 20);

        add(assetLifeYearsLeftTF, gc);
    }
}
