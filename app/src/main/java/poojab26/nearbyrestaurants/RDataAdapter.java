package poojab26.nearbyrestaurants;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import poojab26.nearbyrestaurants.Model.R_Details;

/**
 * Created by pblead26 on 21-Apr-17.
 */



public class RDataAdapter extends RecyclerView.Adapter<RDataAdapter.MyViewHolder> {
    private Context context;
    private List<R_Details> restaurantList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, cuisine;
        public ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_name);
            photo = (ImageView) view.findViewById(R.id.tv_photo);
            cuisine = (TextView) view.findViewById(R.id.tv_cuisine);
        }
    }


    public RDataAdapter(Context context, List<R_Details> restaurantList) {
        this.restaurantList = restaurantList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        R_Details r_details = restaurantList.get(position);
        holder.name.setText(r_details.getRName());

        Picasso.with(context).load(r_details.getRPhoto()).into(holder.photo);

       // holder.photo.setText(r_details.getRPhoto());
        holder.cuisine.setText(r_details.getRCuisine());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}