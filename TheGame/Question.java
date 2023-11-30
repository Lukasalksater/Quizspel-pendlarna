package TheGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public  class Question {


     private String questionText;
    private List<String> options;
    private int correctOption;

    
    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }


    
    public String getQuestionText() {
        return questionText;
    }
    
    public List<String> getOptions() {
        return options;
    }
    
    public int getCorrectOption() {
        return correctOption;
    }


 
  
}

    

