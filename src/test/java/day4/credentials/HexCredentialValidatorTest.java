package day4.credentials;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class HexCredentialValidatorTest {

    @Test
    public void valid() {
        CredentialValidator credentialValidator = new HexCredentialValidator("#A904BF");

        assertThat(credentialValidator.isValid(), equalTo(true));
    }

    @Test
    public void invalidNoHash() {
        CredentialValidator credentialValidator = new HexCredentialValidator("AA904BF");

        assertThat(credentialValidator.isValid(), equalTo(false));
    }

    @Test
    public void invalidWrongLength() {
        CredentialValidator credentialValidator = new HexCredentialValidator("#A904BFC");

        assertThat(credentialValidator.isValid(), equalTo(false));
    }
}