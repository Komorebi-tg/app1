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

public class SettingsAccountChangeMailAddressFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_account_change_mail_address, container, false);
        Button change = view.findViewById(R.id.button_settings_account_change_mail_address_do);
        EditText editTextmailaddress = view.findViewById(R.id.editTextTextEmailAddress2);
        EditText editTextpassword = view.findViewById(R.id.editTextPassword);
        TextView message = view.findViewById(R.id.message);

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Profile profile = db.profileDao().getProfile();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailaddress = editTextmailaddress.getText().toString();
                String password = editTextpassword.getText().toString();
                if (mailaddress == profile.email) {
                    if (password == profile.password) {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsAccountChangeMailAddressPasswordFragment()).commit();

                    } else {
                        message.setText("Incorrect Password");
                    }
                } else {
                    message.setText("Incorrect Mail Address");
                }

            }
        });

        return view;

    }
}


        /*
        // Alerts Dialogue
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.positive)
                .setTitle(R.string.positive)
                .setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
        //end
         */