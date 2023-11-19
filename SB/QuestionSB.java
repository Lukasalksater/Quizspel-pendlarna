package SB;
import java.util.*;

public class QuestionSB {
    List<String> answers = new ArrayList<>();
    public List<String> getAnswers() {
        return answers;
    }

    String question;
    int correctAnswer;

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionSB(String question) {
        this.question = question;
    }

    public void setAnswers(String alternativ1, String alternativ2, String alternativ3, String alternativ4){

        answers.add(alternativ1);
        answers.add(alternativ2);
        answers.add(alternativ3);
        answers.add(alternativ4);

        
    }

}