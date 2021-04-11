package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Profile;

public class MyProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        EditText editTextname = view.findViewById(R.id.editTextName);
        EditText editTextNickname = view.findViewById(R.id.editTextNickname);
        Spinner spinnerGender = view.findViewById(R.id.spinnerGender);


        // Initialize profile view from database contents.
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                             .allowMainThreadQueries()
                             .build();
        Profile profile = db.profileDao().getProfile();
        if (profile != null && profile.name != null) {
            editTextname.setText(profile.name);
            editTextNickname.setText(profile.nickname);
            //spinnerGender.setAdapter(profile.gender);
            // ... set more fields here
        }

        Button save = view.findViewById(R.id.Button_save);
        if (save != null) {
           save.setOnClickListener((View v) -> {
               // Save edited fields to database.
               Profile newProfile = new Profile();
               newProfile.name = editTextname.getText().toString();
               newProfile.nickname = editTextNickname.getText().toString();
               // ... set more fields here
               db.profileDao().delete();            // delete existing profile
               db.profileDao().insert(newProfile);  // insert new profile
           });
        }


        return view;
    }
}
