package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// test comment2
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNavigation;

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private SettingFragment settingsFragment;
    private MyProfileFragment myProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        settingsFragment = new SettingFragment();
        myProfileFragment = new MyProfileFragment();


        mMainNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home :
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.navigation_search :
                        Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent1);
                        return true;

                    case R.id.navigation_settings :
                        Intent intent2 = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent2);
                        return true;

                    case R.id.navigation_my_profile:
                        Intent intent3 = new Intent(MainActivity.this, MyProfileActivity.class);
                        startActivity(intent3);
                        return true;

                    default:
                        return false;
                }
            }

            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.commit();
            }
        });

    }
}