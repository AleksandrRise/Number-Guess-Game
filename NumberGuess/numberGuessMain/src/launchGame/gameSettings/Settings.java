package launchGame.gameSettings;

import java.util.Random;

public class Settings {
    Random rand = new Random();

    private int maxNum;
    private int maxNumAttempts;
    private int randomNum;

    public void setMaxNum(int num) {
        maxNum = num;
    }
    public int getMaxNum() {
        return maxNum;
    }
    public void setMaxNumAttempts(int num) {
        maxNumAttempts = num;
    }
    public int getMaxNumAttempts() {
        return maxNumAttempts;
    }
    public void setRandomNum(int maxNumber) {
        randomNum = rand.nextInt(maxNumber);
    }
    public int getRandomNum() {
        return randomNum;
    }
}
