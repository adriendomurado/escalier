package fr.domurado.escalier;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.domurado.escalier.model.Game;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game> mGames;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout foreground;
        public TextView players;
        public TextView cardNbs;

        public ViewHolder(View itemView) {
            super(itemView);
            foreground = (LinearLayout) itemView.findViewById(R.id.foreground);
            players = (TextView) itemView.findViewById(R.id.players);
            cardNbs = (TextView) itemView.findViewById(R.id.card_nbs);
        }
    }

    public GameAdapter(List<Game> games) {
        mGames = games;
    }

    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game game = mGames.get(position);
        holder.players.setText(game.getPlayer1() + ", " + game.getPlayer2() + ", " + game.getPlayer3());

        // TODO : decomment when Round management is up
        // Round round = game.getRoundList().last();
        // holder.cardNbs.setText(round.getCardNumber());
        //String arrow;
        //round.isUp() ? arrow = "↗" : arrow = "↘";
        holder.cardNbs.setText("1↗");
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }
}
