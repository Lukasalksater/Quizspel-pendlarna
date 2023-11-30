package TheGame;
import java.util.ArrayList;
import java.util.List;

public class Catagory {

    

      

     List<Question> chosenCategoryQuestions;

    
  



    public void chooseCatagory(int categoryChoice){

        if (categoryChoice == 1) {
            chosenCategoryQuestions = GameSetup.getMusikfrågor();
        } else if (categoryChoice == 2) {
            chosenCategoryQuestions = GameSetup.getSpelfrågor();
        } else if (categoryChoice == 3) {
            chosenCategoryQuestions = GameSetup.getGeografifrågor();
        } else {
            chosenCategoryQuestions = new ArrayList<>();
            chosenCategoryQuestions.addAll(GameSetup.getMusikfrågor());
            chosenCategoryQuestions.addAll(GameSetup.getSpelfrågor());
            chosenCategoryQuestions.addAll(GameSetup.getGeografifrågor());
        }

       
    }
    
}
