package ru.otus.spring3springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring3springboot.config.LocalePropertiesConfig;
import ru.otus.spring3springboot.service.QuestionService;
import ru.otus.spring3springboot.service.UserInteractiveService;
import ru.otus.spring3springboot.utils.QuestionUtils;

@SpringBootApplication
public class Main {

    private static QuestionService questionService;
    private static UserInteractiveService userInteractiveService;

    @Autowired
    public Main(QuestionService questionService, UserInteractiveService userInteractiveService) {
        Main.questionService = questionService;
        Main.userInteractiveService = userInteractiveService;
    }


    public static void main(String[] args) {

        var context = SpringApplication.run(Main.class, args);

        userInteractiveService.printQuestion(
                questionService.getQuestionFromCsvFile(
                        QuestionUtils.getSourceMessage("question.file.name")));

        context.close();
    }

}
