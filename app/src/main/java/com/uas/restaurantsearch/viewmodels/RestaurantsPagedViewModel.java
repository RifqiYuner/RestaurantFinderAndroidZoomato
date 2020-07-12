package com.uas.restaurantsearch.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;


import com.uas.restaurantsearch.comp.ProgressBarInterface;
import com.uas.restaurantsearch.entity.Categories;
import com.uas.restaurantsearch.entity.Constant;
import com.uas.restaurantsearch.entity.Restaurants;
import com.uas.restaurantsearch.viewmodelsfactory.RestaurantsDataSourceFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RestaurantsPagedViewModel extends ViewModel {

    private Executor executor;
    private LiveData<PagedList<Restaurants>> pagedListLiveData;
    private Categories.Category category;
    private long cityId;
    private ProgressBarInterface progressBarInterface;

    public RestaurantsPagedViewModel(Categories.Category category, long cityId, ProgressBarInterface progressBarInterface)
    {
        this.category = category;
        this.cityId = cityId;
        this.progressBarInterface = progressBarInterface;
        init();
    }

    private void init()
    {
        executor = Executors.newFixedThreadPool(5);

        RestaurantsDataSourceFactory restaurantsDataSourceFactory = new RestaurantsDataSourceFactory(category, cityId, progressBarInterface);

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(Constant.LOAD_ITEM_COUNT)
                        .setPageSize(Constant.LOAD_PAGE_SIZE).build();

        pagedListLiveData = (new LivePagedListBuilder(restaurantsDataSourceFactory, pagedListConfig))
                .setFetchExecutor(executor)
                .build();
    }

    public LiveData<PagedList<Restaurants>> getRestaurantLiveData()
    {
        return pagedListLiveData;
    }

}
