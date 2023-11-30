package TheGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HighscoreTable {
    int numberOfQuestions;
    private List<Highscore> highscoreList = new ArrayList<>();
    private File HighscoreFile;
    private static final int HIGHSCORE_NAME_CHARACTER_LIMIT = 10;

    public HighscoreTable(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public void setHighscoreFilePath() {
        HighscoreFile = new File("Quizspel-pendlarna/TheGame/Highscores/" + numberOfQuestions + "_questions_highscore.txt");
    }

    public boolean fetchHighscoresFromFile() {
        boolean fileReadingCompleted = false;
        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(HighscoreFile));
      
            String fileLine;
		    while ((fileLine = fileReader.readLine()) != null) {
                String[] fileLineArray = fileLine.split(",", 3);

                Highscore highscore = new Highscore(fileLineArray[0], Integer.parseInt(fileLineArray[1]), Integer.parseInt(fileLineArray[2]));
                highscoreList.add(highscore);
		    }

            fileReadingCompleted = true;    
        } catch (FileNotFoundException e) {
            System.out.println("Filen med highscore-listan kunde inte hittas.");
        } catch (IOException e) {
            System.out.println("Det gick inte att läsa in highscore-listan.");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Läsningen av filen kunde inte avslutas korrekt.");
                }
            }
        }

        return fileReadingCompleted;
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

    public String chooseNameForHighscore(Scanner scanner) {
        System.out.print("Skriv in ditt namn (max 10 tecken): ");
        scanner.nextLine();
        String chosenHighscoreName = scanner.nextLine();
        
        System.out.println();

        if (chosenHighscoreName.length() > HIGHSCORE_NAME_CHARACTER_LIMIT) {
            chosenHighscoreName = chosenHighscoreName.substring(0, HIGHSCORE_NAME_CHARACTER_LIMIT);
        }

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
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(HighscoreFile, false);

            for (Highscore highscore : highscoreList) {
                fileWriter.write(highscore.getName() + "," + highscore.getPoints() + "," + highscore.getTime() + System.lineSeparator());
            }
   
        } catch (IOException e) { 
            System.out.println("Kunde inte spara highscore-listan i en fil.");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Skrivning till fil kunde inte avslutas korrekt.");
                }
            }
        }
    }
}
