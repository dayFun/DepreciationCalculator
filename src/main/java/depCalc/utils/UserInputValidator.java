package depCalc.utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class UserInputValidator extends InputVerifier {

    private static final int BLANK_MESSAGE = 0;
    // private static final int INVALID_NAME_MESSAGE = 1;
    private static final int INVALID_COST_MESSAGE = 2;
    private static final int INVALID_SALVAGE_MESSAGE = 3;
    private static final int INVALID_YEARS_MESSAGE = 4;

    private static final String[] ERROR_MESSAGES = {"This field cannot be left blank",
            "You must enter a valid name for the asset", "You must enter a valid number for the cost of the asset",
            "You must enter a valid number for salvage value of the asset",
            "You must enter a valid integer for the remaining life of the asset"};

    private String message = "";

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        return verify(input);

    }

    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        // return (checkFieldsForEmptyString(textField) || checkFieldsForInvalidNumbers(textField));
        return checkFieldsForInvalidNumbers(textField);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private boolean checkFieldsForEmptyString(JTextField textField) {
        if ("".equals(textField.getText())) {
            setMessage(ERROR_MESSAGES[BLANK_MESSAGE]);
            return false;
        }
        return true;
    }

    private boolean checkFieldsForInvalidNumbers(JTextField textField) {
        boolean areFieldsValid = false;

        if (textField.getName().equals("Cost") && !parseDouble(textField)) {
            setMessage(ERROR_MESSAGES[INVALID_COST_MESSAGE]);
        } else if (textField.getName().equals("Salvage Value") && !parseDouble(textField)) {
            setMessage(ERROR_MESSAGES[INVALID_SALVAGE_MESSAGE]);
        } else if (textField.getName().equals("Life Years") && !parseInt(textField)) {
            setMessage(ERROR_MESSAGES[INVALID_YEARS_MESSAGE]);
        } else {
            areFieldsValid = true;
        }

        return areFieldsValid;
    }

    private boolean parseDouble(JTextField textField) {
        try {
            Double.valueOf(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean parseInt(JTextField textField) {
        try {
            Integer.valueOf(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
