package depCalc;

import java.awt.EventQueue;

import depCalc.presenter.Presenter;
import depCalc.view.DepCalcView;

public class Application {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DepCalcView depCalcView = new DepCalcView();
                Presenter presenter = new Presenter(depCalcView);

                depCalcView.attachViewListeners(presenter);
                depCalcView.setVisible(true);
            }
        });
    }
}
