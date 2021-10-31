package com.interweave.questiongenerator.domain;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;

import java.util.Arrays;

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

    public static QuestionDifficulty getByName(String name) {
        return Arrays.stream(QuestionDifficulty.values()).filter(qd -> qd.getName().toLowerCase().equals(name.toLowerCase())).findFirst().get();
    }
}
