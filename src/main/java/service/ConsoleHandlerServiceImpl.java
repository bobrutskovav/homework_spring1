package service;

import domain.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleHandlerServiceImpl implements ConsoleHandlerService {

    private String userName;
    private Scanner scanner;


    private final QuestionReaderService questionReaderService;

    public ConsoleHandlerServiceImpl(QuestionReaderService questionReaderService) {
        this.questionReaderService = questionReaderService;
    }

    @Override
    public void startService() {
        scanner = new Scanner(System.in);
        List<Question> questions = questionReaderService.getAllQuestions();
        readUserInput();
        Map<Question, String> userResult = startQuestionSession(questions);
        scanner.close();
        calculateResultsOfTests(userResult);
    }

    private void calculateResultsOfTests(Map<Question, String> userAnswers) {
        int questionCounter = userAnswers.size();
        long rightAnswers = userAnswers.entrySet().stream()
                .filter(x -> x.getValue().equalsIgnoreCase(x.getKey().getRightAnswer())).count();
        if (questionCounter - rightAnswers <= questionCounter / 2) {
            System.out.println(userName + ", поздравляю! Тест пройден");
        } else {
            System.out.println(userName + ", очень жаль! Тест не пройден");
        }
    }

    private void readUserInput() {
        System.out.println("Привет!!\nВведи своё имя:");
        userName = scanner.nextLine();
        System.out.println("Тестирование начинается!");
    }

    private Map<Question, String> startQuestionSession(List<Question> questions) {
        Map<Question, String> userAnswers = new HashMap<>();
        for (Question question : questions) {
            System.out.println("Вопрос № " + question.getId() + "\n" +
                    question.getName());
            System.out.println(
                    "Варианты ответа: \n" + question.getWrongA2() + "\n" + question.getRightAnswer() + "\n" + question
                            .getWrongA3() + "\n" + question.getWrongA1());
            System.out.println("Напишите верный вариант ответа:");
            String userAnswer = scanner.nextLine();
            userAnswers.put(question, userAnswer);
        }
        return userAnswers;
    }


}
