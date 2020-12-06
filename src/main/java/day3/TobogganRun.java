package day3;

import java.util.List;

public class TobogganRun {
    private static final String TREE = "#";

    private final TobogganManoeuvre manoeuvre;
    private final List<String[]> slope;

    public TobogganRun(TobogganManoeuvre manoeuvre, List<String[]> slope) {
        this.manoeuvre = manoeuvre;
        this.slope = slope;
    }

    public int findNumEncounteredTrees() {
        System.out.println("Performing run for manoeuvre: " + manoeuvre);
        int numEncounteredTrees = 0;
        int xLocation = 0;
        int depth = 0;

        while (depth < slope.size()) {
            String[] row = slope.get(depth);
            printRow(row, xLocation);

            numEncounteredTrees += TREE.equals(row[xLocation]) ? 1 : 0;
            xLocation = getNextLocation(xLocation, row.length);
            depth = getNextDepth(depth);
        }

        return numEncounteredTrees;
    }

    private void printRow(String[] row, int xLocation) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row.length; i++) {
            if (i == xLocation) {
                if (TREE.equals(row[xLocation])) {
                    sb.append("X");
                } else {
                    sb.append("O");
                }
            } else {
                sb.append(row[i]);
            }
        }
        System.out.println(sb);
    }

    private int getNextLocation(int previousLocation, int length) {
        return (previousLocation + manoeuvre.getStepsRight()) % length;
    }

    private int getNextDepth(int depth) {
        return depth + manoeuvre.getStepsDown();
    }
}
