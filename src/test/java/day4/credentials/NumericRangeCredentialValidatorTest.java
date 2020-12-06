package day4.credentials;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class NumericRangeCredentialValidatorTest {
    @Test
    public void valid() {
        CredentialValidator credentialValidator = new NumericRangeCredentialValidator(3, 5, 5);
        assertThat(credentialValidator.isValid(), equalTo(true));
    }

    @Test
    public void invalid() {
        CredentialValidator credentialValidator = new NumericRangeCredentialValidator(3, 5, 1);
        assertThat(credentialValidator.isValid(), equalTo(false));
    }
}