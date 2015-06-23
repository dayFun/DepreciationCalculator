package depCalc.utils;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import depCalc.listeners.IAssetValidatorListener;


public class AssetValidatorTest {

    @Mock
    private IAssetValidatorListener listener;

    private AssetValidator assetValidator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        assetValidator = new AssetValidator();
        assetValidator.setValidationListener(listener);
    }

    @Test
    public void testValidateWithValidAssetNameReturnsTrueWithNoErrorMessage() throws Exception {
        assetValidator.validate("Car", "5000", "1000", "5");

        verify(listener).validationPassed("Car", 5000, 1000, 5);

        assertEquals("", assetValidator.getMessage());
    }

    @Test
    public void testValidateWithEmptyAssetNameReturnsFalseWithCorrectMessage() throws Exception {

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Asset name cannot be blank!", actualMessage);
    }

    @Test
    public void testValidateWithNonNumericCostReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "ABC", "1000", "5");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Asset Cost must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithAssetCostAsEmptyStringReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "", "1000", "5");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Asset Cost must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeAssetCostReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "-1000", "1000", "5");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Asset C" + "ost cannot be a negative number!", actualMessage);
    }

    @Test
    public void testValidateWithEmptyStringAsSalvageValueReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "5000", "", "5");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Salvage Value must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeSalvageValueReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "1000", "-1000", "5");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Salvage Value cannot be a negative number!", actualMessage);
    }

    @Test
    public void testValidateWithEmptyStringAsLifeYearsLeftReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "5000", "10", "");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Life years left must be a whole number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeLifeYearsLeftReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator = new AssetValidator("Pony", "1000", "1000", "-5");

        boolean actualValidationValue = assetValidator.validate();
        String actualMessage = assetValidator.getMessage();

        assertFalse(actualValidationValue);
        assertEquals("Life years left cannot be a negative number!", actualMessage);
    }


}
