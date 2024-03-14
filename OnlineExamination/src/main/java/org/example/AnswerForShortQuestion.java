package org.example;

public class AnswerForShortQuestion  extends Question {
    String correctAnswer;

    AnswerForShortQuestion(String text, String correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean isCorrect(String response) {
        return response.equalsIgnoreCase(correctAnswer);
    }
}
