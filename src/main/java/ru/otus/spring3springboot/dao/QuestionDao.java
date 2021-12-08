package ru.otus.spring3springboot.dao;


import ru.otus.spring3springboot.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> readCsvFile(String fileName);
}
