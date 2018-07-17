package ru.otus.service;

import ru.otus.domain.*;
import java.util.List;

public interface QuestionReaderService {

    List<Question> getAllQuestions();

    Question getQuestionById(String id);

}
