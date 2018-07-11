package service;

import config.ApplicationSettings;
import domain.Question;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class ConsoleHandlerServiceImpl implements ConsoleHandlerService {

    private final QuestionReaderService questionReaderService;
    private final MessageSource messageSource;
    private String userName;
    private Scanner scanner;
    private ApplicationSettings applicationSettings;


    @Autowired
    public ConsoleHandlerServiceImpl(QuestionReaderService questionReaderService, MessageSource messageSource,
            ApplicationSettings applicationSettings) {
        this.questionReaderService = questionReaderService;
        this.messageSource = messageSource;
        this.applicationSettings = applicationSettings;
    }

    @Override
    public void startService(String userName) {
        scanner = new Scanner(System.in);
        this.userName = userName;
        List<Question> questions = questionReaderService.getAllQuestions();
        readUserInput();
        Map<Question, String> userResult = startQuestionSession(questions);
        calculateResultsOfTests(userResult);
    }

    private void calculateResultsOfTests(Map<Question, String> userAnswers) {
        int questionCounter = userAnswers.size();
        long rightAnswers = userAnswers.entrySet().stream()
                .filter(x -> x.getValue().equalsIgnoreCase(x.getKey().getRightAnswer())).count();
        if (questionCounter - rightAnswers <= questionCounter / 2) {
            System.out.println(getMsg("test.success", new String[]{userName}));
        } else {
            System.out.println(getMsg("test.fail", new String[]{userName}));
        }
    }

    private void readUserInput() {
        System.out.println(getMsg("hello", new String[]{userName}));
        System.out.println(getMsg("test.start", null));
    }

    private Map<Question, String> startQuestionSession(List<Question> questions) {
        Map<Question, String> userAnswers = new HashMap<>();
        for (Question question : questions) {
            System.out.println(getMsg("question.id", new String[]{question.getId(), question.getName()}));
            System.out.println(
                    getMsg("question.options", new String[]{question.getWrongA2(), question.getRightAnswer(), question
                            .getWrongA3(), question.getWrongA1()}));
            System.out.println(getMsg("user.answer", null));
            String userAnswer = scanner.nextLine();
            userAnswers.put(question, userAnswer);
        }
        return userAnswers;
    }


    private String getMsg(String propertyName, String[] args) {
        return messageSource.getMessage(propertyName, args, new Locale(applicationSettings.getLocale()));
    }


}
