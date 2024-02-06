package launchGame.gameSettings.multiplayer;

public class Player {
    private String name;
    private int score = 0;
    private int attempt;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }
    public int getAttempt() {
        return this.attempt;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setAttempts(int attempt) {
        this.attempt = attempt;
    }
}
