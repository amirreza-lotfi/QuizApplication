package com.amirreza.quizapplication.feature_quiz.domain.model;

public class Awnser {
    private int questionId;
    private String awnser;

    public Awnser(int questionId, String awnser) {
        this.questionId = questionId;
        this.awnser = awnser;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAwnser() {
        return awnser;
    }

    public void setAwnser(String awnser) {
        this.awnser = awnser;
    }
}
