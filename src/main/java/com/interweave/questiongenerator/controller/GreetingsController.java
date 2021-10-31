package com.interweave.questiongenerator.controller;

import com.interweave.questiongenerator.domain.ExamDTO;
import com.interweave.questiongenerator.domain.ExamType;
import com.interweave.questiongenerator.domain.QuestionPaper;
import com.interweave.questiongenerator.domain.QuestionPaperType;
import com.interweave.questiongenerator.dto.UserInput;
import com.interweave.questiongenerator.service.CreateQuestionPaper;
import com.interweave.questiongenerator.service.ReadQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class GreetingsController {

    @Autowired
    CreateQuestionPaper createQuestionPaper;
    @GetMapping("/test")
    public String test( Model model) {
        model.addAttribute("typeOfExams", ExamType.values());
        model.addAttribute("typeOfPapers", QuestionPaperType.values());
        model.addAttribute("subjects", ReadQuestions.subjectsAndModules.keySet());
        model.addAttribute("papers", new HashMap<>());
        return "greeting";
    }


    @PostMapping("/createPaperForRecruit")
    public String readQuestions(@ModelAttribute(value="examDto") ExamDTO examDTO, Model examModel) {

        QuestionPaper questionPaper = createQuestionPaper.createPaperForRecruit(examDTO);
        examModel.addAttribute("questionPaper", questionPaper);
        return "questionPaper";
    }

    @RequestMapping(value = "/loadQuestions", method = RequestMethod.POST)
    public String loadQuestions2(@ModelAttribute(value="userInput") UserInput userInput, Model model) {

        ReadQuestions.readQuestionsFromExcel(userInput.getDir());
        model.addAttribute("typeOfExams", ExamType.values());
        model.addAttribute("typeOfPapers", QuestionPaperType.values());
        model.addAttribute("subjects", ReadQuestions.subjectsAndModules.keySet());
        model.addAttribute("examDto", new ExamDTO());
        return "greeting";
    }
}
