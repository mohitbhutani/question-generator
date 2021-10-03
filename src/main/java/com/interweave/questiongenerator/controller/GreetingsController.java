package com.interweave.questiongenerator.controller;

import com.interweave.questiongenerator.domain.ExamDTO;
import com.interweave.questiongenerator.domain.QuestionPaper;
import com.interweave.questiongenerator.service.CreateQuestionPaper;
import com.interweave.questiongenerator.service.ReadQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired
    CreateQuestionPaper createQuestionPaper;



    @GetMapping("/createPaperForRecruit")
    public QuestionPaper readQuestions(@RequestParam(value = "examDto") ExamDTO examDTO) {
        ReadQuestions.readQuestionsFromExcel("/home/mohit/Documents/question-paper-generator/");
        return createQuestionPaper.createPaperForRecruit(examDTO);
    }
}