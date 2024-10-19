package com.tobiakindele.j17.epractice.service;

import com.tobiakindele.j17.epractice.config.AnswersConfig;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private static final double PASS_MARK = 68.00;

    private final Map<String, String> answers = new HashMap<>();
    private final AnswersConfig answersConfig;

    public AnswerService(AnswersConfig answersConfig) {
        this.answersConfig = answersConfig;
    }

    public void saveAnswer(int questionId, String answer) {
        answers.put(String.valueOf(questionId), answer.toUpperCase());
    }

    public void computeResult(Model model) {
        AtomicInteger score = new AtomicInteger(0);
        int total = answersConfig.getAnswers().size();

        answersConfig.getAnswers().forEach((question, ans) -> {
            Set<String> userAns = Arrays
                    .stream(answers.getOrDefault(question, Strings.EMPTY).split("\\s*,\\s*"))
                    .collect(Collectors.toSet());

            if (ans.equals(userAns)) {
                score.getAndIncrement();
            }
        });
        double percentage = (score.doubleValue() / total) * 100;

        model.addAttribute("percentage", String.format("%.2f", percentage));
        model.addAttribute("score", score);
        model.addAttribute("total", total);
        model.addAttribute("remark", percentage > PASS_MARK ? "PASS" : "FAIL");
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void clearAnswers() {
        answers.clear();
    }
}
