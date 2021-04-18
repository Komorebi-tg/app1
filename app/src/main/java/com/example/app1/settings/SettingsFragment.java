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

import com.example.app1.R;

public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button accountCentre = view.findViewById(R.id.button_settings_account_centre);
        TextView message = view.findViewById(R.id.textView23);

        accountCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText("Web site is being constracted.");
                message.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        message.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
                //Uri uri = Uri.parse("https://...");
                //Intent i = new Intent(Intent.ACTION_VIEW, uri);
                //startActivity(i);
            }
        });
        return view;
    }
}
