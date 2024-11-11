package com.quizz.Quiz_App.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizz.Quiz_App.model.Quiz;
import com.quizz.Quiz_App.repository.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
    private QuizRepository quizRepository;

    @GetMapping
    public String showQuizzes(Model model) {
        model.addAttribute("quizzes", quizRepository.findAll());
        return "quiz-list";
    }

    @GetMapping("/{id}")
    public String takeQuiz(@PathVariable Long id, Model model) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        model.addAttribute("quiz", quiz.orElseThrow(() -> new RuntimeException("Quiz not found")));
        return "quiz";
    }

}
