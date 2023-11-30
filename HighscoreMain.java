public class HighscoreMain {
    public static void main(String[] args) {
        int totalScore = 140;
        int totalTime = 51;
        int numberOfQuestions = 10;

        HighscoreTable highscoreTable = new HighscoreTable(numberOfQuestions);

        highscoreTable.setHighscoreFilePath();
        highscoreTable.fetchHighscoresFromFile();

        Highscore currentScore = new Highscore(totalScore, totalTime);
        highscoreTable.addCurrentScoreToList(currentScore);
        highscoreTable.sortHighscoresByPointsThenTime();
        Highscore removedHighscore = highscoreTable.removeWorstHighscoreFromList();

        if (currentScore.equals(removedHighscore) == false) {
            highscoreTable.congratulateOnHighscore();
            String chosenHighscoreName = highscoreTable.chooseNameForHighscore();
            System.out.println(chosenHighscoreName);
            currentScore.setName(chosenHighscoreName);

            highscoreTable.displayHighscoreTable();
            highscoreTable.saveHighscoresToFile();
        } else {
            highscoreTable.displayHighscoreTable();
        }
    }      
}