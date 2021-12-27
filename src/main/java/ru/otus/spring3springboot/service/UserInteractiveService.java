package ru.otus.spring3springboot.service;

import ru.otus.spring3springboot.model.Question;

import java.util.List;

public interface UserInteractiveService {

    void printQuestion(List<Question> questionList);
}
