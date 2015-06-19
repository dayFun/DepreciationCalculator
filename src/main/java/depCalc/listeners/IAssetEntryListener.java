package depCalc.listeners;

import depCalc.utils.AssetValidator;

public interface IAssetEntryListener {

    public void handleExitButtonClicked();

    public void handleClearButtonClicked();

    public char getDepreciationMethod();

    public void handleCalculateButtonClicked(AssetValidator validator);
}
