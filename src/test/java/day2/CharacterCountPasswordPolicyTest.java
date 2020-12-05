package day2;

import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class CharacterCountPasswordPolicyTest {

    @Test
    public void simplePolicy() {
        PasswordPolicy policy = new CharacterCountPasswordPolicy(
                new String[]{"1-3", "a:"});

        assertThat(policy.isPasswordValid("bleb"), equalTo(false));
        assertThat(policy.isPasswordValid("aleb"), equalTo(true));
        assertThat(policy.isPasswordValid("aaeb"), equalTo(true));
        assertThat(policy.isPasswordValid("aaab"), equalTo(true));
        assertThat(policy.isPasswordValid("aaaa"), equalTo(false));
    }

    @Test
    public void smallCase() throws AdventException {
        InputReader inputReader = FileInputReader.createWithSpaceSeparator("src/test/resources/day2/smallCase.txt");
        List<String[]> inputs = inputReader.readLines();

        assertThat(numValidPasswords(inputs), equalTo(2));
    }

    @Test
    public void puzzleInput() throws AdventException {
        InputReader inputReader = FileInputReader.createWithSpaceSeparator("src/test/resources/day2/puzzleInput.txt");
        List<String[]> inputs = inputReader.readLines();

        assertThat(numValidPasswords(inputs), equalTo(580));
    }

    private static int numValidPasswords(List<String[]> inputs) {
        int numValidPassword = 0;

        for(String[] input : inputs) {
            String[] rawPolicy = Arrays.copyOfRange(input, 0, input.length - 1);
            String password = input[input.length - 1];

            PasswordPolicy policy = new CharacterCountPasswordPolicy(rawPolicy);
            if (policy.isPasswordValid(password)) {
                numValidPassword++;
            }
        }

        return numValidPassword;
    }
}