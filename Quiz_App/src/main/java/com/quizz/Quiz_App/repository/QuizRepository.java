package com.quizz.Quiz_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.Quiz_App.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
}
