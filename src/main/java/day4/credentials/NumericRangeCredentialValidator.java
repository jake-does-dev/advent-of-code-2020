package day4.credentials;

public class NumericRangeCredentialValidator implements CredentialValidator {
    private final int lower;
    private final int upper;
    private final int value;

    public NumericRangeCredentialValidator(int lower, int upper, int value) {
        this.lower = lower;
        this.upper = upper;
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return lower <= value && value <= upper;
    }
}
