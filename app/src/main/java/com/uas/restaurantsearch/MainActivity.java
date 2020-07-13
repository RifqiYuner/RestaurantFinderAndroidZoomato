package com.uas.restaurantsearch;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.uas.restaurantsearch.fragments.DetailPageFragment;
import com.uas.restaurantsearch.fragments.HomePageFragment;
import com.uas.restaurantsearch.fragments.RestaurantListFragment;

public class MainActivity extends AppCompatActivity {

    public static final int FRAGMENT_HOME = 101;
    public static final int FRAGMENT_DETAIL = 102;
    public static final int FRAGMENT_LIST = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null)
            switchFragments(FRAGMENT_HOME, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void switchFragments(int code, Intent intent)
    {
        FragmentTransaction ft;
        Log.d("fatal", "switchFragments");

        switch (code)
        {
            case FRAGMENT_HOME:
                HomePageFragment homePageFragment = new HomePageFragment();
                if(intent !=null && intent.getExtras() != null)
                    homePageFragment.setArguments(intent.getExtras());

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, homePageFragment, HomePageFragment.TAG).commit();
                break;

            case FRAGMENT_DETAIL:
                DetailPageFragment detailPageFragment = new DetailPageFragment();
                if(intent !=null && intent.getExtras() != null)
                    detailPageFragment.setArguments(intent.getExtras());

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, detailPageFragment, DetailPageFragment.TAG).addToBackStack(null).commit();
                break;

            case FRAGMENT_LIST:
                RestaurantListFragment restaurantListFragment = new RestaurantListFragment();
                if(intent !=null && intent.getExtras() != null)
                    restaurantListFragment.setArguments(intent.getExtras());

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, restaurantListFragment, RestaurantListFragment.TAG).addToBackStack(null).commit();
                break;
        }
    }
}
