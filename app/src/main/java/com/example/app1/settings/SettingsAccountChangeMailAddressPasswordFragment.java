package com.example.app1.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.R;
import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Profile;

public class SettingsAccountChangeMailAddressPasswordFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_account_change_mail_address_password, container, false);
        Button change = view.findViewById(R.id.button_settings_account_change_mail_address_do);
        TextView textViewma = view.findViewById(R.id.editTextPassword);
        TextView message = view.findViewById(R.id.textView21);

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Profile profile = db.profileDao().getProfile();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = textViewma.getText().toString();
                Profile newProfile = db.profileDao().getProfile();
                newProfile.email = ma;
                db.profileDao().delete();
                db.profileDao().insert(newProfile);
                message.setText("Mail Address has been changed successfully");

            }
        });

        return view;
    }
}

/* if (ma == profile.email) {
                    // Does the below changes every Profile data or just the password?
                    Profile newProfile = new Profile();
                    //newProfile.email = email;
                    db.profileDao().insert(newProfile);  // insert new profile
                    message.setText("Mail Address has been changed successfully");
                } else {
                    message.setText("Incorrect");
                }
                 */