package com.quizz.Quiz_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quizz.Quiz_App.model.Quiz;
import com.quizz.Quiz_App.service.QuizService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private QuizService quizService;

    @GetMapping("/quizzes")
    public String listQuizzes(Model model) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        model.addAttribute("quizzes", quizzes);
        return "admin/quizzes";
    }

    @GetMapping("/quizzes/new")
    public String createQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "admin/create_quiz";
    }

    @PostMapping("/quizzes")
    public String createQuiz(@ModelAttribute Quiz quiz, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/create_quiz";
        }
        quizService.createQuiz(quiz);
        return "redirect:/admin/quizzes";
    }

    @PostMapping("/quizzes/update/{id}")
    public String updateQuiz(@PathVariable Long id, @ModelAttribute Quiz quiz, BindingResult result, Model model) {
        if (result.hasErrors()) {
            quiz.setId(id);
            return "admin/edit_quiz";
        }
        quizService.createQuiz(quiz);
        return "redirect:/admin/quizzes";
    }

    @GetMapping("/quizzes/delete/{id}")
    public String deleteQuiz(@PathVariable Long id, Model model) {
        quizService.deleteQuiz(id);
        return "redirect:/admin/quizzes";
    }

    
}