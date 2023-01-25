package com.amirreza.quizapplication.util.http

import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenResponse
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.User
import com.amirreza.quizapplication.feature_quiz.domain.model.Answer
import com.amirreza.quizapplication.feature_quiz.domain.model.Question
import com.amirreza.quizapplication.feature_quiz.domain.model.Quiz
import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult
import com.amirreza.quizapplication.util.Constant
import io.reactivex.Single

class ApiService {

    fun login(username: String, password: String): Single<TokenResponse>{
        /*
         * Its Just For Test
         * */
        return if(User(username, password) in userListSimulator){
            Single.just(
                TokenResponse(
                    Constant.TOKEN_NAME,
                    Integer.MAX_VALUE,
                    Constant.ACCESS_TOKEN,
                    Constant.REFRESH_TOKEN
                )
            )
        }else{
            Single.error(Exception("Login not succeed!!"))
        }

    }

    fun signUp(username: String, password: String): Single<String> {
        /*
         * Its Just For Test
         * */
        userListSimulator.add(User(username,password))
        return Single.just(
            Constant.ACCESS_TOKEN
        )
    }

    fun getQuizzes():Single<Quiz>{
        /*
         * این دیتا صرفا جهت تست است. در اپلیکیشن واقعی این اطلاعات از سرور دریافت میشود
         */
        val writers1 = ArrayList<String>()
        writers1.add("Gabriel Garcia Marquez")
        writers1.add("Jose Alcala Galiano")
        writers1.add("Baltasar del Alcazar")
        writers1.add("Vicente Aleixandre")

        val writers2 = ArrayList<String>()
        writers2.add("Baltasar del Alcazar")
        writers2.add("Vicente Aleixandre")
        writers2.add("Gabriel Garcia Marquez")
        writers2.add("Jose Alcala Galiano")

        val writers3 = ArrayList<String>()
        writers3.add("Gabriel Garcia Marquez")
        writers3.add("Jose Alcala Galiano")
        writers3.add("Baltasar del Alcazar")
        writers3.add("Vicente Aleixandre")

        val writers4 = ArrayList<String>()
        writers4.add("Gabriel Garcia Marquez")
        writers4.add("Baltasar del Alcazar")
        writers4.add("Vicente Aleixandre")
        writers4.add("Jose Alcala Galiano")

        val writers5 = ArrayList<String>()
        writers5.add("Gabriel Garcia Marquez")
        writers5.add("Vicente Aleixandre")
        writers5.add("Baltasar del Alcazar")
        writers5.add("Jose Alcala Galiano")

        return Single.just(
            Quiz(
                listOf(
                    Question(1, "Who is the author of book 'In Evil Hour' ?", writers1),
                    Question(
                        2,
                        "Who is the author of book 'One Hundred Years of Solitude' ?",
                        writers2
                    ),
                    Question(
                        3,
                        "Who is the author of book 'Love in the Time of Cholera' ?",
                        writers3
                    ),
                    Question(4, "Who is the author of book 'Of Love and Other Demons' ?", writers4),
                    Question(
                        5,
                        "Who is the author of book 'The General in His Labyrinth' ?",
                        writers5
                    )
                )
            )
        )
    }

    fun getResultOfExam(answers:Array<Answer>):Single<QuizResult>{
        var wrong = 0
        var correct = 0

        for (answer in answers) {
            if (answer.answer == "Gabriel Garcia Marquez") correct += 1 else wrong += 1
        }
        val quizResult = QuizResult(wrongAnswer = wrong, correctAnswer = correct)
        quizResultSimulator.add(quizResult)
        return Single.just(quizResult)
    }

    fun getExamHistory():Single<List<QuizResult>>{
        val username = TokenHolder.username
        val qList = ArrayList<QuizResult>()
        for(q: QuizResult in quizResultSimulator){
            if(q.username == username)
                qList.add(q)
        }
        return Single.just(qList)
    }
}
val userListSimulator = mutableListOf<User>()
val quizResultSimulator = mutableListOf<QuizResult>()

