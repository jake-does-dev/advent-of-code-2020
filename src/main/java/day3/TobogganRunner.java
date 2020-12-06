package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TobogganRunner {
    private final List<TobogganRun> runs;

    public static TobogganRunner createRuns(List<String[]> slope, List<TobogganManoeuvre> manoeuvres) {
        List<TobogganRun> runs = new ArrayList<>();

        for(TobogganManoeuvre manoeuvre : manoeuvres) {
            runs.add(new TobogganRun(manoeuvre, slope));
        }

        return new TobogganRunner(runs);
    }

    private TobogganRunner(List<TobogganRun> runs) {
        this.runs = runs;
    }

    public long multiplyTreesEncountered() {
        long product = 1;
        int[] totalTreesEncountered = getTotalTreesEncountered();
        for(int i : totalTreesEncountered) {
            product = product * i;
        }
        return product;
    }

    public int sumTotalTreesEncountered() {
        return Arrays.stream(getTotalTreesEncountered()).sum();
    }

    private int[] getTotalTreesEncountered() {
        return runs.stream()
                .mapToInt(TobogganRun::findNumEncounteredTrees)
                .toArray();
    }
}
