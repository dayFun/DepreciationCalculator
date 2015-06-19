package depCalc.utils;

import depCalc.listeners.IAssetValidatorListener;

public class AssetValidator {

    private String assetName;
    private String assetCost;
    private String salvageValue;
    private String lifeYearsLeft;
    private String message;
    private IAssetValidatorListener listener;

    public AssetValidator(String assetName, String assetCost, String salvageValue, String lifeYearsLeft) {
        this.assetName = assetName;
        this.assetCost = assetCost;
        this.salvageValue = salvageValue;
        this.lifeYearsLeft = lifeYearsLeft;
    }

    public void setValidationListener(IAssetValidatorListener listener) {
        this.listener = listener;
    }

    public boolean validate() {
        if ("".equals(assetName)) {
            setMessage("Asset name cannot be blank!");
            return false;
        }

        if (!validateInputField(assetCost, "Asset Cost") || !validateInputField(salvageValue, "Salvage Value")) {
            return false;
        }

        //TODO: Finish cleaning up/refactoring
        try {
            int parsedLifeYears = Integer.parseInt(lifeYearsLeft);
            if (parsedLifeYears < 0) {
                setMessage("Life years left cannot be a negative number!");
                return false;
            }
        } catch (NumberFormatException e) {
            setMessage("Life years left must be a whole number!");
            return false;
        }
        return true;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetCost() {
        return assetCost;
    }

    public String getSalvageValue() {
        return salvageValue;
    }

    public String getLifeYearsLeft() {
        return lifeYearsLeft;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private boolean validateInputField(String actualUserInput, String inputField) {
        try {
            double parsedUserInput = Double.parseDouble(actualUserInput);
            if (parsedUserInput < 0) {
                setMessage(inputField + " cannot be a negative number!");
                return false;
            }
        } catch (NumberFormatException e) {
            setMessage(inputField + " must be a number!");
            return false;
        }

        return true;
    }
}
