package ru.otus.spring3springboot.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring3springboot.config.LocalePropertiesConfig;
import ru.otus.spring3springboot.dao.QuestionDao;
import ru.otus.spring3springboot.model.Question;
import ru.otus.spring3springboot.utils.QuestionUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;
    private final LocalePropertiesConfig localePropertiesConfig;

    @Override
    public List<Question> getQuestionFromCsvFile(String fileName) {
        return questionDao.readCsvFile(
                localePropertiesConfig.getFilenames().get(QuestionUtils.getLocale()));
    }
}
