package com.interweave.questiongenerator.service;

import com.interweave.questiongenerator.domain.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CreateQuestionPaper {

    public QuestionPaper createPaperForRecruit(ExamDTO examDTO) {
        QuestionPaper questionPaper = new QuestionPaper();
        LinkedHashMap<String, List<Question>> selectedQuestions = new LinkedHashMap<>(50);
        //Map<Subject-name, Map<Module-name, Map<Level, List<Questions>>>
        Map<String, Map<String, Map<String, List<Question>>>> questionsPerSubject = ReadQuestions.questionsPerSubject;
        String subject = examDTO.getSubject();
        prepareStandardQuestionPaperType(examDTO);
        if(!Objects.isNull(questionsPerSubject)) {
            questionsPerSubject.get(examDTO.getSubject()).forEach((String module, Map<String, List<Question>> questionPerLevel) -> {
                selectedQuestions.put(module, new ArrayList<>());
                Optional<ModuleLevel> optionalModuleLevel = examDTO.getModuleLevels().stream().filter(moduleLevel -> module.equals(moduleLevel.getModule())).findFirst();
                if(optionalModuleLevel.isPresent()) {
                    ModuleLevel ml = optionalModuleLevel.get();
                    ml.getPercentPerLevel().forEach((level, percent) -> {
                        int questionsToPick = Math.toIntExact(Math.round((examDTO.getQuestionPerModule() * percent) / 100.0));
                        List<Question> validQList = questionPerLevel.get(level);
                        Random rand = new Random();
                        //Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)
                        rand.ints(0,validQList.size()).limit(questionsToPick)
                                .forEach(randomIndex -> selectedQuestions.get(module).add(validQList.get(randomIndex)));
                    });
                }
            });
            questionPaper.setId(1L);
            questionPaper.setDuration(examDTO.getDuration());
            questionPaper.setSubject(subject);
            questionPaper.setCode(examDTO.getExamCode());
            questionPaper.setRules(examDTO.getInstructionSet());
            questionPaper.setModulesAndQuestions(selectedQuestions);
        }

        return questionPaper;
    }

    private void prepareStandardQuestionPaperType(ExamDTO examDTO) {
        if(QuestionPaperType.STANDARD == examDTO.getQuestionPaperType()) {
            List<ModuleLevel> moduleLevels = new ArrayList<>(10);
            Map<String, Set<String>> subjectsAndModules = ReadQuestions.subjectsAndModules;
            subjectsAndModules.get(examDTO.getSubject()).forEach(module -> {
                Map<String, Integer> percentPerLevel = new LinkedHashMap<>();
                percentPerLevel.put(QuestionDifficulty.EASY.getName(), 25);
                percentPerLevel.put(QuestionDifficulty.VERY_EASY.getName(), 25);
                percentPerLevel.put(QuestionDifficulty.MODERATE.getName(), 25);
                percentPerLevel.put(QuestionDifficulty.DIFFICULT.getName(), 25);
                moduleLevels.add(new ModuleLevel(module, percentPerLevel));
            });
            examDTO.setModuleLevels(moduleLevels);
        }

    }
}
