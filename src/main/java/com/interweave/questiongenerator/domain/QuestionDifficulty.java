package com.interweave.questiongenerator.domain;

public enum QuestionDifficulty {
    VERY_EASY("VERY EASY"),
    EASY("EASY"),
    MODERATE("MODERATE"),
    DIFFICULT("DIFFICULT");

    private String name;

    QuestionDifficulty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public QuestionDifficulty setName(String name) {
        this.name = name;
        return this;
    }
}
