package com.interweave.questiongenerator.service;

import com.interweave.questiongenerator.domain.Question;
import com.interweave.questiongenerator.domain.QuestionDifficulty;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class ReadQuestions {
    //Map<Subject-name, Map<Module-name, Map<Level, List<Questions>>>
    public static Map<String, Map<String, Map<String, List<Question>>>> questionsPerSubject = new LinkedHashMap<>(20);
    public static Map<String, Set<String>> subjectsAndModules = new LinkedHashMap<>(10);
    /**
     *
     * @param path path of the folder which contains all the excel files (assuming 1 file per subject, and one sheet per module in a file)
     * @return
     */
    public static void readQuestionsFromExcel(String path) {
        File filePath = new File(path);

        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith("xls") || p.getFileName().toString().endsWith("xlsx") || p.getFileName().toString().endsWith("xltx"))
                    .forEach(p -> {
                        try(Workbook workbook = new XSSFWorkbook(p.toFile())){
                            String subject = filePath.getName();
                            if(!subjectsAndModules.containsKey(subject)) subjectsAndModules.put(subject, new LinkedHashSet<>());
                            if(!questionsPerSubject.containsKey(subject)) questionsPerSubject.put(subject, new LinkedHashMap<>());
                            for(Sheet sheet : workbook) {
                                String module = sheet.getSheetName();
                                subjectsAndModules.get(subject).add(module);
                                if(!questionsPerSubject.get(subject).containsKey(module))questionsPerSubject.get(subject).put(module, new LinkedHashMap<>());
                                Map<String, List<Question>> questionPerLevel = new LinkedHashMap<>();
                                int i = 0;
                                boolean breakCond = false;
                                for (Row row : sheet) {
                                    if(i == 0) {
                                        if(!"S NO".equals(row.getCell(0).getRichStringCellValue().getString())){
                                            System.out.println("1st row 1st column string did not match 'id'");
                                            breakCond = true;
                                        }
                                        if(!"QUESTION".equals(row.getCell(1).getRichStringCellValue().getString())){
                                            System.out.println("1st row 2nd column string did not match 'id'");
                                            breakCond = true;
                                        }
                                        if(!"LEVEL".equals(row.getCell(2).getRichStringCellValue().getString())){
                                            System.out.println("1st row 3nd column string did not match 'id'");
                                            breakCond = true;
                                        }
                                    } else {
                                        //S NO	QUESTION	LEVEL
                                        Long id = (long)row.getCell(0).getNumericCellValue();
                                        String question = row.getCell(1).getRichStringCellValue().getString();
                                        String level = String.valueOf(row.getCell(2).getRichStringCellValue().getString());
                                        if(questionPerLevel.containsKey(level)) {
                                            questionPerLevel.get(level).add(new Question(id, question, QuestionDifficulty.valueOf(level), module, subject));
                                        } else {
                                            questionPerLevel.put(level, new ArrayList<>());
                                        }
                                    }
                                    if(breakCond) {
                                        System.out.println("Cannot process excel. Exiting.");
                                        break;
                                    }

                                    i++;
                                }
                                questionsPerSubject.get(subject).get(module).putAll(questionPerLevel);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
