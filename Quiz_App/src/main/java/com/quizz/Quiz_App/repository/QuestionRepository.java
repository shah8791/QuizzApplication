package com.quizz.Quiz_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizz.Quiz_App.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>  {

}
