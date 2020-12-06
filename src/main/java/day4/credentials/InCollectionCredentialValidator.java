package day4.credentials;

import com.google.common.collect.Sets;

import java.util.Set;

import static day4.PassportConstants.*;

public class InCollectionCredentialValidator implements CredentialValidator {
    private final Set<String> collection;
    private final String value;

    public static InCollectionCredentialValidator eyeColourValidator(String value) {
        return new InCollectionCredentialValidator(
            Sets.newHashSet(AMBER,
                BLUE,
                BROWN,
                GRAY,
                GREEN,
                HAZEL,
                OTHER),
            value
        );
    }

    private InCollectionCredentialValidator(Set<String> collection, String value) {
        this.collection = collection;
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return collection.contains(value);
    }
}
