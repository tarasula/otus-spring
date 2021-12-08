package ru.otus.spring3springboot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring3springboot.dao.QuestionDao;
import ru.otus.spring3springboot.model.Question;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Value("${question.file.name}")
    private String fileName;

    @Override
    public List<Question> getQuestionFromCsvFile() {
        return questionDao.readCsvFile(fileName);
    }
}
