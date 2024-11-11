package com.quizz.Quiz_App.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.Quiz_App.model.Question;
import com.quizz.Quiz_App.model.Quiz;
import com.quizz.Quiz_App.model.User;
import com.quizz.Quiz_App.model.Score;
import com.quizz.Quiz_App.repository.UserQuizScoreRepository;

@Service
public class ScoringService {
	@Autowired
    private UserQuizScoreRepository userQuizScoreRepository;

    public int calculateScore(Quiz quiz, Map<Long, String> userAnswers) {
        int score = 0;
        for (Question question : quiz.getQuestions()) {
            String userAnswer = userAnswers.get(question.getId());
            if (question.getCorrectAnswer().equals(userAnswer)) {
                score++;
            }
        }
        return score;
    }
    
    public void saveUserScore(User user, Quiz quiz, int score) {
        Score userQuizScore = new Score();
        userQuizScore.setUser(user);
        userQuizScore.setQuiz(quiz);
        userQuizScore.setScore(score);
        userQuizScoreRepository.save(userQuizScore);
    }
}
