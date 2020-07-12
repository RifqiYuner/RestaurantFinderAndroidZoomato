package com.uas.restaurantsearch.viewmodelsfactory;

import androidx.paging.DataSource;

import com.uas.restaurantsearch.comp.ProgressBarInterface;
import com.uas.restaurantsearch.entity.Categories;

public class RestaurantsDataSourceFactory extends DataSource.Factory{

    private RestaurantsDataSource feedDataSource;
    private Categories.Category category;
    private long cityId;
    private ProgressBarInterface progressBarInterface;

    public RestaurantsDataSourceFactory(Categories.Category category, long cityId, ProgressBarInterface progressBarInterface)
    {
        this.category = category;
        this.cityId = cityId;
        this.progressBarInterface = progressBarInterface;
    }

    @Override
    public DataSource create() {
        feedDataSource = new RestaurantsDataSource(category, cityId, progressBarInterface);
        return feedDataSource;
    }
}
