package TheGame;

import java.util.Scanner;

public class HighscoreMain {
    public static void ShowHighscore (int totalScore, long totalTime, int numberOfQuestions, Scanner scanner) {
        HighscoreTable highscoreTable = new HighscoreTable(numberOfQuestions);
        highscoreTable.setHighscoreFilePath();

        if (highscoreTable.fetchHighscoresFromFile()) {
            Highscore currentScore = new Highscore(totalScore, totalTime);
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
    }      
}