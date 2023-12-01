package TheGame;
import java.util.ArrayList;
import java.util.List;

public class Catagory {
    List<Question> chosenCategoryQuestions;
    String chosencategoryName;

    public String chooseCatagory(int categoryChoice){

        if (categoryChoice == 1) {
            chosenCategoryQuestions = GameSetup.getMusikfrågor();
            chosencategoryName = "musik";
        } else if (categoryChoice == 2) {
            chosenCategoryQuestions = GameSetup.getSpelfrågor();
            chosencategoryName = "spel";
        } else if (categoryChoice == 3) {
            chosenCategoryQuestions = GameSetup.getGeografifrågor();
            chosencategoryName = "geografi";
        } else {
            chosenCategoryQuestions = new ArrayList<>();
            chosenCategoryQuestions.addAll(GameSetup.getMusikfrågor());
            chosenCategoryQuestions.addAll(GameSetup.getSpelfrågor());
            chosenCategoryQuestions.addAll(GameSetup.getGeografifrågor());

            chosencategoryName = "blandade frågor";
        }

        return chosencategoryName;
    }
}
