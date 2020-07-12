package com.uas.restaurantsearch.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.uas.restaurantsearch.entity.Categories;
import com.uas.restaurantsearch.networks.APIRepo;

import java.util.List;

public class CategoryViewModel extends ViewModel{

    private LiveData<List<Categories>> categories;
    private APIRepo apiRepo;

    public CategoryViewModel()
    {
        apiRepo = new APIRepo();
        categories = getCategoryFromAPI();
    }

    public LiveData<List<Categories>> getCategories() {
        return categories;
    }

    public LiveData<List<Categories>> getCategoryFromAPI()
    {
        return apiRepo.getCategoryFromAPI();
    }

}
