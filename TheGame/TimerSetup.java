package TheGame;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;


public class TimerSetup {
    private static final int QUESTION_TIME_LIMIT = 30;

    
   
    
    
    private int score;
    public int getScore() {
        return score;
    }







    private int correctAnswers;
    public int getCorrectAnswers() {
        return correctAnswers;
    }




 




    private long totalTime;

     public long getTotalTime() {
        return totalTime;
    }


 




    public void runTimer( List<Question> selectedQuestions, Scanner scanner){

        score = 0;
        correctAnswers = 0;
       totalTime = 0;
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                QuestionSwitch.switchToNextQuestion();
            }
        };
        timer.schedule(task, QUESTION_TIME_LIMIT * 1000);
        
        for (int i = 0; i < selectedQuestions.size(); i++) {
            Question question = selectedQuestions.get(i);
            
            System.out.println("Fråga " + (i + 1) + ":");
            System.out.println(question.getQuestionText());
            
            question.shuffleOptions();
            List<Answer> shuffledOptions = question.getOptions();

            for (int f = 0; f < shuffledOptions.size(); f++) {
                System.out.println((f + 1) + ". " + shuffledOptions.get(f).getAnswerText());
            }
            
            long startTime = System.currentTimeMillis();
           
            int answer = scanner.nextInt();
            long endTime = System.currentTimeMillis();
            
            timer.cancel(); 

            
            
            long elapsedTime = (endTime - startTime) / 1000;
            totalTime += elapsedTime;

            
            
            if (question.getOptions().get(answer - 1) instanceof CorrectAnswer) {
                int questionScore = ScoreCalculation.calculateScore(elapsedTime);
                score += questionScore;
                correctAnswers++;
                
                System.out.println("Rätt svar! Du fick " + questionScore + " poäng.");
            } else {
                System.out.println("Fel svar! Rätt svar är " + question.getCorrectAnswer() + ".");
            }
            
            System.out.println();
            timer = new Timer();
            task = new TimerTask() {
                public void run() {
                    QuestionSwitch.switchToNextQuestion();
                }
            };
            timer.schedule(task, QUESTION_TIME_LIMIT * 1000); 


        }
        
        timer.cancel(); 
        
        
        System.out.println("Spelet är slut!");
        System.out.println();
        System.out.println("Poäng: " + score);
        System.out.println("Antal rätt: " + correctAnswers);
        System.out.println("Total tid: " + totalTime + " sekunder");
        System.out.println();
    }
     }
    

