package org.example;
import java.util.ArrayList;
import java.util.List;

public class Examination  {
    String title;
    int duration;
    List<Question> questions;

    Examination(String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.questions = new ArrayList<>();
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}


