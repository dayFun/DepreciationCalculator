package depCalc.view;

import depCalc.model.Asset;

public class AssetValidator {

    private String message;
    private Asset asset;
    private String assetName;
    private String assetCost;
    private String salvageValue;
    private String assetLife;

    public AssetValidator(String assetName, String assetCost, String salvageValue, String assetLife) {
        this.assetName = assetName;
        this.assetCost = assetCost;
        this.salvageValue = salvageValue;
        this.assetLife = assetLife;
        this.message = "";
    }

    /**
     * @return
     */
    /**
     * @return
     */
    /**
     * @return
     */
    public boolean validate() {
        if ("".equals(assetName)) {
            setMessage("Asset name cannot be blank!");
            return false;
        }

        if (!validateInputField(assetCost, "Asset Cost") || !validateInputField(salvageValue, "Salvage Value")) {
            return false;
        }

        try {
            int parsedLifeYears = Integer.parseInt(assetLife);
            if (isUserInputNegative(parsedLifeYears)) {
                return false; 
            }
        } catch (NumberFormatException e) {
            setMessage("Life years left must be a whole number!");
            return false;
        }


        return true;


    }

    private void isUserInputNegative(int parsedLifeYears) {
        if (parsedLifeYears < 0) {
            setMessage("Life years left cannot be a negative number, nukka!");
            return false;
        }
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
                setMessage(inputField + " cannot be a negative number, dummy!");
                return false;
            }
        } catch (NumberFormatException e) {
            setMessage(inputField + " must be a number!");
            return false;
        }

        return true;
    }
}
