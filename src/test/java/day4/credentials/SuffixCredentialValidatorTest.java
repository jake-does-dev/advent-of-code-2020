package day4.credentials;

import com.google.common.collect.Sets;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class SuffixCredentialValidatorTest {

    @Test
    public void valid() {
        CredentialValidator credentialValidator = new SuffixCredentialValidator(
            Sets.newHashSet("in", "cm"),
            "124cm"
        );
        assertThat(credentialValidator.isValid(), equalTo(true));
    }

    @Test
    public void invalid() {
        CredentialValidator credentialValidator = new SuffixCredentialValidator(
            Sets.newHashSet("in", "cm"),
            "124ca"
        );
        assertThat(credentialValidator.isValid(), equalTo(false));
    }
}