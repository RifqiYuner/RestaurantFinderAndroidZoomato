package com.uas.restaurantsearch.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uas.restaurantsearch.R;
import com.uas.restaurantsearch.entity.Restaurants;
import com.uas.restaurantsearch.entity.Utility;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestaurantsAdapterTwo extends RecyclerView.Adapter<RestaurantsAdapterTwo.RestaurantHolder>{

    List<Restaurants> restaurants;
    AdapterInterface mInterface;
    Context context;

    public RestaurantsAdapterTwo(List<Restaurants> restaurants, AdapterInterface mInterface)
    {
        this.restaurants = restaurants;
        this.mInterface = mInterface;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cost_for_two, viewGroup, false);
            return new RestaurantHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder holder, int i) {
        Restaurants.Restaurant restaurant = restaurants.get(i).getRestaurant();

        holder.textView.setText(restaurant.getName());
        if(Utility.isValidStr(restaurant.getThumb()))
            Picasso.get().load(restaurant.getThumb()).placeholder(R.drawable.ic_restaurant_black_24dp).into(holder.imageView);
        holder.price.setText(context.getString(R.string.price_for_two, restaurant.getCurrency(),restaurant.getAverage_cost_for_two()));

        holder.mView.setTag(restaurant);
        holder.mView.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


    public class RestaurantHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView price;
        View mView;

        public RestaurantHolder(View view)
        {
            super(view);
            imageView = view.findViewById(R.id.image);
            textView = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            mView = view;
        }
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Restaurants.Restaurant restaurant = (Restaurants.Restaurant) view.getTag();
            mInterface.onClick(restaurant);
        }
    };

}
