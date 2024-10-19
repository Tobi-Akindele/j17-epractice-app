package com.tobiakindele.j17.epractice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "j17")
public class AnswersConfig {

    private Map<String, Set<String>> answers = new HashMap<>();

    public Map<String, Set<String>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Set<String>> answers) {
        this.answers = answers;
    }
}
