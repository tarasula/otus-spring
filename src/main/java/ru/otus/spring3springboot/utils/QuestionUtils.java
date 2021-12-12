package ru.otus.spring3springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
public class QuestionUtils {


    private static MessageSource messageSource;

    @Autowired
    public QuestionUtils(MessageSource messageSource) {
        QuestionUtils.messageSource = messageSource;
    }

    public static String getSourceMessage(String messageParameter){
        return messageSource.getMessage(messageParameter, null, Locale.forLanguageTag(Locale.getDefault().getLanguage()));
    }

    public static Scanner getScanner(){
        return new Scanner(System.in);
    }

    public static String getLocale(){
        return Locale.getDefault().getLanguage();
    }
}
