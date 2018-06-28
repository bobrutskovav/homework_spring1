package service;

import domain.Question;
import java.util.List;

public interface QuestionReaderService {

    List<Question> getAllQuestions();

    Question getQuestionById(String id);

}
