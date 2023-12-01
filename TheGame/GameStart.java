package TheGame;
import java.util.List;
import java.util.Scanner;

public class GameStart {



    public void StartGame (){

        GameSetup.initializeQuestions();
        
        System.out.println("Valkommen till pendlarnas quiz spel!");
        System.out.println();
        System.out.println("Valj en kategori (1 = Musik, 2 = Spel, 3 = Geografi, 4 = Blandade fragor):");

        Scanner scanner = new Scanner(System.in, "Cp850");
        int categoryChoice = scanner.nextInt();
        
        Catagory catagory = new Catagory();

        String chosencategoryName = catagory.chooseCatagory(categoryChoice);
      
        
        System.out.println("Välj antal fragor att spela (2 eller 5):");
        int numQuestions = scanner.nextInt();
        System.out.println();
      
        
        List<Question> selectedQuestions = SelectQuestion.selectRandomQuestions(catagory.chosenCategoryQuestions, numQuestions);

        TimerSetup timerSetup = new TimerSetup();
        timerSetup.runTimer(selectedQuestions, scanner);

        HighscoreTable highscoreTable = new HighscoreTable(numQuestions, chosencategoryName);
        highscoreTable.setHighscoreFilePath();

        if (highscoreTable.fetchHighscoresFromFile()) {
            Highscore currentScore = new Highscore(timerSetup.getScore(), timerSetup.getTotalTime());
            highscoreTable.addCurrentScoreToList(currentScore);
            
            highscoreTable.sortHighscoresByPointsThenTime();
            Highscore removedHighscore = highscoreTable.removeWorstHighscoreFromList();

            if (currentScore.equals(removedHighscore) == false) {
                highscoreTable.congratulateOnHighscore();
                String chosenHighscoreName = highscoreTable.chooseNameForHighscore(scanner);
                currentScore.setName(chosenHighscoreName);

                highscoreTable.displayHighscoreTable();
                highscoreTable.saveHighscoresToFile();
            } else {
                highscoreTable.displayHighscoreTable();
            }
        }

        scanner.close();


    }
    
}
