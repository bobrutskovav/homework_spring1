package ru.otus;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.service.QuestionReaderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class QuestionReaderServiceTest {

    @MockBean
    private QuestionDao mockedDao;

    @Autowired
    private QuestionReaderService questionReaderService;


    @Test
    public void findNethodTest() {
        List<Question> questions = new ArrayList<>(1);
        Question testQ = new Question("000", "TestAAA", "1", "2", "3", "4");
        questions.add(testQ);
        given(mockedDao.getAllQuestions()).willReturn(questions);
        assertEquals(questions, questionReaderService.getAllQuestions());

    }

}
