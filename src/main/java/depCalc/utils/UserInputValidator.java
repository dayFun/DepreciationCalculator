package depCalc.utils;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class UserInputValidator extends AbstractValidator {

    private static final int BLANK_MESSAGE = 0;
    // private static final int INVALID_NAME_MESSAGE = 1;
    private static final int INVALID_COST_MESSAGE = 2;
    private static final int INVALID_SALVAGE_MESSAGE = 3;
    private static final int INVALID_YEARS_MESSAGE = 4;

    private static final String[] ERROR_MESSAGES = {"This field cannot be left blank",
            "You must enter a valid name for the asset", "You must enter a valid number for the cost of the asset",
            "You must enter a valid number for salvage value of the asset",
            "You must enter a valid integer for the remaining life of the asset"};

    private String message;

    public UserInputValidator(JDialog parent, JComponent c, String message) {
        super(parent, c, message);
        this.message = message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    protected boolean validationCriteria(JComponent c) {
        JTextField textField = (JTextField) c;
        return (checkFieldsForEmptyString(textField) && checkFieldsForInvalidNumbers(textField));
    }

    private boolean checkFieldsForInvalidNumbers(JTextField textField) {
        boolean areFieldsValid = false;

        if (!textField.getName().equals("Cost") && !parseDouble(textField)) {
            setMessage(ERROR_MESSAGES[INVALID_COST_MESSAGE]);
        } else if (!textField.getName().equals("Salvage Value") && !parseDouble(textField)) {
            setMessage(ERROR_MESSAGES[INVALID_SALVAGE_MESSAGE]);
        } else if (!textField.getName().equals("Life Years") && !parseInt(textField)) {
            setMessage(ERROR_MESSAGES[INVALID_YEARS_MESSAGE]);
        } else {
            areFieldsValid = true;
        }

        return areFieldsValid;
    }

    private boolean checkFieldsForEmptyString(JTextField textField) {
        if ("".equals(textField.getText())) {
            setMessage(ERROR_MESSAGES[BLANK_MESSAGE]);
            return false;
        }
        return true;
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
