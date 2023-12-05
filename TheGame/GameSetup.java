package TheGame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameSetup {
    private static File HighscoreFile;
    private static String fileName;

    private static final List<Question> Musikfrågor = new ArrayList<>();
    public static List<Question> getMusikfrågor() {
        return Musikfrågor;
    }


    private static final List<Question> Spelfrågor = new ArrayList<>();
    public static List<Question> getSpelfrågor() {
        return Spelfrågor;
    }


    private static final List<Question> Geografifrågor = new ArrayList<>();


      public static List<Question> getGeografifrågor() {
        return Geografifrågor;
    }

    public static void setQuestionsFilePath(int categoryNumber) {
        String directory = "Quizspel-pendlarna/TheGame/Questions/";
        fileName = "questions_category" + categoryNumber + ".txt";
      
        HighscoreFile = new File(directory + fileName);
    }

    public static void fetchQuestionsFromFile(int categoryNumber) {
        BufferedReader fileReader = null;
        
        try {
            fileReader = new BufferedReader(new FileReader(HighscoreFile));
      
            String fileLine;
                     
            while ((fileLine = fileReader.readLine()) != null) {
                String[] fileLineArray = fileLine.split("@", 5);

                List<Answer> answerList = new ArrayList<>();
                
                answerList.add(new Answer(fileLineArray[1]));
                answerList.add(new Answer(fileLineArray[2]));
                answerList.add(new Answer(fileLineArray[3]));
                answerList.add(new CorrectAnswer(fileLineArray[4]));
                
                Question question = new Question(fileLineArray[0], answerList, fileLineArray[4]);

                if (categoryNumber == 1) {
                    Musikfrågor.add(question);
                } else if (categoryNumber == 2) {
                    Spelfrågor.add(question);
                } else if (categoryNumber == 3) {
                    Geografifrågor.add(question);
                }
            }   
        } catch (FileNotFoundException e) {
            System.out.println("Filen " + fileName + " kunde inte hittas.");
        } catch (IOException e) {
            System.out.println("Det gick inte att läsa in frågorna.");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Läsningen av filen kunde inte avslutas korrekt.");
                }
            }
        }
    }
}
