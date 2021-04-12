package com.example.app1.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app1.R;

public class SettingsAccountChangePasswordFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_account, container, false);
        Button change = view.findViewById(R.id.button_settings_account_change_password_change);
        /*EditText editTextCurrentPassword = view.findViewById(R.id.editTextPassword_current_password);
        EditText editTextNewPassword = view.findViewById(R.id.editTextTextPassword_new_password);
        EditText editTextNewPasswordConfirm = view.findViewById(R.id.editTextTextPassword_new_password_confirmation);
        String currentPassword = editTextCurrentPassword.getText().toString();
        Button buttonSettingsAccountChangePasswordChange = view.findViewById(R.id.button_settings_account_change_password_change);

         */

        //buttonSettingsAccountChangePasswordChangeが押されたときのアクション
        /*buttonSettingsAccountChangePasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPassword == BasicProfilePassword) {
                    if (editTextNewPassword == editTextNewPasswordConfirm) {
                        //process the button action
                    }
                    else {
                        //display "New passwords don't match"
                    }
                    }
                else {
                    //display "Incorrect current password"
                }
            }
        });

         */

        return view;

    }
}
