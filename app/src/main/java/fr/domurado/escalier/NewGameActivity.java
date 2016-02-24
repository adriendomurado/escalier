package fr.domurado.escalier;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import fr.domurado.escalier.dao.GameDao;
import fr.domurado.escalier.model.Game;
import fr.domurado.escalier.task.StartDatabaseTask;

public class NewGameActivity extends AppCompatActivity {

    private static String TAG = "NewGameActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.newgame_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            final GameDao gameDao = new GameDao(NewGameActivity.this);
            EditText player1 = (EditText) findViewById(R.id.editText_player_1);
            EditText player2 = (EditText) findViewById(R.id.editText_player_2);
            EditText player3 = (EditText) findViewById(R.id.editText_player_3);

            final Game game = new Game(player1.getText().toString(), player2.getText().toString(), player3.getText().toString());
            long newGameId = gameDao.save(game);
            Snackbar.make(findViewById(R.id.newgame_toolbar), "New game saved. Id = " + newGameId, Snackbar.LENGTH_LONG).show();
            // TODO : start the next activity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
