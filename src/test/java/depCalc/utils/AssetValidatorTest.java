package depCalc.utils;


import static org.junit.Assert.assertEquals;
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
        assetValidator.validate("", "5000", "1000", "5");

        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Asset name cannot be blank!", actualMessage);
    }

    @Test
    public void testValidateWithNonNumericCostReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "ABC", "1000", "5");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Asset Cost must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithAssetCostAsEmptyStringReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "", "1000", "5");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Asset Cost must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeAssetCostReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "-5000", "1000", "5");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Asset Cost cannot be a negative number!", actualMessage);
    }

    @Test
    public void testValidateWithEmptyStringAsSalvageValueReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "5000", "", "5");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Salvage Value must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeSalvageValueReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "5000", "-1", "5");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Salvage Value cannot be a negative number!", actualMessage);
    }

    @Test
    public void testValidateWithEmptyStringAsLifeYearsLeftReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "5000", "1000", "");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Life years must be a number!", actualMessage);
    }

    @Test
    public void testValidateWithNegativeLifeYearsLeftReturnsFalseWithCorrectMessage() throws Exception {
        assetValidator.validate("Pony", "5000", "1000", "-50");
        String actualMessage = assetValidator.getMessage();

        verify(listener).validationFailed(actualMessage);
        assertEquals("Life years cannot be a negative number!", actualMessage);
    }


}
