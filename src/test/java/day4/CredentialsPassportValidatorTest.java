package day4;

import com.google.common.collect.Sets;
import exceptions.AdventException;
import io.FileInputReader;
import io.InputReader;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static day4.PassportConstants.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CredentialsPassportValidatorTest {
    private static final Set<String> REQUIRED_CREDENTIALS = Sets.newHashSet(
        BIRTH_YEAR,
        ISSUE_YEAR,
        EXPIRATION_YEAR,
        HEIGHT,
        HAIR_COLOUR,
        EYE_COLOUR,
        PASSPORT_ID
    );

    private final PassportValidator passportValidator = new CredentialsPassportValidator(REQUIRED_CREDENTIALS);

    @Test
    public void smallCase() throws AdventException {
        InputReader inputReader = FileInputReader.createWithSpaceSeparator("src/test/resources/day4/smallCase.txt");
        List<String[]> rawCredentials = inputReader.readDataWithLineBreaks();

        checkPassports(rawCredentials, 2L);
    }

    @Test
    public void puzzleInput() throws AdventException {
        InputReader inputReader = FileInputReader.createWithSpaceSeparator("src/test/resources/day4/puzzleInput.txt");
        List<String[]> rawCredentials = inputReader.readDataWithLineBreaks();

        checkPassports(rawCredentials, 193L);
    }

    private void checkPassports(List<String[]> rawCredentials, long expectedNumValid) {
        List<Passport> passports = rawCredentials.stream()
            .map(Passport::fromRawCredentials)
            .collect(Collectors.toList());

        long numValidPassports = passports.stream()
            .filter(passportValidator::isPassportValid)
            .count();

        assertThat(numValidPassports, equalTo(expectedNumValid));
    }
}