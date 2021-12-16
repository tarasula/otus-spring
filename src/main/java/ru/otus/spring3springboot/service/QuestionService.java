package ru.otus.spring3springboot.service;

import ru.otus.spring3springboot.model.Question;
import java.util.List;

public interface QuestionService {

    List<Question> getQuestionFromCsvFile();
}
