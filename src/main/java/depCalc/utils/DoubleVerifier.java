package depCalc.utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class DoubleVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        try {
            Integer.valueOf(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
