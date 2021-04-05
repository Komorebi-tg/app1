package com.example.app1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// test comment2
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();



        /*settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new SettingsFragment());
                fragmentTransaction.commit();


                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
            }
        });

         */


/*        myProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment selectedFragment = new MyProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            }
        });

 */



/*        mentalHealthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthFragment()).commit();
            }
        });

 */


/*        adviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdviceFragment()).commit();
            }
        });

 */

    }

/*    public void onClickButton1(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
    }

 */

    public void onClickButton1(View view) {
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_settings);
        navListener.onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_settings));
    }

    public void onClickButton2(View view) {
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_my_profile);
        navListener.onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_my_profile));
    }

    public void onClickButton3(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthFragment()).commit();
    }

    public void onClickButton11(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsAccountFragment()).commit();
    }

    public void onClickButton111(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsAccountChangePasswordFragment()).commit();
    }

    public void onClickButton112(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsAccountChangeMailAddressFragment()).commit();
    }

    public void onClickButton1121(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsAccountChangeMailAddressPasswordFragment()).commit();
    }

    public void onClickButton12(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsNotificationFragment()).commit();
    }

    public void onClickButton13(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsPrivacyFragment()).commit();
    }

    public void onClickButton16(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsLogoutFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                        case R.id.nav_mental_health:
                            selectedFragment = new MentalHealthFragment();
                            break;
                        case R.id.nav_my_profile:
                            selectedFragment = new MyProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}