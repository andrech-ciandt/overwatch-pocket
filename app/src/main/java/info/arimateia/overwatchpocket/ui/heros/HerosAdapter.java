package info.arimateia.overwatchpocket.ui.heros;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import info.arimateia.overwatchpocket.R;
import info.arimateia.overwatchpocket.vo.Hero;

/**
 * Created by felipets on 7/18/17.
 */

public class HerosAdapter extends RecyclerView.Adapter<HerosAdapter.ViewHolder>{

    private List<Hero> items;

    public HerosAdapter(List<Hero> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hero hero = items.get(position);
        holder.name.setText(hero.getName());
        holder.description.setText(hero.getDescription());

        Picasso.with(holder.itemView.getContext()).load(hero.getPictures().getPhoto())
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            photo = (ImageView)itemView.findViewById(R.id.pictures);
        }
    }

    public void addAll(List<Hero> heros) {
        items.addAll(heros);
        notifyDataSetChanged();
    }
}
