package depCalc.presenter;

import depCalc.listeners.IAssetEntryListener;
import depCalc.model.Asset;
import depCalc.view.DepCalcView;

public class Presenter implements IAssetEntryListener {

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
    public void handleCalculateButtonClicked(Asset asset) {

    }



}
