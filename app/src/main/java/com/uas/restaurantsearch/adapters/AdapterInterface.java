package com.uas.restaurantsearch.adapters;

import com.uas.restaurantsearch.entity.Categories;
import com.uas.restaurantsearch.entity.Restaurants;

public interface AdapterInterface {
    void onClick(Restaurants.Restaurant restaurant);
    void onClickSeeAll(Categories.Category category);
}
