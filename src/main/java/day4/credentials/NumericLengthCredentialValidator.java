package day4.credentials;

public class NumericLengthCredentialValidator implements CredentialValidator {
    private final int length;
    private final String value;

    public NumericLengthCredentialValidator(int length, String value) {
        this.length = length;
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return value.length() == length;
    }
}
