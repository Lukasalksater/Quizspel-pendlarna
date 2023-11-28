public class Highscore {
    String name;
    int points;
    int time;

    public Highscore(String name, int points, int time) {
        this.name = name;
        this.points = points;
        this.time = time;
    }

    public Highscore(int points, int time) {
        this("X", points, time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public int getTime() {
        return time;
    }
}
