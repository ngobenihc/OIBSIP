package org.example;

import java.util.List;

public class MultipleChoiceQuestion extends Question{
    List<String> options;
    int correctOption;

    MultipleChoiceQuestion(String text, List<String> options, int correctOption) {
        super(text);
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    boolean isCorrect(String response) {
        int selectedOption = Integer.parseInt(response);
        return selectedOption == correctOption;
    }
}
