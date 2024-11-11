package com.quizz.Quiz_App.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.Quiz_App.model.Role;
import com.quizz.Quiz_App.model.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	static Optional<User> findByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	Role findByName();


}
