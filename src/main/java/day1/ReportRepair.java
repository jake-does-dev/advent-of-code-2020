package day1;

import java.util.Arrays;
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

    public int multiplyPairThatSumsTo(int value) {
        for (int x : entries) {
            for (int y : entries) {
                if (sumTuple(x, y) == value) {
                    return x * y;
                }
            }
        }
        return -1;
    }

    public int multiplyTripleThatSumsTo(int value) {
        for (int x : entries) {
            for (int y : entries) {
                for (int z : entries) {
                    if (sumTuple(x, y, z) == value) {
                        return x * y * z;
                    }
                }
            }
        }
        return -1;
    }

    private int sumTuple(Integer... values) {
        return new Tuple(values).sum();
    }

    static class Tuple {
        List<Integer> numbers;

        public Tuple(Integer[] numbers) {
            this.numbers = Arrays.asList(numbers);
        }

        public int sum() {
            return numbers.stream().mapToInt(i -> i).sum();
        }
    }
}
