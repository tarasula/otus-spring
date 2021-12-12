package ru.otus.spring3springboot.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class QuestionDaoTest {

    @Value("${question.file.name}")
    private String fileName;

    @Spy
    private QuestionDaoImpl subj;

    InOrder inOrder;

    @BeforeEach
    void setUp() {
        inOrder = inOrder(subj);
    }

    @Test
    public void testReadingOfCsvFile() {
        assertNotNull(subj.readCsvFile(fileName));

        inOrder.verify(subj).readCsvFile(fileName);
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void testQuestionDaoFailReadCsvFile() {
        assertThrows(NullPointerException.class, () -> subj.readCsvFile(null));

        inOrder.verify(subj).readCsvFile(null);
        inOrder.verifyNoMoreInteractions();
    }

}
