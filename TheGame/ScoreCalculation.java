package TheGame;
public class ScoreCalculation {

    private static final int MAX_POINTS = 30;
    private static final int MIN_POINTS = 0;
    private static final int TIME_PENALTY = 1;


    public static int calculateScore(long elapsedTime) {
        if (elapsedTime < 8000) {
     return MAX_POINTS;
 } else {
     int questionScore = MAX_POINTS - (int) elapsedTime - TIME_PENALTY;
     if (questionScore < MIN_POINTS) {
         questionScore = MIN_POINTS;
     }
     return questionScore;
 }
}
}
