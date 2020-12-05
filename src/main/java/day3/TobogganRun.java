package day3;

import java.util.List;

public class TobogganRun {
    private static final String SNOW = ".";
    private static final String TREE = "#";

    private final int stepsRight;
    private final List<String[]> rows;

    public TobogganRun(int movementRight, List<String[]> rows) {
        this.stepsRight = movementRight;
        this.rows = rows;
    }

    public int findNumEncounteredTrees() {
        int numEncounteredTrees = 0;
        int xLocation = 0;

        for (String[] row : rows) {
            numEncounteredTrees += TREE.equals(row[xLocation]) ? 1 : 0;
            xLocation = getNextLocation(xLocation, row.length);
        }

        return numEncounteredTrees;
    }

    private int getNextLocation(int previousLocation, int length) {
        return (previousLocation + stepsRight) % length;
    }
}
