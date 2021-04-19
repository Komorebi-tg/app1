package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Post;

import java.util.List;

public class AboutUniversitiesFragment extends Fragment implements SearchView.OnQueryTextListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_universities, container, false);
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        if (!"大学以上".equals(db.profileDao().getProfile().grade)) {
            View writePost = view.findViewById(R.id.button7);
            if (writePost != null) {
                writePost.setVisibility(View.INVISIBLE);
            }
        }

        displayPosts(view, "university", null);
        SearchView searchView = view.findViewById(R.id.about_universities_search);
        searchView.setOnQueryTextListener(this);
        return view;
    }

    public boolean onQueryTextSubmit(String query) {
        return onQueryTextChange(query);
    }

    public boolean onQueryTextChange(String newText) {
        ScrollView scrollView = getView().findViewById(R.id.about_universities_scroll);
        scrollView.removeAllViews();
        displayPosts(getView(), "university", newText);
        return false;
    }

    public void displayPosts(View view, @NonNull String category, @Nullable String query) {
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        List<Post> posts;
        if (query == null || query.isEmpty()) {
            posts = db.postDao().getPosts(category);
            if (posts.isEmpty()) {
                // Our first time displaying this, there will be no posts.
                // Fill in the examples;
                Post post1 = new Post();
                post1.category = "university";
                post1.title = "東京大学 文科2類";
                post1.body = "大学の特色 この大学は〜 \n location  東京大学本郷キャンパスー本郷三丁目駅（地下鉄丸の内線、地下鉄大江戸線）徒歩10分、根津駅（地下鉄千代田線）徒歩5〜10分、東大前駅（地下鉄南北線）徒歩10分 \n 67.5（河合塾）\n 理科1類";
                post1.image = "tokyouniversity";
                db.postDao().insert(post1);
                // add post2, post3, ...
                Post post2 = new Post();
                post2.category = "university";
                post2.title = "一橋大学 経済学部";
                post2.image = "hitotsubashiuniversity";
                db.postDao().insert(post2);

                Post post3 = new Post();
                post3.category = "university";
                post3.title = "京都大学 経済学部";
                post3.image = "kyotouniversity";
                db.postDao().insert(post3);

                Post post4 = new Post();
                post4.category = "university";
                post4.title = "北海道大学 文学部";
                post4.image = "hottkaidouniversity";
                db.postDao().insert(post4);
                // get the posts again
                posts = db.postDao().getPosts("university");
            }
        } else {
            posts = db.postDao().searchPosts(category, query);
        }


        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(32, 32, 32, 0);
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(params);
        ScrollView scrollView = view.findViewById(R.id.about_universities_scroll);
        scrollView.addView(layout);
        View leftCell = null;  // fill in rows of 2 columns
        for (Post post : posts) {
            // create button for post
            ImageButton image = new ImageButton(getContext());
            String imageName = post.image != null && !post.image.isEmpty() ? post.image : "tokyouniversity";
            image.setBackgroundResource(getResources().getIdentifier(imageName, "drawable", "com.example.app1"));
            image.setOnClickListener((View v) -> {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, DisplayPostFragment.newInstance(post.uid)).commit();
            });
            ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(320, 320);
            image.setLayoutParams(imageParams);
            TextView textView = new TextView(getContext());
            textView.setText(post.title);
            LinearLayout cell = new LinearLayout(getContext());
            cell.setOrientation(LinearLayout.VERTICAL);
            cell.setLayoutParams(params);
            cell.addView(image);
            cell.addView(textView);
            LinearLayout save = new LinearLayout(getContext());
            save.setOrientation(LinearLayout.HORIZONTAL);
            TextView saveTextView = new TextView(getContext());
            saveTextView.setText("Save");
            SwitchCompat aSwitch = new SwitchCompat(getContext());
            aSwitch.setChecked(post.saved);
            aSwitch.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                db.postDao().setSaved(post.uid, isChecked);
            });
            save.addView(saveTextView);
            save.addView(aSwitch);
            cell.addView(save);
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
    }
}