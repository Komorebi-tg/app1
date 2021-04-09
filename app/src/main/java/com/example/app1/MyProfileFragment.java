package com.example.app1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        EditText editTextname = view.findViewById(R.id.editTextName);
        TextView textViewName = view.findViewById(R.id.textViewName);
        String name = editTextname.getText().toString();
        Log.d("Log", name);
        textViewName.setText(name);

        return view;
    }

}
