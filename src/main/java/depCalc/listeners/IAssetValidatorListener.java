package depCalc.listeners;

import depCalc.model.Asset;

public interface IAssetValidatorListener {

    public Asset validationPassed(String assetName, double assetCost, double salvageValue, int lifeYearsLeft);

    public String validationFailed();

}
