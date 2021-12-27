package ru.otus.spring3springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;
import ru.otus.spring3springboot.model.Question;
import ru.otus.spring3springboot.utils.QuestionUtils;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class UserInteractiveServiceImpl implements UserInteractiveService {

    private final MessageSourceService messageSourceService;
    private final QuestionUtils questionUtils;

    @Override
    public void printQuestion(List<Question> questionList) {

        Scanner in = questionUtils.getScanner();

        System.out.println(messageSourceService.getSourceMessage("hello.question") + "\n");
        in.nextLine();
        System.out.println(messageSourceService.getSourceMessage("user.info") + "\n");
        in.nextLine();

        questionList.forEach(question -> {
            System.out.println(question.getQuestionNum() + ". " + question.getQuestion() + " " + question.getAnswer());
            in.nextLine();
        });

        System.out.println(messageSourceService.getSourceMessage("user.end.survey.info"));
//        in.close();
    }
}
