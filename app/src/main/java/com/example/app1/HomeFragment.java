package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button settingsButton = (Button) view.findViewById(R.id.button_settings);
        Button ScolarshipsButton = (Button) view.findViewById(R.id.button_scholarships);
        Button mentalHealthButton = (Button) view.findViewById(R.id.button_mental_health);
        Button activityButton = (Button) view.findViewById(R.id.button_activity);
        return view;
    }


}
