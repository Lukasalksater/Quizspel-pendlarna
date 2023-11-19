package SB;
import java.util.*;

public class TestSB {  
    public static void main(String[] args) {
        QuizLibrarySB quizLibrary = new QuizLibrarySB();
        quizLibrary.initialiseLibrary();

        Scanner scanner = new Scanner(System.in);
        int chosenCategoryNo;
        int correctGuesses = 0;
        Random randomgen = new Random();

        System.out.println("Quiz");
        System.out.println();

        List<CategorySB> categoryList = quizLibrary.getCategoryList();

        System.out.println("Tillgängliga kategorier");
        System.out.println("=======================");
        for (CategorySB cat : categoryList) {
            System.out.println(categoryList.indexOf(cat) + " = " + cat.getCategoryName());
        }
        System.out.println();

        System.out.print("Välj kategori: ");
        chosenCategoryNo = scanner.nextInt();
        System.out.println();

        CategorySB chosenCategory = categoryList.get(chosenCategoryNo);
        List<QuestionSB> questionList = chosenCategory.questionList;
        int howManyQuestions = questionList.size();

        while (questionList.size() > 0) {
            QuestionSB question = questionList.remove(randomgen.nextInt(questionList.size()));
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Answers: " + question.getAnswers());

            int guess = scanner.nextInt();
            int correctAnswer = question.getCorrectAnswer()+1;

            if (guess == correctAnswer) {
                System.out.println("Correct!");
                
                correctGuesses += 1;
            } else {
                System.out.println("Wrong guess, correct guess was " + correctAnswer +"!");
            }

            if (guess >4) {
                System.out.println("To high of a number!");
            }

            if (guess <1) {
                System.out.println("To small of a number");
            }

            System.out.println();
        }

        System.out.println("Du fick " + correctGuesses +" rätt av " + howManyQuestions);

        scanner.close();
    }
}