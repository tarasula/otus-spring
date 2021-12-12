package ru.otus.spring3springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring3springboot.model.Question;
import ru.otus.spring3springboot.utils.QuestionUtils;

import java.util.List;
import java.util.Scanner;

@Service
public class UserInteractiveServiceImpl implements UserInteractiveService{

    @Override
    public void printQuestion(List<Question> questionList) {

        Scanner in = QuestionUtils.getScanner();

        System.out.println(QuestionUtils.getSourceMessage("hello.question") + "\n");
        in.nextLine();
        System.out.println(QuestionUtils.getSourceMessage("user.info") + "\n");
        in.nextLine();

        questionList.forEach(question -> {
            System.out.println(question.getQuestionNum() + ". " + question.getQuestion() + " " + question.getAnswer());
            in.nextLine();
        });

        System.out.println(QuestionUtils.getSourceMessage("user.end.survey.info"));
        in.close();
    }
}
