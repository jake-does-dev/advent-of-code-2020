package day1;

import java.util.Collections;
import java.util.List;

public class ReportRepair {
    private final List<Integer> entries;
    private final int size;

    public ReportRepair(List<Integer> entries) {
        Collections.sort(entries);
        this.entries = entries;
        this.size = entries.size();
    }

    int multiplyThePairThatSumsTo(int value) {
        int slowPointer = 0;
        int fastPointer = 1;
        int firstSummand = 0;
        int secondSummand = 0;

        boolean isFound = false;
        while(!isFound) {
            int first = entries.get(slowPointer);
            int second = entries.get(fastPointer);

            if (first + second == value) {
                firstSummand = first;
                secondSummand = second;
                isFound = true;
            } else {
                if (slowPointer + 1 > size) {
                    slowPointer = 0;
                } else {
                    slowPointer++;
                }

                if (fastPointer + 2 > size) {
                    fastPointer = 0;
                } else {
                    fastPointer++;
                }
            }
        }

        return firstSummand * secondSummand;
    }
}
