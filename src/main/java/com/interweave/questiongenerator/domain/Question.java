package com.interweave.questiongenerator.domain;

public class Question {

    private Long id;
    private String questionText;
    private QuestionDifficulty questionDifficulty;
    private String module;
    private String subject;

    public Question(Long id, String questionText, QuestionDifficulty questionDifficulty, String module, String subject) {
        this.id = id;
        this.questionText = questionText;
        this.questionDifficulty = questionDifficulty;
        this.module = module;
        this.subject = subject;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public Question setId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Question setQuestionText(String questionText) {
        this.questionText = questionText;
        return this;
    }

    public QuestionDifficulty getQuestionDifficulty() {
        return questionDifficulty;
    }

    public Question setQuestionDifficulty(QuestionDifficulty questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
        return this;
    }

    public String getModule() {
        return module;
    }

    public Question setModule(String module) {
        this.module = module;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Question setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
