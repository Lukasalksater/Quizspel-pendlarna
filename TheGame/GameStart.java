package TheGame;
import java.util.List;
import java.util.Scanner;

public class GameStart {



    public void StartGame (){

        GameSetup.initializeQuestions();
        
        System.out.println("Valkommen till pendlarnas quiz spel!");
        System.out.println("Valj en kategori (1= Musik, 2=Spel,3=Geografi,4=Blandade fragor):");

        Scanner scanner = new Scanner(System.in);
        int categoryChoice = scanner.nextInt();
        
      Catagory catagory = new Catagory();

      catagory.chooseCatagory(categoryChoice);

      
        
        System.out.println("Valj antal fragor att spela (2 eller 5):");
        int numQuestions = scanner.nextInt();

      
        
        List<Question> selectedQuestions = SelectQuestion.selectRandomQuestions(catagory.chosenCategoryQuestions, numQuestions);

        TimerSetup timerSetup = new TimerSetup();
        timerSetup.runTimer(selectedQuestions);

       

        HighscoreMain.ShowHighscore(timerSetup.getScore(), timerSetup.getTotalTime(), numQuestions);

        scanner.close();


    }
    
}
