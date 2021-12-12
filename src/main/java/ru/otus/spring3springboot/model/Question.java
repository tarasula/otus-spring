package ru.otus.spring3springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class Question {

    private final String questionNum;

    private final String question;

    private final String answer;

}
