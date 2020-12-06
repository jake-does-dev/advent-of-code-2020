package day5;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SeatTest {

    @Test
    public void calculateSeatId() {
        assertThat(new Seat(70, 7).calculateSeatId(),
            equalTo(567));

        assertThat(new Seat(14, 7).calculateSeatId(),
            equalTo(119));

        assertThat(new Seat(102, 4).calculateSeatId(),
            equalTo(820));
    }

}