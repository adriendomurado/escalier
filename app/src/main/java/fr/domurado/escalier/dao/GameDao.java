package fr.domurado.escalier.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import fr.domurado.escalier.database.EscalierContract;
import fr.domurado.escalier.model.Game;
import fr.domurado.escalier.task.StartDatabaseTask;

public class GameDao {

    private final String TAG = "GameDao";

    private SQLiteDatabase database = null;

    public GameDao(Context context) {
        final StartDatabaseTask startDatabaseTask = new StartDatabaseTask();
        startDatabaseTask.execute(context);
        try {
            database = startDatabaseTask.get();
            Log.d(TAG, "Database started");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public long save(Game game) {
        ContentValues values = new ContentValues();
        values.put(EscalierContract.Game.COLUMN_NAME_PLAYER_1, game.getPlayer1());
        values.put(EscalierContract.Game.COLUMN_NAME_PLAYER_2, game.getPlayer2());
        values.put(EscalierContract.Game.COLUMN_NAME_PLAYER_3, game.getPlayer3());

        long newRowId;
        newRowId = database.insert(EscalierContract.Game.TABLE_NAME, null, values);

        return newRowId;
    }
}
