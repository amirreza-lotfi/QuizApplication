package com.amirreza.quizapplication.feature_quiz.domain.model;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;

    public Question() {
    }

    public Question(String questionText, List<String> options) {
        this.questionText = questionText;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
