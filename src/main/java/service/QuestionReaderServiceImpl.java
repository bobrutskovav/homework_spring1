package service;

import dao.QuestionDao;
import domain.Question;
import java.util.List;

public class QuestionReaderServiceImpl implements QuestionReaderService {

    private QuestionDao dao;

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
