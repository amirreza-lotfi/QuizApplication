package com.amirreza.quizapplication.feature_quiz.presentation.fragment_history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirreza.quizapplication.feature_quiz.domain.model.QuizResult;
import com.amirreza.quizeapplication.R;

import java.util.List;

public class QuizHistoryAdapter extends RecyclerView.Adapter<QuizHistoryAdapter.QuizResultHolder> {
    private List<QuizResult> quizResultList;

    public QuizHistoryAdapter(List<QuizResult> quizResultList) {
        this.quizResultList = quizResultList;
    }

    @Override
    public QuizResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz_result,parent,false);
        return new QuizResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizResultHolder holder, int position) {
        holder.bind(quizResultList.get(position));
    }

    @Override
    public int getItemCount() {
        return quizResultList.size();
    }

    public class QuizResultHolder extends RecyclerView.ViewHolder{
        private TextView scoreValue;
        private TextView correctValue;
        private TextView wrongValue;

        public QuizResultHolder(@NonNull View itemView) {
            super(itemView);
            scoreValue = itemView.findViewById(R.id.score_value);
            correctValue = itemView.findViewById(R.id.correct_value);
            wrongValue = itemView.findViewById(R.id.wrong_value);
        }
        public void bind(QuizResult quizResult){
            int correct = quizResult.getCorrectAnswer();
            int wrong = quizResult.getWrongAnswer();
            float score = (float) ((correct*1.0)/(correct+wrong))*100;
            String scoreToString = String.format("%.02f", score);

            correctValue.setText(String.valueOf(correct));
            wrongValue.setText(String.valueOf(wrong));
            scoreValue.setText(scoreToString+"%");
        }
    }
}
