package com.example.movieproject.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.movieproject.R;
import com.example.movieproject.view.fragment.movieFragment;
import com.example.movieproject.view.fragment.tvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new movieFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activity_main_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_nav_movie:
                selectedFragment = new movieFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_nav_tv:
                selectedFragment = new tvFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_call:
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:082233567819"));
                startActivity(call);
                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_fragmentcontainer,selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}