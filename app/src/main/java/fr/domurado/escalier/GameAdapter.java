package fr.domurado.escalier;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.domurado.escalier.model.Game;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private Realm realm;
    private RealmResults<Game> mGames;

    public GameAdapter(Realm realm) {
        this.realm = realm;
        RealmQuery<Game> query = realm.where(Game.class);
        mGames = query.findAll();
        notifyDataSetChanged();
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

    public void removeAt(int itemPosition) {
        realm.beginTransaction();
        Game item = mGames.get(itemPosition);
        item.removeFromRealm();
        realm.commitTransaction();
        notifyItemRemoved(itemPosition);
    }

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
}
