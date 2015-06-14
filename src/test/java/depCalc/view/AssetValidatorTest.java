package depCalc.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AssetValidatorTest {

    private AssetValidator assetValidator;

    @Test
    public void testValidateWithValidAssetNameReturnsTrueWithNoErrorMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Car", "5000", "1000", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();

        //Assert
        assertTrue(actualValidationValue);
        assertEquals("", assetValidator.getMessage());
    }

    @Test
    public void testValidateWithEmptyAssetNameReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("", "5000", "1000", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Asset name cannot be blank!", actualMessage);
    }

    @Test
    public void testValidateWithNonNumericCostReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "ABC", "1000", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Asset Cost must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithAssetCostAsEmptyStringReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "", "1000", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Asset Cost must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeAssetCostReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "-1000", "1000", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Asset C" + "ost cannot be a negative number, dummy!", actualMessage);
    }

    @Test
    public void testValidateWithEmptyStringAsSalvageValueReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "5000", "", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Salvage Value must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeSalvageValueReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "1000", "-1000", "5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Salvage Value cannot be a negative number, dummy!", actualMessage);
    }

    @Test
    public void testValidateWithEmptyStringAsLifeYearsLeftReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "5000", "10", "");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Life years left must be a whole number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeLifeYearsLeftReturnsFalseWithCorrectMessage() throws Exception {
        //Arrange 
        assetValidator = new AssetValidator("Pony", "1000", "1000", "-5");

        //Act
        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        //Assert
        assertFalse(actualValidationValue);
        assertEquals("Life years left cannot be a negative number, nukka!", actualMessage);
    }


}
