package TheGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SelectQuestion {

        private static final Random random = new Random();



     public static List<Question> selectRandomQuestions(List<Question> allQuestions, int numQuestions) {
        List<Question> selectedQuestions = new ArrayList<>();
        
        int totalQuestions = allQuestions.size();
        if (numQuestions > totalQuestions) {
            numQuestions = totalQuestions;
        }
        
        for (int i = 0; i < numQuestions; i++) {
            int randomIndex = random.nextInt(allQuestions.size());
            selectedQuestions.add(allQuestions.get(randomIndex));
            allQuestions.remove(randomIndex);
        }
        
        return selectedQuestions;
    }



    
}
