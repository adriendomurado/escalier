package fr.domurado.escalier.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a round in a game
 */
public class Round {

    private int roundId;

    private int gameId;

    /**
     * key : player
     * value : bet of player for this round
     */
    private Map<String, Integer> bet = new HashMap<>(3);

    /**
     * key : player
     * value : score du round
     */
    private Map<String, Integer> score = new HashMap<>(3);

    public Round() {
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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
}
