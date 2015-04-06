package depCalc.listeners;

import depCalc.model.Asset;

public interface IAssetEntryListener {

    public void handleExitButtonClicked();

    public void handleClearButtonClicked();

    public void handleCalculateButtonClicked(Asset asset);

}
