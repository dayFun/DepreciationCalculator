package depCalc.presenter;

import depCalc.listeners.IAssetEntryListener;
import depCalc.model.DepreciationCalculator;
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
    public void handleCalculateButtonClicked(DepreciationCalculator depreciationCalculator) {
        depCalcView.getDepTablePanel().setData(depreciationCalculator);
    }

    @Override
    public char getDepreciationMethod() {
        // TODO Auto-generated method stub
        return 0;
    }



}
