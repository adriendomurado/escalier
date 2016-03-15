package fr.domurado.escalier.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Represents the score of a player on a round
 */
public class Score extends RealmObject {

    @PrimaryKey
    private String scoreId;

    private Round round;

    private String player;

    private int bet;

    private int score;

    public Score() {
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
