package fr.domurado.escalier.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

@Deprecated
/**
 * Replaced by Realm.io
 */
public class EscalierOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Escalier.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + EscalierContract.Game.TABLE_NAME +
            " (" + EscalierContract.Game._ID + " INTEGER PRIMARY KEY," +
            EscalierContract.Game.COLUMN_NAME_PLAYER_1 + " TEXT," +
            EscalierContract.Game.COLUMN_NAME_PLAYER_2 + " TEXT," +
            EscalierContract.Game.COLUMN_NAME_PLAYER_3 + " TEXT" +
            "); " +
            "CREATE TABLE " + EscalierContract.Round.TABLE_NAME +
            " (" + EscalierContract.Round._ID + " INTEGER PRIMARY KEY," +
            EscalierContract.Round.COLUMN_NAME_GAME_ID + " INTEGER," +
            EscalierContract.Round.COLUMN_NAME_CARDS_NB + " INTEGER" +
            "); " +
            "CREATE TABLE " + EscalierContract.Score.TABLE_NAME +
            " (" + EscalierContract.Score._ID + " INTEGER PRIMARY KEY," +
            EscalierContract.Score.COLUMN_NAME_ROUND_ID + " INTEGER," +
            EscalierContract.Score.COLUMN_NAME_PLAYER + " TEXT," +
            EscalierContract.Score.COLUMN_NAME_BET + " INTEGER," +
            EscalierContract.Score.COLUMN_NAME_SCORE + " INTEGER" +
            ");";


    public EscalierOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
