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
    public void smallCase() throws AdventException {
        InputReader inputReader = new FileInputReader("src/test/resources/day1/smallCase.txt");
        List<Integer> entries = inputReader.readNumbers();

        ReportRepair reportRepair = new ReportRepair(entries);

        assertThat(reportRepair.multiplyThePairThatSumsTo(2020), equalTo(514579));
    }

    @Test
    public void puzzleInput() throws AdventException {
        InputReader inputReader = new FileInputReader("src/test/resources/day1/puzzleInput.txt");
        List<Integer> entries = inputReader.readNumbers();

        ReportRepair reportRepair = new ReportRepair(entries);

        System.out.println(reportRepair.multiplyThePairThatSumsTo(2020));
    }
}