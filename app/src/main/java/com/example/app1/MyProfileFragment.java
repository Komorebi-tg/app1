package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
        //Spinner spinnerGender = view.findViewById(R.id.spinnerGender);
        EditText editTextGender = view.findViewById(R.id.editTextGender);
        EditText editTextSchoolName = view.findViewById(R.id.editTextSchoolName);
        EditText editTextGrade = view.findViewById(R.id.editTextGrade);
        EditText editTextBirthDate = view.findViewById(R.id.editTextBirthDate);
        EditText editTextFirstChoice = view.findViewById(R.id.editTextFirstChoice);
        EditText editTextSecondChoice = view.findViewById(R.id.editTextSecondChoice);
        EditText editTextThirdChoice = view.findViewById(R.id.editTextThirdChoice);
        EditText editTextInterest1 = view.findViewById(R.id.editTextInterest1);
        EditText editTextInterest2 = view.findViewById(R.id.editTextInterest2);
        EditText editTextInterest3 = view.findViewById(R.id.editTextInterest3);
        EditText editTextInterest4 = view.findViewById(R.id.editTextInterest4);
        EditText editTextEmail = view.findViewById(R.id.editTextEmail);
        EditText editTextphoneNumber = view.findViewById(R.id.editTextPhone);



        // Initialize profile view from database contents.
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                             .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                             .build();
        Profile profile = db.profileDao().getProfile();
        if (profile != null && profile.name != null) {
            editTextname.setText(profile.name);
            editTextNickname.setText(profile.nickname);
            //spinnerGender.getSelectedItem(profile.gender);
            //profile.index_gender = spinnerGender.getSelectedItemPosition();
            //spinnerGender.setSelection(profile.index_gender);
            //profile.gender = spinnerGender.getSelectedItem().toString();
            editTextGender.setText(profile.gender);
            editTextSchoolName.setText(profile.schoolName);
            editTextGrade.setText(profile.grade);
            editTextBirthDate.setText(profile.birthDate);
            editTextFirstChoice.setText(profile.firstChoice);
            editTextSecondChoice.setText(profile.secondChoice);
            editTextThirdChoice.setText(profile.thirdChoice);
            editTextInterest1.setText(profile.interest1);
            editTextInterest2.setText(profile.interest2);
            editTextInterest3.setText(profile.interest3);
            editTextInterest4.setText(profile.interest4);
            editTextEmail.setText(profile.email);
            editTextphoneNumber.setText(profile.phoneNumber);
        }

        Button save = view.findViewById(R.id.Button_save);
        if (save != null) {
           save.setOnClickListener((View v) -> {
               // Save edited fields to database.
               Profile newProfile = new Profile();
               newProfile.name = editTextname.getText().toString();
               newProfile.nickname = editTextNickname.getText().toString();
               //newProfile.gender = spinnerGender.getSelectedItem().toString();
               newProfile.gender = editTextGender.getText().toString();
               newProfile.schoolName = editTextSchoolName.getText().toString();
               newProfile.grade = editTextGrade.getText().toString();
               newProfile.birthDate = editTextBirthDate.getText().toString();
               newProfile.firstChoice = editTextFirstChoice.getText().toString();
               newProfile.secondChoice = editTextSecondChoice.getText().toString();
               newProfile.thirdChoice = editTextThirdChoice.getText().toString();
               newProfile.interest1 = editTextInterest1.getText().toString();
               newProfile.interest2 = editTextInterest2.getText().toString();
               newProfile.interest3 = editTextInterest3.getText().toString();
               newProfile.interest4 = editTextInterest4.getText().toString();
               newProfile.email = editTextEmail.getText().toString();
               newProfile.phoneNumber = editTextphoneNumber.getText().toString();
               db.profileDao().delete();            // delete existing profile
               db.profileDao().insert(newProfile);  // insert new profile
               getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyProfileDisplayFragment()).commit();
           });
        }


        return view;
    }
}
