package day5;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SeatFinderTest {
    private final SeatFinder seatFinder = new SeatFinder();

    @Test
    public void testSeats() {
        assertThat(seatFinder.findSeat("BFFFBBFRRR"),
            equalTo(new Seat(70, 7)));
        assertThat(seatFinder.findSeat("FFFBBBFRRR"),
            equalTo(new Seat(14, 7)));
        assertThat(seatFinder.findSeat("BBFFBBFRLL"),
            equalTo(new Seat(102, 4)));
    }

    @Test
    public void puzzleInputHighestSeatId() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day5/puzzleInput.txt");
        List<String> binarySpacePartitions = inputReader.readLines();

        int highestId = binarySpacePartitions.stream()
            .map(p -> seatFinder.findSeat(p).calculateSeatId())
            .max(Comparator.naturalOrder())
            .orElseThrow();

        assertThat(highestId, equalTo(944));
    }

    @Test
    public void puzzleInputMySeatId() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day5/puzzleInput.txt");
        List<String> binarySpacePartitions = inputReader.readLines();

        int highestId = binarySpacePartitions.stream()
            .map(p -> seatFinder.findSeat(p).calculateSeatId())
            .max(Comparator.naturalOrder())
            .orElseThrow();

        List<Integer> seatIds = binarySpacePartitions.stream()
            .map(p -> seatFinder.findSeat(p).calculateSeatId())
            .sorted()
            .collect(Collectors.toList());

        List<Integer> missingSeatIds = IntStream.range(0, highestId)
            .filter(i -> !seatIds.contains(i))
            .sorted()
            .boxed()
            .collect(Collectors.toList());

        // My puzzle input means the missing id is >> 0, hence...
        assertThat(missingSeatIds.stream().max(Comparator.naturalOrder()).orElseThrow(),
            equalTo(554));
    }
}