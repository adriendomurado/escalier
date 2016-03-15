package fr.domurado.escalier.task;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;

import fr.domurado.escalier.database.EscalierOpenHelper;

@Deprecated
public class StartDatabaseTask extends AsyncTask<Context, Void, SQLiteDatabase> {

    @Override
    protected SQLiteDatabase doInBackground(Context... params) {
        EscalierOpenHelper escalierOpenHelper = new EscalierOpenHelper(params[0]);
        return escalierOpenHelper.getWritableDatabase();
    }
}
