package day2;

import static day2.PasswordPolicyConstants.RANGE_SEPARATOR;
import static day2.PasswordPolicyConstants.REQUIRED_CHARACTER_ENDING;

public abstract class PasswordPolicyUtils {
    public static int extractStartValue(String[] rawPolicy) {
        return Integer.parseInt(rawPolicy[0].split(RANGE_SEPARATOR)[0]);
    }

    public static int extractEndValue(String[] rawPolicy) {
        return Integer.parseInt(rawPolicy[0].split(RANGE_SEPARATOR)[1]);
    }

    public static char extractCharacter(String[] rawPolicy) {
        return rawPolicy[1].split(REQUIRED_CHARACTER_ENDING)[0].charAt(0);
    }
}
