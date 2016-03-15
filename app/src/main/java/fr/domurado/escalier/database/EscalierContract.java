package fr.domurado.escalier.database;

import android.provider.BaseColumns;

@Deprecated
/**
 * Replaced by Realm.io
 */
public final class EscalierContract {

    public EscalierContract() {
    }

    public static abstract class Game implements BaseColumns {
        public static final String TABLE_NAME = "Game";
        public static final String COLUMN_NAME_PLAYER_1 = "Player_1";
        public static final String COLUMN_NAME_PLAYER_2 = "Player_2";
        public static final String COLUMN_NAME_PLAYER_3 = "Player_3";
    }

    public static abstract class Round implements BaseColumns {
        public static final String TABLE_NAME = "Round";
        public static final String COLUMN_NAME_GAME_ID = "game_id";
        public static final String COLUMN_NAME_CARDS_NB = "cards_nb";
    }

    public static abstract class Score implements BaseColumns {
        public static final String TABLE_NAME = "Score";
        public static final String COLUMN_NAME_ROUND_ID = "round_id";
        public static final String COLUMN_NAME_PLAYER = "player";
        public static final String COLUMN_NAME_BET = "bet";
        public static final String COLUMN_NAME_SCORE = "score";
    }
}
