package TheGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleAnswers {

         public static List<String> shuffleOptions(List<String> options) {
    List<String> shuffledOptions = new ArrayList<>(options);
    Collections.shuffle(shuffledOptions);
    return shuffledOptions;
    }
    
}
