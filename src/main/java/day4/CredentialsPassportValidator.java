package day4;

import day4.credentials.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static day4.PassportConstants.*;

public class CredentialsPassportValidator implements PassportValidator {
    private final Set<String> requiredCredentials;

    public CredentialsPassportValidator(Set<String> requiredCredentials) {
        this.requiredCredentials = requiredCredentials;
    }

    @Override
    public boolean isPassportValid(Passport passport) {
        Set<CredentialValidator> validators = new HashSet<>();

        Map<String, String> credentials = passport.getCredentials();
        Set<String> credentialKeys = credentials.keySet();

        if (!credentialKeys.containsAll(requiredCredentials)) {
            return false;
        }

        for (String key : credentialKeys) {
            String value = credentials.get(key);

            switch (key) {
                case BIRTH_YEAR:
                    validators.add(new NumericRangeCredentialValidator(1920, 2002, Integer.parseInt(value)));
                    break;
                case ISSUE_YEAR:
                    validators.add(new NumericRangeCredentialValidator(2010, 2020, Integer.parseInt(value)));
                    break;
                case EXPIRATION_YEAR:
                    validators.add(new NumericRangeCredentialValidator(2020, 2030, Integer.parseInt(value)));
                    break;
                case HEIGHT:
                    int length = value.length();

                    switch (value.substring(length - 2)) {
                        case "cm":
                            validators.add(new NumericRangeCredentialValidator(150, 193, Integer.parseInt(value.substring(0, length - 2))));
                            break;
                        case "in":
                            validators.add(new NumericRangeCredentialValidator(59, 76, Integer.parseInt(value.substring(0, length - 2))));
                            break;
                        default:
                            return false;
                    }

                    break;
                case HAIR_COLOUR:
                    validators.add(new HexCredentialValidator(value));
                    break;
                case EYE_COLOUR:
                    validators.add(InCollectionCredentialValidator.eyeColourValidator(value));
                    break;
                case PASSPORT_ID:
                    validators.add(new NumericLengthCredentialValidator(9, value));
                    break;
            }
        }

        return validators.stream()
            .map(CredentialValidator::isValid)
            .reduce((x, y) -> x && y)
            .get();
    }
}
