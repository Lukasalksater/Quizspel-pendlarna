package TheGame;

import java.util.Collections;
import java.util.List;

public class Question {
    private String questionText;
    private List<Answer> options;
    String correctAnswer;
 
    public Question(String questionText, List<Answer> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
   
    public String getQuestionText() {
        return questionText;
    }

    public void shuffleOptions() {
        Collections.shuffle(options);
    }
    
    public List<Answer> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

    

