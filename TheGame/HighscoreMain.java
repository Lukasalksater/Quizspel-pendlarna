package TheGame;

public class HighscoreMain {
    public static void ShowHighscore (int totalScore, long totalTime, int numberOfQuestions) {
        HighscoreTable highscoreTable = new HighscoreTable(numberOfQuestions);
        highscoreTable.setHighscoreFilePath();

        if (highscoreTable.fetchHighscoresFromFile()) {
            Highscore currentScore = new Highscore(totalScore, totalTime);
            highscoreTable.addCurrentScoreToList(currentScore);
            
            highscoreTable.sortHighscoresByPointsThenTime();
            Highscore removedHighscore = highscoreTable.removeWorstHighscoreFromList();

            if (currentScore.equals(removedHighscore) == false) {
                highscoreTable.congratulateOnHighscore();
                String chosenHighscoreName = highscoreTable.chooseNameForHighscore();
                currentScore.setName(chosenHighscoreName);

                highscoreTable.displayHighscoreTable();
                highscoreTable.saveHighscoresToFile();
            } else {
                highscoreTable.displayHighscoreTable();
            }
        }
    }      
}