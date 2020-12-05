package day2;

public class CharacterCountPasswordPolicy extends AbstractPasswordPolicy {
    public CharacterCountPasswordPolicy(String[] rawPolicy) {
        super(
                PasswordPolicyUtils.extractCharacter(rawPolicy),
                PasswordPolicyUtils.extractStartValue(rawPolicy),
                PasswordPolicyUtils.extractEndValue(rawPolicy)
        );
    }

    @Override
    public boolean isPasswordValid(String password) {
        int numOccurrences = (int) password.chars().parallel()
                .filter(c -> requiredCharacter == (char) c)
                .count();

        return startValue <= numOccurrences && numOccurrences <= endValue;
    }
}
