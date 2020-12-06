package day4;

import java.util.HashMap;
import java.util.Map;

import static day4.PassportConstants.KEY_VALUE_SEPARATOR;

public class Passport {
    private final Map<String, String> credentials;

    public static Passport fromRawCredentials(String[] arrayCredentials) {
        Map<String, String> credentials = new HashMap<>();
        for(String credentialKeyValue : arrayCredentials) {
            String[] parts = credentialKeyValue.split(KEY_VALUE_SEPARATOR);
            credentials.put(parts[0], parts[1]);
        }
        return new Passport(credentials);
    }

    private Passport(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }
}
