import java.util.*;

import Frågor.Question;

public class Test {  
    public static void main(String[] args) {

        int correctGuesses = 0;

        Question q1 = new Question("a");
        Question q2 = new Question("b");

        q1.setAnswers("1.", "2.", "3.", "4.");
        q2.setAnswers("1.", "2.", "3.", "4.");

        q1.setCorrectAnswer(Collections.binarySearch(q1.getAnswers(), "3."));
        q2.setCorrectAnswer(Collections.binarySearch(q2.getAnswers(), "2."));


        Scanner s = new Scanner(System.in);
        Random randomgen = new Random();
        List<Question> questionList = new ArrayList<>();


        
        questionList.add(q1);
        questionList.add(q2);
        int howManyQuestions = questionList.size();

        while(questionList.size() > 0) {
            Question question = questionList.remove(randomgen.nextInt(questionList.size()));
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Answers: " + question.getAnswers());


           int guess = s.nextInt();

       
     


           if (guess == question.getCorrectAnswer()+1) {

           correctGuesses += 1;

            
           }

           if (guess >4) {
            System.out.println("To high of a number!");
           }

           if (guess <1) {
            System.out.println("To small of a number");
           }

           else {

            int correctAnswer = question.getCorrectAnswer()+1;

            System.out.println("Wrong guess, correct guess was " + correctAnswer +"!");
           }
        }

        System.out.println("Du fick " + correctGuesses +" rätt av " + howManyQuestions);
        s.close();
    }


}


class Answer{}