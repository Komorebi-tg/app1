package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Profile;

public class MyProfileDisplayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile_display, container, false);

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Profile profile = db.profileDao().getProfile();

        TextView textViewname = view.findViewById(R.id.textViewName);
        TextView textViewNickname = view.findViewById(R.id.textViewNickname);
        TextView textViewGender = view.findViewById(R.id.textViewGender);
        TextView textViewSchoolName = view.findViewById(R.id.textViewSchoolName);
        TextView textViewGrade = view.findViewById(R.id.textViewGrade);
        TextView textViewBirthDate = view.findViewById(R.id.textViewBirthdate);
        TextView textViewFirstChoice = view.findViewById(R.id.textViewFirstChoice);
        TextView textViewSecondChoice = view.findViewById(R.id.textViewSecondChoice);
        TextView textViewThirdChoice = view.findViewById(R.id.textViewThirdChoice);
        TextView textViewInterest1 = view.findViewById(R.id.textViewInterest1);
        TextView textViewInterest2 = view.findViewById(R.id.textViewInterest2);
        TextView textViewInterest3 = view.findViewById(R.id.textViewInterest3);
        TextView textViewInterest4 = view.findViewById(R.id.textViewInterest4);
        TextView textViewMailAddress = view.findViewById(R.id.textViewMailAddress);
        TextView textViewPhoneNumber = view.findViewById(R.id.textViewPhoneNumber);

        textViewname.setText(profile.name);
        textViewNickname.setText(profile.nickname);
        textViewGender.setText(profile.gender);
        textViewSchoolName.setText(profile.schoolName);
        textViewGrade.setText(profile.grade);
        textViewBirthDate.setText(profile.birthDate);
        textViewFirstChoice.setText(profile.firstChoice);
        textViewSecondChoice.setText(profile.secondChoice);
        textViewThirdChoice.setText(profile.thirdChoice);
        textViewInterest1.setText(profile.interest1);
        textViewInterest2.setText(profile.interest2);
        textViewInterest3.setText(profile.interest3);
        textViewInterest4.setText(profile.interest4);
        textViewMailAddress.setText(profile.email);
        textViewPhoneNumber.setText(profile.phoneNumber);

        return view;
    }
}
