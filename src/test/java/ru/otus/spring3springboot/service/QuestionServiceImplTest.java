package ru.otus.spring3springboot.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring3springboot.config.LocalePropertiesConfig;
import ru.otus.spring3springboot.dao.QuestionDao;
import ru.otus.spring3springboot.model.Question;
import ru.otus.spring3springboot.utils.QuestionUtils;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@SpringBootTest
public class QuestionServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl subj;

    @Mock
    private QuestionUtils questionUtils;

    @Mock
    private LocalePropertiesConfig localePropertiesConfig;

    @Mock
    private QuestionDao questionDao;

    InOrder inOrder;

    @BeforeEach
    void setUp() {
        inOrder = inOrder(questionUtils, localePropertiesConfig, questionDao);
    }

    @Test
    public void getQuestionFromCsvTest(){
        when(questionUtils.getLocale()).thenReturn(Locale.getDefault().getLanguage());
        when(localePropertiesConfig.getFileNames()).thenReturn(getLocaleMap());
        var fileName = localePropertiesConfig.getFileNames().get(questionUtils.getLocale());
        when(questionDao.readCsvFile(fileName)).thenReturn(getQuestionList());

        assertNotNull(subj.getQuestionFromCsvFile());

        inOrder.verify(questionUtils).getLocale();
        inOrder.verify(localePropertiesConfig).getFileNames();
        inOrder.verify(questionDao).readCsvFile(fileName);
        inOrder.verifyNoMoreInteractions();

    }

    private Map<String, String> getLocaleMap(){
        return Map.of("ru", "questions.csv", "en", "questions_en.csv", "pl", "questions_pl.csv");
    }

    private List<Question> getQuestionList(){
        return List.of(new Question("1", "How are you?", "Good/Bad"));
    }
}
