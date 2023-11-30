import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class HighscoreTable {
    int numberOfQuestions;
    private List<Highscore> highscoreList = new ArrayList<>();
    private File HighscoreFile;
    private final int HIGHSCORE_NAME_CHARACTER_LIMIT = 10;

    public HighscoreTable(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public void setHighscoreFilePath() {
        HighscoreFile = new File("Quizspel-pendlarna/Highscores/" + numberOfQuestions + "_questions_highscore.txt");
    }
    
    public void fetchHighscoresFromFile() {
        try {
            Scanner fileReader = new Scanner(HighscoreFile);
      
            while (fileReader.hasNextLine()) {
                String fileLine = fileReader.nextLine();
                String[] fileLineArray = fileLine.split(",", 3);

                Highscore highscore = new Highscore(fileLineArray[0], Integer.parseInt(fileLineArray[1]), Integer.parseInt(fileLineArray[2]));
                highscoreList.add(highscore);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Filen med highscore-listan kunde inte hittas.");
        }
    }

    public void addCurrentScoreToList(Highscore highscore) {
        highscoreList.add(highscore);
    }    

    public Comparator<Highscore> createHighscoreComparator() {
        return Comparator.comparing(Highscore::getPoints, (int1, int2) -> int2-int1).thenComparing(Highscore::getTime);
    }

    public void sortHighscoresByPointsThenTime() {
        Collections.sort(highscoreList, createHighscoreComparator());
    }

    public Highscore removeWorstHighscoreFromList() {
        int lastItemIndex = highscoreList.size() - 1;

        Highscore removed = highscoreList.get(lastItemIndex);
        highscoreList.remove(lastItemIndex);

        return removed;
    }

    public void congratulateOnHighscore() {
        System.out.println("Bra jobbat! Ditt resultat kom in på highscore-listan!");
        System.out.println();
    }

    public String chooseNameForHighscore() {
        Scanner scanner = new Scanner(System.in, "Cp850");
        System.out.print("Skriv in ditt namn (max 10 tecken): ");
        String chosenHighscoreName = scanner.nextLine();
        System.out.println();

        if (chosenHighscoreName.length() > HIGHSCORE_NAME_CHARACTER_LIMIT) {
            chosenHighscoreName = chosenHighscoreName.substring(0, HIGHSCORE_NAME_CHARACTER_LIMIT);
        }

        scanner.close();

        return chosenHighscoreName;
    }

    public void displayHighscoreTable() {
        System.out.println("Highscores (" + numberOfQuestions + " frågor)");
        System.out.println();
        System.out.println(String.format("%7s %13s %3s" , "Namn", "Poäng", "Tid"));
        System.out.println("---------------------------");

        int i = 1;
        for (Highscore highscore : highscoreList) {
            System.out.println(String.format(i + ". %-12s %-5s %-4s" , highscore.getName(), highscore.getPoints(), highscore.getTime()));
            i++;
        }

        System.out.println();
    }

    public void saveHighscoresToFile() {
        try {
            FileWriter fileWriter = new FileWriter(HighscoreFile, false);
            
            for (Highscore highscore : highscoreList) {
                fileWriter.write(highscore.getName() + "," + highscore.getPoints() + "," + highscore.getTime() + System.lineSeparator());
            }
 
            fileWriter.close();
        } catch (Exception e) { 
            System.out.println("Kunde inte spara highscore-listan i en fil.");
        } 
    }
}
