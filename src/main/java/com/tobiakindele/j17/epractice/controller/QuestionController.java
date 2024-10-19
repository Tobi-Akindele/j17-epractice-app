package com.tobiakindele.j17.epractice.controller;

import com.tobiakindele.j17.epractice.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    private static final int TOTAL_QUESTION = 50;

    private final AnswerService answerService;

    public QuestionController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/question")
    public String showQuestion(@RequestParam(value = "index", defaultValue = "1") int index, Model model) {
        model.addAttribute("index", index);
        model.addAttribute("imagePath", "/images/" + index + ".png");

        model.addAttribute("isFirst", index == 1);

        return "question";
    }

    @PostMapping("/submit-answer")
    public String submitAnswer(@RequestParam("index") int index,
                               @RequestParam("answer") String answer) {
        answerService.saveAnswer(index, answer);

        if (index == TOTAL_QUESTION) {
            return "redirect:/review";
        } else {
            return "redirect:/question?index=" + (index + 1);
        }
    }

    @GetMapping("/review")
    public String showReviewPage(Model model) {
        model.addAttribute("answers", answerService.getAnswers());

        return "review";
    }

    @PostMapping("/result")
    public String showResult(Model model) {
        answerService.computeResult(model);
        answerService.clearAnswers();

        return "result";
    }
}
