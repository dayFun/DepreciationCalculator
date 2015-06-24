package depCalc.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import depCalc.DepreciationMethodConstants;

public class DepreciationMethodListener implements ActionListener {

    private String selectedDepreciationMethod;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(DepreciationMethodConstants.STRAIGHT_LINE)) {
            setDepreciationMethod(DepreciationMethodConstants.STRAIGHT_LINE);
        }

        if (e.getActionCommand().equals(DepreciationMethodConstants.DOUBLE_DECLINE)) {
            setDepreciationMethod(DepreciationMethodConstants.DOUBLE_DECLINE);
        }

    }

    public String getDepreciationMethod() {
        return selectedDepreciationMethod;
    }

    private void setDepreciationMethod(String selectedDepreciationMethod) {
        this.selectedDepreciationMethod = selectedDepreciationMethod;
    }
}
