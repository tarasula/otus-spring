package ru.otus.spring3springboot.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageSourceServiceImplTest {

    @Mock
    private MessageSourceServiceImpl subj;


    @Test
    public void getSourceMessageTest() {
        var sourceMessage = "hello.question";
        when(subj.getSourceMessage(sourceMessage)).thenReturn(Mockito.anyString());

        assertNotNull(subj.getSourceMessage(sourceMessage));
    }
}
