package com.amirreza.quizapplication.feature_quiz.domain.model;

import java.util.List;

public class Question {


    private int questionId;
    private String questionText;
    private List<String> options;

    public Question() {
    }

    public Question(int id, String questionText, List<String> options) {
        this.questionText = questionText;
        this.options = options;
        this.questionId = id;
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

    public int getQuestionId() {
        return questionId;
    }
}
