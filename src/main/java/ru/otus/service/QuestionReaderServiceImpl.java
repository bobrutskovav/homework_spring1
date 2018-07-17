package ru.otus.service;

import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;
import java.util.List;

public class QuestionReaderServiceImpl implements QuestionReaderService {

    private final QuestionDao dao;

    public QuestionReaderServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }

    public Question getQuestionById(final String id) {
        return dao.getAllQuestions().stream().filter(q -> q.getId().equals(id)).findFirst().get();
    }
}
