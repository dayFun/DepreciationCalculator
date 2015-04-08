package depCalc.utils;

public interface IValidationStatusListener {

    public void validationFailed(String message);

    public void validationPassed(String message);

}
