package day3;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class TobogganRunnerTest {

    @Test
    public void smallCaseSingleManoeuvreCountTrees() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day3/smallCase.txt");
        List<String[]> slope = inputReader.readLines();

        TobogganRunner runner = TobogganRunner.createRuns(
            slope,
            Collections.singletonList(new TobogganManoeuvre(3, 1)));

        assertThat(runner.sumTotalTreesEncountered(), equalTo(7));
    }

    @Test
    public void smallCaseMultipleManoeuvreMultiplyTrees() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day3/smallCase.txt");
        List<String[]> slope = inputReader.readLines();

        TobogganRunner runner = TobogganRunner.createRuns(
            slope,
            Arrays.asList(
                new TobogganManoeuvre(1, 1),
                new TobogganManoeuvre(3, 1),
                new TobogganManoeuvre(5, 1),
                new TobogganManoeuvre(7, 1),
                new TobogganManoeuvre(1, 2)
            )
        );

        assertThat(runner.multiplyTreesEncountered(), equalTo(336L));
    }

    @Test
    public void puzzleInputSingleManoeuvreCountTrees() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day3/puzzleInput.txt");
        List<String[]> slope = inputReader.readLines();

        TobogganRunner runner = TobogganRunner.createRuns(
            slope,
            Collections.singletonList(new TobogganManoeuvre(3, 1)));

        assertThat(runner.sumTotalTreesEncountered(), equalTo(162));
    }

    @Test
    public void puzzleInputMultipleManoeuvreMultiplyTrees() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day3/puzzleInput.txt");
        List<String[]> slope = inputReader.readLines();

        TobogganRunner runner = TobogganRunner.createRuns(
            slope,
            Arrays.asList(
                new TobogganManoeuvre(1, 1),
                new TobogganManoeuvre(3, 1),
                new TobogganManoeuvre(5, 1),
                new TobogganManoeuvre(7, 1),
                new TobogganManoeuvre(1, 2)
            )
        );

        assertThat(runner.multiplyTreesEncountered(), equalTo(3064612320L));
    }

}