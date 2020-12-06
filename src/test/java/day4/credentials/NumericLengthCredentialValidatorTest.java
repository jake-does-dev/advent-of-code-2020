package day4.credentials;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class NumericLengthCredentialValidatorTest {

    @Test
    public void valid() {
        CredentialValidator credentialValidator = new NumericLengthCredentialValidator(3, "123");
        assertThat(credentialValidator.isValid(), equalTo(true));
    }

    @Test
    public void invalid() {
        CredentialValidator credentialValidator = new NumericLengthCredentialValidator(4, "123");
        assertThat(credentialValidator.isValid(), equalTo(false));
    }
}