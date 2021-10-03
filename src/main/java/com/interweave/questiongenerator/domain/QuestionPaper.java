package com.interweave.questiongenerator.domain;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class QuestionPaper {

    private Long id;
    private String subject;
    private LinkedHashMap<String, List<Question>> modulesAndQuestions;
    private String code;
    private String duration;
    private Set<String> rules;

    public QuestionPaper() {
    }

    public QuestionPaper(Long id, String subject, LinkedHashMap<String, List<Question>> modulesAndQuestions, String code, String duration, Set<String> rules) {
        this.id = id;
        this.subject = subject;
        this.modulesAndQuestions = modulesAndQuestions;
        this.code = code;
        this.duration = duration;
        this.rules = rules;
    }

    public Long getId() {
        return id;
    }

    public QuestionPaper setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public QuestionPaper setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public LinkedHashMap<String, List<Question>> getModulesAndQuestions() {
        return modulesAndQuestions;
    }

    public QuestionPaper setModulesAndQuestions(LinkedHashMap<String, List<Question>> modulesAndQuestions) {
        this.modulesAndQuestions = modulesAndQuestions;
        return this;
    }
    public String getCode() {
        return code;
    }

    public QuestionPaper setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public QuestionPaper setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Set<String> getRules() {
        return rules;
    }

    public QuestionPaper setRules(Set<String> rules) {
        this.rules = rules;
        return this;
    }
}
