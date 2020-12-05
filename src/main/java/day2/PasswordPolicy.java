package day2;

import java.util.Arrays;

public class PasswordPolicy {
    private static final String RANGE_SEPARATOR = "-";
    private static final String REQUIRED_CHARACTER_ENDING = ":";

    private final char requiredCharacter;
    private final int minOccurrences;
    private final int maxOccurrences;

    public static PasswordPolicy createPolicy(String[] rawPolicy) {
        String[] range = rawPolicy[0].split(RANGE_SEPARATOR);
        int minOccurrences = Integer.parseInt(range[0]);
        int maxOccurrences = Integer.parseInt(range[1]);

        char requiredCharacter = rawPolicy[1].split(REQUIRED_CHARACTER_ENDING)[0].charAt(0);

        return new PasswordPolicy(requiredCharacter, minOccurrences, maxOccurrences);
    }

    private PasswordPolicy(char requiredCharacter, int minOccurrences, int maxOccurrences) {
        this.requiredCharacter = requiredCharacter;
        this.minOccurrences = minOccurrences;
        this.maxOccurrences = maxOccurrences;
    }

    public boolean isPasswordValid(String password) {
        int numOccurrences = (int) password.chars().parallel()
                .filter(c -> requiredCharacter == (char) c)
                .count();

        return minOccurrences <= numOccurrences && numOccurrences <= maxOccurrences;
    }
}
