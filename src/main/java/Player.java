/**
 * Created by wscown on 2/1/16.
 */
public class Player {

    private String name;
    private int roundScore;
    private int gameScore;

    Player(String name){
        this.name = name;
        roundScore = 0;
        gameScore = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
}
