package ru.otus.spring3springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class MessageSourceServiceImpl implements MessageSourceService{

    private final MessageSource messageSource;

    @Override
    public String getSourceMessage(String messageParameter) {
        return messageSource.getMessage(messageParameter, null, Locale.forLanguageTag(Locale.getDefault().getLanguage()));
    }
}
