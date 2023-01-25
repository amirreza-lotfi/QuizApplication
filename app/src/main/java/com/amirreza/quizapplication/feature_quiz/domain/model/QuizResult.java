package com.amirreza.quizapplication.feature_quiz.domain.model;

public class QuizResult {
    private int wrongAnswer;
    private int correctAnswer;

    public QuizResult(int wrongAnswer, int correctAnswer) {
        this.wrongAnswer = wrongAnswer;
        this.correctAnswer = correctAnswer;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
