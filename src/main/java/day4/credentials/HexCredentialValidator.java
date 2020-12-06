package day4.credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexCredentialValidator implements CredentialValidator {
    private final String value;

    public HexCredentialValidator(String value) {
        this.value = value;
    }

    @Override
    public boolean isValid() {
        Pattern pattern = Pattern.compile("^#([A-Fa-f0-9]{6}$)");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
