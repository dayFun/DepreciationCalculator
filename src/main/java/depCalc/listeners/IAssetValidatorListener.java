package depCalc.listeners;


public interface IAssetValidatorListener {

    public void validationPassed(String assetName, double assetCost, double salvageValue, int lifeYearsLeft);

    public void validationFailed(String message);

}
