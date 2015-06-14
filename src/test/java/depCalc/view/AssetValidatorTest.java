package depCalc.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AssetValidatorTest {

    private AssetValidator assetValidator;

    @Test
    public void testValidateWithNoAssetNameReturnsFalseWithCorrectErrorMessage() throws Exception {
        assetValidator = new AssetValidator("", "", "", "");

        String expectedMessage = "Asset name cannot be blank";

        assertFalse(assetValidator.validate());
        assertEquals(expectedMessage, assetValidator.getMessage());
    }

    @Test
    public void testValidateWithValidAssetNameReturnsTrueWithNoErrorMessage() throws Exception {
        assetValidator = new AssetValidator("Car", "", "", "");

        boolean actualValidationValue = assetValidator.validate();
        assertTrue(actualValidationValue);
        assertEquals("", assetValidator.getMessage());
    }

    @Test
    public void testValidateWithNonNumericCostReturnsFalseWithCorrectErrorMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "ABC", "", "");

        String expectedMessage = "Asset cost cannot be less than zero";
        boolean actualValidationValue = assetValidator.validate();

        assertFalse(actualValidationValue);
        assertEquals(expectedMessage, assetValidator.getMessage());
    }

    @Test
    public void testValidateWithNegativeCostReturnsFalseWithCorrectErrorMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "-5000", "", "");

        String expectedMessage = "Asset cost cannot be less than zero";

        boolean actualValidationValue = assetValidator.validate();

        assertFalse(actualValidationValue);
        assertEquals(expectedMessage, assetValidator.getMessage());
    }
    //    @Test
    //    public void testValidateWithNegativeValuesReturnsFalse() throws Exception {
    //        Asset asset = new Asset("My Asset", -500.0, -100.0, -5);
    //        assetValidator.validate(asset);
    //    }

}
