package depCalc;

import depCalc.listeners.IAssetValidatorListener;

public class AssetValidator {

    private String message;
    private IAssetValidatorListener listener;

    public AssetValidator() {
        message = "";
    }


    public void setValidationListener(IAssetValidatorListener listener) {
        this.listener = listener;
    }

    public void validate(String assetName, String assetCost, String salvageValue, String lifeYearsLeft) {
        assetName = checkEmptyName(assetName);
        Double assetCostDouble = validateInputField(assetCost, "Asset Cost");
        Double salvageValueDouble = validateInputField(salvageValue, "Salvage Value");
        Double lifeYearsLeftDouble = validateInputField(lifeYearsLeft, "Life years");

        if (assetName != null && assetCostDouble != null && salvageValueDouble != null && lifeYearsLeftDouble != null) {
            listener.validationPassed(assetName, assetCostDouble, salvageValueDouble, lifeYearsLeftDouble.intValue());
        } else {
            listener.validationFailed(message);
        }

        setMessage("");

    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message += message;
    }

    private String checkEmptyName(String assetName) {
        if ("".equals(assetName)) {
            assetName = null;
            setMessage("Asset name cannot be blank! \n");
        }
        return assetName;
    }

    private Double validateInputField(String actualUserInput, String inputField) {
        Double parsedUserInput;
        try {
            parsedUserInput = Double.parseDouble(actualUserInput);
            if (parsedUserInput < 0) {
                setMessage(inputField + " cannot be a negative number! \n");
                parsedUserInput = null;
            }
        } catch (NumberFormatException e) {
            parsedUserInput = null;
            setMessage(inputField + " must be a whole number! \n");
        }

        return parsedUserInput;
    }
}
