package com.uas.restaurantsearch.viewmodelsfactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;

import com.uas.restaurantsearch.viewmodels.RestaurantsViewModel;

public class RestaurantsViewModelFactory implements ViewModelProvider.Factory{

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RestaurantsViewModel();
    }
}
