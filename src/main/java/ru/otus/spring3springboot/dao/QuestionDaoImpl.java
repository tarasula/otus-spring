package ru.otus.spring3springboot.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Repository;
import ru.otus.spring3springboot.model.Question;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Override
    public List<Question> readCsvFile(String fileName) {
        var inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        try (var csvReader = new CSVReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            var questionList = new ArrayList<Question>();
            var fileData = csvReader.readAll();
            fileData.forEach(row -> questionList.add(new Question(row[0], row[1], row[2])));
            return questionList;

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
