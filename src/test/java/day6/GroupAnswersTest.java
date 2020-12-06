package day6;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupAnswersTest {
    @Test
    public void smallCaseTotalAnswerableForEveryGroup() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day6/smallCase.txt");
        List<String[]> answers = inputReader.readDataWithLineBreaks();

        int numAnswerable = answers.stream()
            .mapToInt(GroupAnswers::numQuestionsAnswerable)
            .sum();

        assertThat(numAnswerable, equalTo(11));
    }

    @Test
    public void puzzleInputTotalAnswerableForEveryGroup() throws AdventException {
        InputReader inputReader = FileInputReader.createWithNoSeparator("src/test/resources/day6/puzzleInput.txt");
        List<String[]> answers = inputReader.readDataWithLineBreaks();

        int numAnswerable = answers.stream()
            .mapToInt(GroupAnswers::numQuestionsAnswerable)
            .sum();

        assertThat(numAnswerable, equalTo(6778));
    }
}