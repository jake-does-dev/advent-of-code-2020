package day5;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.List;

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
    public void puzzleInput() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day5/puzzleInput.txt");
        List<String> binarySpacePartitions = inputReader.readLines();

        int highestId = 0;

        for(String partition : binarySpacePartitions) {
            int seatId = seatFinder.findSeat(partition).calculateSeatId();
            if (highestId < seatId) {
                highestId = seatId;
            }
        }

        assertThat(highestId, equalTo(944));
    }
}