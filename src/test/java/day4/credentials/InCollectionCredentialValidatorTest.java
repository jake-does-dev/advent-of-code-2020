package day4.credentials;

import org.junit.Test;

import static day4.PassportConstants.AMBER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InCollectionCredentialValidatorTest {

    @Test
    public void valid() {
        CredentialValidator credentialValidator = InCollectionCredentialValidator.eyeColourValidator(AMBER);
        assertThat(credentialValidator.isValid(), equalTo(true));
    }

    @Test
    public void invalid() {
        CredentialValidator credentialValidator = InCollectionCredentialValidator.eyeColourValidator("WHATEVER");
        assertThat(credentialValidator.isValid(), equalTo(false));
    }
}