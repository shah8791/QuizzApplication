package com.quizz.Quiz_App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.Quiz_App.model.User;
import com.quizz.Quiz_App.model.Score;

@Repository
public interface UserQuizScoreRepository extends JpaRepository<Score, Long>{
	 List<Score> findByUser(User user);

}
