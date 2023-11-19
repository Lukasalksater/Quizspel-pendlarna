package SB;
import java.util.*;

public class QuizLibrarySB {
    List<CategorySB> categoryList = new ArrayList<>();
    
    public void initialiseLibrary() {
        initialiseCategoryGeography();
        initialiseCategoryComputerGames();
    }

    public void initialiseCategoryGeography() {
        CategorySB categoryGeography = new CategorySB("Geografi");
        categoryList.add(categoryGeography);

        QuestionSB q1 = new QuestionSB("Geografi a");
        q1.setAnswers("1.", "2.", "3.", "4.");
        q1.setCorrectAnswer(Collections.binarySearch(q1.getAnswers(), "3."));
        categoryGeography.questionList.add(q1);

        QuestionSB q2 = new QuestionSB("Geografi b");  
        q2.setAnswers("1.", "2.", "3.", "4.");
        q2.setCorrectAnswer(Collections.binarySearch(q2.getAnswers(), "2."));
        categoryGeography.questionList.add(q2);
    }

    public void initialiseCategoryComputerGames() {
        CategorySB categoryComputerGames = new CategorySB("TV-spel");
        categoryList.add(categoryComputerGames);

        QuestionSB q3 = new QuestionSB("TV-spel a");
        q3.setAnswers("1.", "2.", "3.", "4.");
        q3.setCorrectAnswer(Collections.binarySearch(q3.getAnswers(), "1."));
        categoryComputerGames.questionList.add(q3);

        QuestionSB q4 = new QuestionSB("TV-spel b");  
        q4.setAnswers("1.", "2.", "3.", "4.");
        q4.setCorrectAnswer(Collections.binarySearch(q4.getAnswers(), "4."));
        categoryComputerGames.questionList.add(q4);
    }

    public List<CategorySB> getCategoryList() {
        return categoryList;
    }
}
