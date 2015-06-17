package depCalc.listeners;

import depCalc.model.Asset;

public interface IAssetEntryListener {

    public void handleExitButtonClicked();

    public void handleClearButtonClicked();

    public char getDepreciationMethod();

    public void handleCalculateButtonClicked(Asset asset);
}
