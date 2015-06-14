package depCalc.view;

import depCalc.model.Asset;

public class AssetValidator {

    private String message;
    private Asset asset;
    private String assetName;
    private String assetCost;
    private String salvageValue;
    private String assetLife;

    //
    // throw new IllegalArgumentException("Salvage value cannot be less than zero.");
    // throw new IllegalArgumentException("Life years left cannot be less than zero.");
    // throw new IllegalArgumentException("Cost cannot be less than zero.");
    //
    //
    public AssetValidator(String assetName, String assetCost, String salvageValue, String assetLife) {
        this.assetName = assetName;
        this.assetCost = assetCost;
        this.salvageValue = salvageValue;
        this.assetLife = assetLife;

        this.message = "";
    }

    public boolean validate() {
        if ("".equals(asset.getName())) {
            setMessage("Asset name cannot be blank");
            return false;
        }
        if (asset.getCost() < 0) {
            setMessage("Asset cost cannot be less than zero");
            return false;
        }
        return true;
    }


    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

}
