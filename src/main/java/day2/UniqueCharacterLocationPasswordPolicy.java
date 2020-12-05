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
        return false;
    }
}
