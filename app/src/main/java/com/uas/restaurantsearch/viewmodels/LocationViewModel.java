package com.uas.restaurantsearch.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

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
