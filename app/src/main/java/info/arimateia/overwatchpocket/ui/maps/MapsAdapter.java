package info.arimateia.overwatchpocket.ui.maps;

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
import info.arimateia.overwatchpocket.vo.Map;

/**
 * Created by felipets on 7/18/17.
 */

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.ViewHolder>{

    private List<Map> items;

    public MapsAdapter(List<Map> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_map, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map map = items.get(position);
        holder.name.setText(map.getName());

        Picasso.with(holder.itemView.getContext()).load(map.getPictures().getPhoto())
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            photo = (ImageView)itemView.findViewById(R.id.pictures);
        }
    }

    public void addAll(List<Map> maps) {
        items.addAll(maps);
        notifyDataSetChanged();
    }
}
