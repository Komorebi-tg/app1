package com.example.app1.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.R;
import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Profile;

public class SettingsAccountChangePasswordFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_account_change_password, container, false);
        Button change = view.findViewById(R.id.button_settings_account_change_password_change);
        EditText editTextCurrentPassword = view.findViewById(R.id.editTextPassword_current_password);
        EditText editTextNewPassword = view.findViewById(R.id.editTextTextPassword_new_password);
        EditText editTextNewPasswordConfirm = view.findViewById(R.id.editTextTextPassword_new_password_confirmation);
        Button buttonSettingsAccountChangePasswordChange = view.findViewById(R.id.button_settings_account_change_password_change);
        TextView message = view.findViewById(R.id.textView22);

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Profile profile = db.profileDao().getProfile();

        //buttonSettingsAccountChangePasswordChangeが押されたときのアクション
        buttonSettingsAccountChangePasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentP = editTextCurrentPassword.getText().toString();
                String newP = editTextNewPassword.getText().toString();
                String newPC = editTextNewPasswordConfirm.getText().toString();
                if (currentP.equals(profile.password)) {
                    if (newP.equals(newPC)) {
                        Profile newProfile = new Profile();
                        newProfile.password = newP;
                        db.profileDao().insert(newProfile);  // insert new profile
                        message.setText("Password has been changed successfully" );
                    }
                    else {
                        //display "New passwords don't match"
                        message.setText("New passwords doesn't match");
                    }
                    }
                else {
                    //display "Incorrect current password"
                    message.setText("Incorrect Current Password");
                }
            }
        });



        return view;

    }
}
