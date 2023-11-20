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

        QuestionSB q1 = new QuestionSB("Vilket land är känt för att ha de berömda \"Moai\"-statyerna");
        q1.setAnswers("1. Chile", "2. Nya Zeeland", "3. Fiji", "4. Kina");
        q1.setCorrectAnswer(Collections.binarySearch(q1.getAnswers(), "1. Chile"));
        categoryGeography.questionList.add(q1);

        QuestionSB q2 = new QuestionSB("Vilken stad är huvudstad i Australien");  
        q2.setAnswers("1. Sydney", "2. Melbourne", "3. Canberra", "4. Brisbane");
        q2.setCorrectAnswer(Collections.binarySearch(q2.getAnswers(), "3. Canberra"));
        categoryGeography.questionList.add(q2);
    }

    public void initialiseCategoryComputerGames() {
        CategorySB categoryComputerGames = new CategorySB("TV-spel");
        categoryList.add(categoryComputerGames);

        QuestionSB q3 = new QuestionSB("Vilket företag är känt för att ha skapat \"Super Mario Bros.\"");
        q3.setAnswers("1. Sega", "2. Nintendo", "3. Sony", "4. Microsoft");
        q3.setCorrectAnswer(Collections.binarySearch(q3.getAnswers(), "2. Nintendo"));
        categoryComputerGames.questionList.add(q3);

        QuestionSB q4 = new QuestionSB("Vilket populärt onlinespel är utvecklat av Epic Games och har ett Battle Royale-läge");  
        q4.setAnswers("1. Counter-Strike: Global Offensive", "2. League of Legends", "3. Fortnite", "4. Minecraft");
        q4.setCorrectAnswer(Collections.binarySearch(q4.getAnswers(), "3. Fortnite"));
        categoryComputerGames.questionList.add(q4);
    }

    public List<CategorySB> getCategoryList() {
        return categoryList;
    }
}
