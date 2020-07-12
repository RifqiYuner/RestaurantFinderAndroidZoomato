package com.uas.restaurantsearch.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.uas.restaurantsearch.entity.Restaurants;
import com.uas.restaurantsearch.networks.APIRepo;

import java.util.List;

import static com.uas.restaurantsearch.entity.Constant.ROW_COUNT;
import static com.uas.restaurantsearch.entity.Constant.TYPE_CITY;

public class RestaurantsViewModel extends ViewModel {

    private LiveData<List<Restaurants>> restaurantList;
    private APIRepo apiRepo;

    public RestaurantsViewModel() {
        apiRepo = new APIRepo();
    }

    public LiveData<List<Restaurants>> getRestaurantListFromApi(long cityId, long categoryId,int start) {
        return apiRepo.getRestaurantsFromAPI(cityId, TYPE_CITY, start, ROW_COUNT, categoryId);
    }



}
