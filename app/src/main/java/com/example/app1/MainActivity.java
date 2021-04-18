package com.example.app1;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Profile;
import com.example.app1.settings.SettingsAccountChangeMailAddressFragment;
import com.example.app1.settings.SettingsAccountChangeMailAddressPasswordFragment;
import com.example.app1.settings.SettingsAccountChangePasswordFragment;
import com.example.app1.settings.SettingsAccountFragment;
import com.example.app1.settings.SettingsFragment;
import com.example.app1.settings.SettingsLogoutFragment;
import com.example.app1.settings.SettingsNotificationFragment;
import com.example.app1.settings.SettingsPrivacyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// test comment2
public class MainActivity extends AppCompatActivity {
    //TextView tvDate;
    //Button btPickDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Profile profile = db.profileDao().getProfile();

        if (profile != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyProfileFragment()).commit();
        }

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    public void onClickButton1(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUniversitiesFragment()).commit();
    }

    public void onClickButton21(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UniversityOfTokyoEngineeringFragment()).commit();
    }

    public void onClickButton22(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUniversitiesCreatePostFragment()).commit();
    }

    public void onClickButton23(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UniversitySavedFragment()).commit();
    }

    public void onClickButton24(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UniversityHikakuFragment()).commit();
    }

    public void onClickButton0(View view) {
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_my_profile);
        navListener.onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_my_profile));
    }

    public void onClickButton01(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyProfileFragment()).commit();
    }

    public void onClickButton3(View view) {
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_mental_health);
        navListener.onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_mental_health));
    }

    public void onClickButton32(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthCreatePostFragment()).commit();
    }

    public void onClickButton31(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthExample1Fragment()).commit();
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

    public void onClickButton2(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScholarshipFragment()).commit();
    }

    public void onClickButton222(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScholarshipCreatePostFragment()).commit();
    }

    public void onClickButton2221(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScholarshipsexampleFragment()).commit();
    }

    public void onClickButton2222(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Scholarshipsexample2Fragment()).commit();
    }

    public void onClickButton4(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityFragment()).commit();
    }

    public void onClickButton41(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivitiesCreatePostFragment()).commit();
    }

    public void onClickButton42(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivityExampleFragment()).commit();
    }

    public void onClickButton9(View view) {
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.nav_settings);
        navListener.onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_settings));
    }

    public void onClickButton5(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UniversitySavedFragment()).commit();
    }

    public void onClickButton6(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScholarshipSavedFragment()).commit();
    }

    public void onClickButton7(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthSavedFragment()).commit();
    }

    public void onClickButton8(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ActivitySavedFragment()).commit();
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


//tvDate = findViewById(R.id.myProfileDateDisplayBirthDate);
//btPickDate = findViewById(R.id.birthDatePickerButton);
//btPickDate.setOnClickListener(new View.OnClickListener() {
            /*@Override
            public void onClick(View v) {
                com.example.app1.DatePicker mDatePickerDialogFragment;
                mDatePickerDialogFragment = new com.example.app1.DatePicker();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
            }
        });
             */

        /*public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar mCalendar = Calendar.getInstance();
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
            tvDate.setText(selectedDate);
        }
         */