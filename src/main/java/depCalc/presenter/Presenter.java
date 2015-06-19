package depCalc.presenter;

import depCalc.listeners.IAssetEntryListener;
import depCalc.listeners.IAssetValidatorListener;
import depCalc.model.Asset;
import depCalc.utils.AssetValidator;
import depCalc.view.DepCalcView;

public class Presenter implements IAssetEntryListener, IAssetValidatorListener {

    private DepCalcView depCalcView;

    public Presenter(DepCalcView depCalcView) {
        this.depCalcView = depCalcView;
    }

    @Override
    public void handleExitButtonClicked() {
        System.exit(0);
    }

    @Override
    public void handleClearButtonClicked() {

    }

    @Override
    public void handleCalculateButtonClicked(AssetValidator validator) {
        if (validator.validate()) {
            validationPassed(assetName, assetCost, salvageValue, lifeYearsLeft);
        }
        depCalcView.getDepTablePanel().setData(depreciationCalculator);
    }

    @Override
    public char getDepreciationMethod() {
        return 0;
    }

    @Override
    public Asset validationPassed(String assetName, double assetCost, double salvageValue, int lifeYearsLeft) {
        return null;
    }

    @Override
    public String validationFailed() {
        return null;
    }



}
