package day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class GroupAnswers {

    public static int numQuestionsAnswerable(String[] allAnswers) {
        Map<String, String> answers = new HashMap<>();

        for(String answer : allAnswers) {
            answers.put(answer, answer);
        }

        return answers.size();
    }
}
