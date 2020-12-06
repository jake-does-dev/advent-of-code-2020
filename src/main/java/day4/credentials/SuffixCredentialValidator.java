package day4.credentials;

import java.util.Set;

public class SuffixCredentialValidator implements CredentialValidator {
    private final Set<String> suffixes;
    private final String value;

    public SuffixCredentialValidator(Set<String> suffixes, String value) {
        this.suffixes = suffixes;
        this.value = value;
    }

    @Override
    public boolean isValid() {
        int stringLength = value.length();

        for(String suffix : suffixes) {
            String ending = value.substring(stringLength - suffix.length(), stringLength);
            if (suffix.equals(ending)) {
                return true;
            }
        }

        return false;
    }
}
