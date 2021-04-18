package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutUniversitiesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_universities, container, false);
        /*AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        List<Post> posts = db.postDao().getPosts("about_universities");
        if (posts.isEmpty()) {
            // Our first time displaying this, there will be no posts.
            // Fill in the examples;
            Post post1 = new Post();
            post1.category = "about_universities";
            post1.title = "title";
            post1.subtitle = "subtitle";
            post1.body = "body1";
            post1.image = "mentalhealthsuiminn";
            db.postDao().insert(post1);
            // add post2, post3, ...
            // get the posts again
            posts = db.postDao().getPosts("about_universities");
        }
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(32, 32, 32, 0);
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);
        ScrollView scrollView = view.findViewById(R.id.mental_health_scroll);
        scrollView.addView(layout);
        View leftCell = null;  // fill in rows of 2 columns

        for (Post post : posts) {
            // create button for post
            ImageButton image = new ImageButton(getContext());
            image.setBackgroundResource(getResources().getIdentifier("mentalhealthsuiminn", "drawable", "com.example.app1"));
            image.setOnClickListener((View v) -> {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, DisplayPostFragment.newInstance(post.uid)).commit();
            });
            ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(160, 160);
            image.setLayoutParams(imageParams);
            TextView textView = new TextView(getContext());
            textView.setText(post.title);
            LinearLayout cell = new LinearLayout(getContext());
            cell.setOrientation(LinearLayout.VERTICAL);
            cell.setLayoutParams(params);
            cell.addView(image);
            cell.addView(textView);
            if (leftCell == null) {
                leftCell = cell;
            } else {
                LinearLayout row = new LinearLayout(getContext());
                row.setOrientation(LinearLayout.HORIZONTAL);
                row.setLayoutParams(params);
                row.addView(leftCell);
                row.addView(cell);
                layout.addView(row);
                leftCell = null;
            }
        }
        if (leftCell != null) {
            // last button by itself
            layout.addView(leftCell);
        }

         */
        return view;
    }
}