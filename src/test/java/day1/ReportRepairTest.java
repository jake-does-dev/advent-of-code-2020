package day1;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReportRepairTest {
    @Test
    public void smallCasePair() throws AdventException {
        InputReader inputReader = new FileInputReader("src/test/resources/day1/smallCase.txt");
        List<Integer> entries = inputReader.readNumbers();

        ReportRepair reportRepair = new ReportRepair(entries);

        assertThat(reportRepair.multiplyPairThatSumsTo(2020), equalTo(514579));
    }

    @Test
    public void smallCaseTriple() throws AdventException {
        InputReader inputReader = new FileInputReader("src/test/resources/day1/smallCase.txt");
        List<Integer> entries = inputReader.readNumbers();

        ReportRepair reportRepair = new ReportRepair(entries);

        assertThat(reportRepair.multiplyTripleThatSumsTo(2020), equalTo(241861950));
    }

    @Test
    public void puzzleInputPair() throws AdventException {
        InputReader inputReader = new FileInputReader("src/test/resources/day1/puzzleInput.txt");
        List<Integer> entries = inputReader.readNumbers();

        ReportRepair reportRepair = new ReportRepair(entries);

        assertThat(reportRepair.multiplyPairThatSumsTo(2020), equalTo(1007104));
    }

    @Test
    public void puzzleInputTriple() throws AdventException {
        InputReader inputReader = new FileInputReader("src/test/resources/day1/puzzleInput.txt");
        List<Integer> entries = inputReader.readNumbers();

        ReportRepair reportRepair = new ReportRepair(entries);

        assertThat(reportRepair.multiplyTripleThatSumsTo(2020), equalTo(18847752));
    }
}