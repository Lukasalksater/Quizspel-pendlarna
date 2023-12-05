package TheGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStart {



    public void StartGame (){
        System.out.println("Valkommen till pendlarnas quiz spel!");
        System.out.println();
        System.out.println("Valj en kategori (1 = Musik, 2 = Spel, 3 = Geografi, 4 = Blandade fragor):");

        Scanner scanner = new Scanner(System.in, "Cp850");
        int categoryChoice = scanner.nextInt();
        
        List<Integer>chosencategoryList = new ArrayList<Integer>();

        if (categoryChoice >= 1 && categoryChoice <= 3) {
            chosencategoryList.add(categoryChoice);
        } else {
            chosencategoryList.add(1);
            chosencategoryList.add(2);
            chosencategoryList.add(3);
        }

        for (int chosenCategory : chosencategoryList) {
            GameSetup.setQuestionsFilePath(chosenCategory);
            GameSetup.fetchQuestionsFromFile(chosenCategory);
        }
        
        Catagory catagory = new Catagory();

        String chosencategoryName = catagory.chooseCatagory(categoryChoice);

        if (catagory.chosenCategoryQuestions.size() > 0) {
            System.out.println("Välj antal fragor att spela (5 eller 10):");
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

                if (currentScore != removedHighscore) {
                    highscoreTable.congratulateOnHighscore();
                    String chosenHighscoreName = highscoreTable.chooseNameForHighscore(scanner);
                    currentScore.setName(chosenHighscoreName);

                    highscoreTable.displayHighscoreTable();
                    highscoreTable.saveHighscoresToFile();
                } else {
                    highscoreTable.displayHighscoreTable();
                }
            }
        }

        scanner.close();


    }
    
}
