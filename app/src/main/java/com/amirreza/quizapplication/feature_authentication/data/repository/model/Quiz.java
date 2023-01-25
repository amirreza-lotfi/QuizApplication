package com.amirreza.quizapplication.feature_authentication.data.repository.model;

import java.util.List;

public class Quiz {
    private List<Question> questionList;

    public Quiz(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Question getQuestionAt(int index) {
        return questionList.get(index);
    }

    public int getQuestionSize(){
        return questionList.size();
    }
}
