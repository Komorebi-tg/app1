package com.example.app1;

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

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Post;

public class MentalHealthCreatePostFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mental_health_create_post, container, false);

        EditText body = view.findViewById(R.id.editTextTextMultiLineCreateScholarshipsPost);

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


        Button save = view.findViewById(R.id.saveMentalHealthPost);
        if (save != null) {
            save.setOnClickListener((View v) -> {
                // Save edited fields to database.
                Post newPost = new Post();
                newPost.category = "mental_health";
//                newPost.title = ...;
//                newPost.subtitle = ...;
//                newPost.image = ...;
                newPost.body = body.getText().toString();
                db.postDao().insert(newPost);  // insert new profile
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthFragment()).commit();
            });
        }

        return view;
    }
}
