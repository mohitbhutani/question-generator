package com.interweave.questiongenerator.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExamDTO {
    private ExamType examType;
    private String subject;
    private Integer questionPerModule;
    private String examCode;
    private String duration;
    private Set<String> instructionSet;
    private QuestionPaperType questionPaperType;
    private List<ModuleLevel> moduleLevels;
    private String formalSubjectName;
    private String examHeading;
    private String totalMarks;

    public ExamDTO(ExamType examType, String subject, Integer questionPerModule, String examCode, String duration, Set<String> instructionSet, QuestionPaperType questionPaperType, List<ModuleLevel> moduleLevels, String formalSubjectName, String examHeading, String totalMarks) {
        this.examType = examType;
        this.subject = subject;
        this.questionPerModule = questionPerModule;
        this.examCode = examCode;
        this.duration = duration;
        this.instructionSet = instructionSet;
        this.questionPaperType = questionPaperType;
        this.moduleLevels = moduleLevels;
        this.formalSubjectName = formalSubjectName;
        this.examHeading = examHeading;
        this.totalMarks = totalMarks;
    }

    public String getFormalSubjectName() {
        return formalSubjectName;
    }

    public ExamDTO setFormalSubjectName(String formalSubjectName) {
        this.formalSubjectName = formalSubjectName;
        return this;
    }

    public String getExamHeading() {
        return examHeading;
    }

    public ExamDTO setExamHeading(String examHeading) {
        this.examHeading = examHeading;
        return this;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public ExamDTO setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
        return this;
    }

    public Set<String> getInstructionSet() {
        return instructionSet;
    }

    public ExamDTO setInstructionSet(Set<String> instructionSet) {
        this.instructionSet = instructionSet;
        return this;
    }

    public String getExamCode() {
        return examCode;
    }

    public ExamDTO setExamCode(String examCode) {
        this.examCode = examCode;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public ExamDTO setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public ExamDTO() {
    }

    public ExamDTO setExamType(ExamType examType) {
        this.examType = examType;
        return this;
    }

    public Integer getQuestionPerModule() {
        return questionPerModule;
    }

    public ExamDTO setQuestionPerModule(Integer questionPerModule) {
        this.questionPerModule = questionPerModule;
        return this;
    }

    public ExamType getExamType() {
        return examType;
    }

    public ExamDTO setExamType(String examType) {
        this.examType = ExamType.valueOf(examType);
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ExamDTO setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public QuestionPaperType getQuestionPaperType() {
        return questionPaperType;
    }

    public ExamDTO setQuestionPaperType(QuestionPaperType questionPaperType) {
        this.questionPaperType = questionPaperType;
        return this;
    }

    public List<ModuleLevel> getModuleLevels() {
        return moduleLevels;
    }

    public ExamDTO setModuleLevels(List<ModuleLevel> moduleLevels) {
        this.moduleLevels = moduleLevels;
        return this;
    }
}

