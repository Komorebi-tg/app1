package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Post;

public class AboutUniversitiesCreatePostFragment extends Fragment {
    public static String[] imageNames = {"", "東京大学", "京都大学", "北海道大学", "一橋大学"};
    public static String[] imageFiles = {"", "aboutuniversitiestokyo", "aboutuniversitieskyouto", "aboutuniversitieshokkaido", "aboutuniversitieshitotsubashi"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_universities_create_post, container, false);

        EditText title = view.findViewById(R.id.university_title);
        EditText subtitle = view.findViewById(R.id.university_subtitle);
        EditText body = view.findViewById(R.id.editTextTextMultiLineCreateScholarshipsPost);


        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        Spinner imageSpinner = view.findViewById(R.id.image_spinner);
        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, imageNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imageSpinner.setAdapter(aa);


        Button save = view.findViewById(R.id.saveAboutUniversitiesPost);
        if (save != null) {
            save.setOnClickListener((View v) -> {
                // Save edited fields to database.
                Post newPost = new Post();
                newPost.category = "university";
                newPost.title = title.getText().toString();
                newPost.subtitle = subtitle.getText().toString();
                if (!imageFiles[imageSpinner.getSelectedItemPosition()].isEmpty()) {
                    newPost.image = imageFiles[imageSpinner.getSelectedItemPosition()];
                }
                newPost.body = body.getText().toString();
                db.postDao().insert(newPost);  // insert new profile
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUniversitiesFragment()).commit();
            });
        }

        return view;
    }
}
