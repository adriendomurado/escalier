package fr.domurado.escalier;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.UUID;

import fr.domurado.escalier.dao.GameDao;
import fr.domurado.escalier.model.Game;
import io.realm.Realm;

public class NewGameActivity extends AppCompatActivity {

    public static final String EXTRA_GAME_ID = "fr.domurado.escalier.EXTRA_GAME_ID";
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

        if (id == R.id.action_save) {

            //final GameDao gameDao = new GameDao(NewGameActivity.this);
            EditText player1 = (EditText) findViewById(R.id.editText_player_1);
            EditText player2 = (EditText) findViewById(R.id.editText_player_2);
            EditText player3 = (EditText) findViewById(R.id.editText_player_3);
            String player1_string = player1.getText().toString().trim();
            String player2_string = player2.getText().toString().trim();
            String player3_string = player3.getText().toString().trim();

            if (player1_string.isEmpty()) {
                player1.setError(getString(R.string.error_name_empty));
                return true;
            }
            if (player2_string.isEmpty()) {
                player2.setError(getString(R.string.error_name_empty));
                return true;
            }
            if (player3_string.isEmpty()) {
                player3.setError(getString(R.string.error_name_empty));
                return true;
            }

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();

            Game game = realm.createObject(Game.class);
            String newGameId = UUID.randomUUID().toString();
            game.setGameId(newGameId);
            game.setPlayer1(player1_string);
            game.setPlayer2(player2_string);
            game.setPlayer3(player3_string);

            realm.commitTransaction();

            Log.d(TAG, "New game saved. Id = " + newGameId);
            Intent intent = new Intent(this, RoundActivity.class);
            intent.putExtra(EXTRA_GAME_ID, newGameId);
            startActivity(intent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
