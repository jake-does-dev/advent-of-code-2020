package day2;

public abstract class AbstractPasswordPolicy implements PasswordPolicy {
    protected final char requiredCharacter;
    protected final int startValue;
    protected final int endValue;

    public AbstractPasswordPolicy(char requiredCharacter, int startValue, int endValue) {
        this.requiredCharacter = requiredCharacter;
        this.startValue = startValue;
        this.endValue = endValue;
    }
}
