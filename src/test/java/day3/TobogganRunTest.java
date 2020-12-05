package day3;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class TobogganRunTest {

    @Test
    public void smallCase() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day3/smallCase.txt");
        List<String[]> inputs = inputReader.readLines();

        TobogganRun tobogganRun = new TobogganRun(3, inputs);

        assertThat(tobogganRun.findNumEncounteredTrees(), equalTo(7));
    }

    @Test
    public void puzzleInput() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day3/puzzleInput.txt");
        List<String[]> inputs = inputReader.readLines();

        TobogganRun tobogganRun = new TobogganRun(3, inputs);

        assertThat(tobogganRun.findNumEncounteredTrees(), equalTo(162));
    }
}