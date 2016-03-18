package fr.domurado.escalier.model;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Class representing a round in a game
 */
@RealmClass
public class Round extends RealmObject {

    @PrimaryKey
    private String roundId;

    private Game game;

    private int cardNumber;

    private boolean up;

    /**
     * key : player
     * value : bet of player for this round
     */
    @Ignore
    private Map<String, Integer> bet = new HashMap<>(3);

    /**
     * key : player
     * value : score du round
     */
    @Ignore
    private Map<String, Integer> score = new HashMap<>(3);

    public Round() {
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Map<String, Integer> getBet() {
        return bet;
    }

    public void setBet(Map<String, Integer> bet) {
        this.bet = bet;
    }

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
