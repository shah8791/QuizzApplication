package com.quizz.Quiz_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizz.Quiz_App.model.Quiz;
import com.quizz.Quiz_App.repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
    private QuizRepository quizRepository;

    public List<Quiz> findAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

	public Object getQuizById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		
	}

	public List<Quiz> getAllQuizzes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteQuiz(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
