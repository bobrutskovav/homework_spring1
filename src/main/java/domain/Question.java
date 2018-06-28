package domain;

import com.univocity.parsers.annotations.Parsed;
import java.util.Objects;

public class Question {

    @Parsed(field = "id")
    private String id;

    @Parsed(field = "name")
    private String name;

    @Parsed(field = "rightA")
    private String rightAnswer;

    @Parsed(field = "wrongA1")
    private String wrongA1;

    @Parsed(field = "wrongA2")
    private String wrongA2;

    @Parsed(field = "wrongA3")
    private String wrongA3;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getWrongA1() {
        return wrongA1;
    }

    public String getWrongA2() {
        return wrongA2;
    }

    public String getWrongA3() {
        return wrongA3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(name, question.name) &&
                Objects.equals(rightAnswer, question.rightAnswer) &&
                Objects.equals(wrongA1, question.wrongA1) &&
                Objects.equals(wrongA2, question.wrongA2) &&
                Objects.equals(wrongA3, question.wrongA3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, rightAnswer, wrongA1, wrongA2, wrongA3);
    }
}
