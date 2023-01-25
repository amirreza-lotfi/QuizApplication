package com.amirreza.quizapplication.feature_quiz.data.source;

import com.amirreza.quizapplication.feature_quiz.domain.model.Answer;
import com.amirreza.quizapplication.feature_quiz.domain.model.Question;
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz;
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class QuizRemoteDataSource implements QuizDataSourceI {

    @Override
    public Single<Quiz> getQuizzes() {
        /*
         * این دیتا صرفا جهت تست است. در اپلیکیشن واقعی این اطلاعات از سرور دریافت میشود
         */
        ArrayList<String> writers1 = new ArrayList<>();
        writers1.add("Gabriel Garcia Marquez");
        writers1.add("Jose Alcala Galiano");
        writers1.add("Baltasar del Alcazar");
        writers1.add("Vicente Aleixandre");

        ArrayList<String> writers2 = new ArrayList<>();
        writers2.add("Baltasar del Alcazar");
        writers2.add("Vicente Aleixandre");
        writers2.add("Gabriel Garcia Marquez");
        writers2.add("Jose Alcala Galiano");

        ArrayList<String> writers3 = new ArrayList<>();
        writers3.add("Gabriel Garcia Marquez");
        writers3.add("Jose Alcala Galiano");
        writers3.add("Baltasar del Alcazar");
        writers3.add("Vicente Aleixandre");

        ArrayList<String> writers4 = new ArrayList<>();
        writers4.add("Gabriel Garcia Marquez");
        writers4.add("Baltasar del Alcazar");
        writers4.add("Vicente Aleixandre");
        writers4.add("Jose Alcala Galiano");

        ArrayList<String> writers5 = new ArrayList<>();
        writers5.add("Gabriel Garcia Marquez");
        writers5.add("Vicente Aleixandre");
        writers5.add("Baltasar del Alcazar");
        writers5.add("Jose Alcala Galiano");

        return Single.just(
                new Quiz(
                        List.of(
                                new Question(1,"Who is the author of book 'In Evil Hour' ?",writers1),
                                new Question(2,"Who is the author of book 'One Hundred Years of Solitude' ?",writers2),
                                new Question(3,"Who is the author of book 'Love in the Time of Cholera' ?",writers3),
                                new Question(4,"Who is the author of book 'Of Love and Other Demons' ?",writers4),
                                new Question(5,"Who is the author of book 'The General in His Labyrinth' ?",writers5)
                        )
                )
        );
    }

    @Override
    public Single<QuizResult> getResult(Answer[] answers) {
        int wrong = 0;
        int correct = 0;

        for (Answer answer : answers){
            if(answer.getAnswer().equals("Gabriel Garcia Marquez"))
                correct+=1;
            else
                wrong+=1;
        }

        return Single.just(new QuizResult(wrong, correct));

        //Todo save answer and username in database
    }
}
