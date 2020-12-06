package day3;

public class TobogganManoeuvre {
    private final int stepsRight;
    private final int stepsDown;

    public TobogganManoeuvre(int stepsRight, int stepsDown) {
        this.stepsRight = stepsRight;
        this.stepsDown = stepsDown;
    }

    public int getStepsRight() {
        return stepsRight;
    }

    public int getStepsDown() {
        return stepsDown;
    }

    @Override
    public String toString() {
        return "TobogganManoeuvre{" +
            "stepsRight=" + stepsRight +
            ", stepsDown=" + stepsDown +
            '}';
    }
}
