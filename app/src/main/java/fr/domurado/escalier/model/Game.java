package fr.domurado.escalier.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Class representing a game of Escalier
 */
public class Game extends RealmObject {

    @PrimaryKey
    private String gameId;

    private String player1;

    private String player2;

    private String player3;

    private RealmList<Round> roundList;

    public Game() {
    }

    public Game(String player1, String player2, String player3) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public RealmList<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(RealmList<Round> roundList) {
        this.roundList = roundList;
    }
}
