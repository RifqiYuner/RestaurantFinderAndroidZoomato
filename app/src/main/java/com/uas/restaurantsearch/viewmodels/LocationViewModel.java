package com.uas.restaurantsearch.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.uas.restaurantsearch.entity.Location;
import com.uas.restaurantsearch.networks.APIRepo;

import java.util.List;

public class LocationViewModel extends ViewModel{

    public LocationViewModel(){}

    public LiveData<List<Location>> getLocationSuggestionsFromApi(String query)
    {
        APIRepo apiRepo = new APIRepo();
        return apiRepo.getLocationSuggestions(query);
    }

}
