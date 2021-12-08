package ru.otus.spring3springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring3springboot.service.QuestionService;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {

        var context = SpringApplication.run(Main.class, args);
        var service = context.getBean(QuestionService.class);
        var questionList = service.getQuestionFromCsvFile();


        System.out.println("Hello, what is your First and Last name? \n");

        questionList.forEach(question -> {
            System.out.println(question.getQuestionNum() + ". " + question.getQuestion());
            System.out.println(question.getAnswer());
        });
        context.close();

    }

}
