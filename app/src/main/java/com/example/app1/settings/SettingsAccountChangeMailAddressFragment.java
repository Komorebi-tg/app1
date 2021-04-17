package com.example.app1.settings;

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

import com.example.app1.R;
import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Profile;

public class SettingsAccountChangeMailAddressFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_account_change_mail_address, container, false);
        Button change = view.findViewById(R.id.button_settings_account_change_mail_address_do);
        EditText editTextmailaddress = view.findViewById(R.id.editTextTextEmailAddress2);
        String mailaddress = editTextmailaddress.getText().toString();

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Profile profile = db.profileDao().getProfile();

        //I don't get why this doesn't work properly
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mailaddress == profile.email) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsAccountChangeMailAddressPasswordFragment()).commit();
                }
            }
        });

        return view;

    }
}
