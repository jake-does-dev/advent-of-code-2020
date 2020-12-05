package day2;

public class UniqueCharacterLocationPasswordPolicy extends AbstractPasswordPolicy {
    public UniqueCharacterLocationPasswordPolicy(String[] rawPolicy) {
        super(
                PasswordPolicyUtils.extractCharacter(rawPolicy),
                PasswordPolicyUtils.extractStartValue(rawPolicy),
                PasswordPolicyUtils.extractEndValue(rawPolicy)
        );
    }

    @Override
    public boolean isPasswordValid(String password) {
        char firstLocationChar = password.charAt(startValue - 1);
        char secondLocationChar = password.charAt(endValue - 1);

        return firstLocationChar == requiredCharacter ^ secondLocationChar == requiredCharacter;
    }
}
