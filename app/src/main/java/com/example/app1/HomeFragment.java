package com.example.app1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button settingsButton = view.findViewById(R.id.button_settings);
        Button scolarshipsButton = (Button) view.findViewById(R.id.button_scholarships);
        Button mentalHealthButton = (Button) view.findViewById(R.id.button_mental_health);
        Button activityButton = (Button) view.findViewById(R.id.button_activity);


        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(null, "fragment:");
                FragmentManager fragmentManager = getFragmentManager();
                Log.e(null, "fragment:" + fragmentManager);
                if (fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new SettingsFragment());
                    Log.e(null, "replaced");
                    fragmentTransaction.commit();
                }
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
            }
        });
        return view;
    }
}
