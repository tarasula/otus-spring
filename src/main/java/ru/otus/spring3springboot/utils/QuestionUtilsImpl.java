package ru.otus.spring3springboot.utils;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
public class QuestionUtilsImpl implements  QuestionUtils{

    @Override
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Override
    public String getLocale() {
        return Locale.getDefault().getLanguage();
    }
}
