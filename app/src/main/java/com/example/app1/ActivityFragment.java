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
import com.example.app1.model.Profile;

import java.util.List;

public class ActivityFragment extends Fragment implements SearchView.OnQueryTextListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        Profile profile = db.profileDao().getProfile();
        if (!(profile != null && "大学以上".equals(profile.grade))) {
            View writePost = view.findViewById(R.id.button7);
            if (writePost != null) {
                writePost.setVisibility(View.INVISIBLE);
            }
        }
        displayPosts(view, "activity", null);
        SearchView searchView = view.findViewById(R.id.activity_search);
        searchView.setOnQueryTextListener(this);

        return view;
    }

    public boolean onQueryTextSubmit(String query) {
        return onQueryTextChange(query);
    }

    public boolean onQueryTextChange(String newText) {
        ScrollView scrollView = getView().findViewById(R.id.activities_scroll);
        scrollView.removeAllViews();
        displayPosts(getView(), "activity", newText);
        return false;
    }

    public void displayPosts(View view, @NonNull String category, @Nullable String query) {
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        List<Post> posts;
        Profile profile = db.profileDao().getProfile();
        posts = db.postDao().getPosts(category);

        if (!(profile != null && "大学以上".equals(profile.grade))) {
            View writePost = view.findViewById(R.id.button7);
            if (writePost != null) {
                writePost.setVisibility(View.INVISIBLE);
            }




            if (posts.isEmpty()) {
                // Our first time displaying this, there will be no posts.
                // Fill in the examples;
                Post post1 = new Post();
                post1.category = "activity";
                post1.title = "ときめきロボコン2021!";
                post1.body = "対象・・・高校生（中学三年生も可) \r\n 主な条件・・・首都圏に住んでいること \r\n 開催日・・・9/6 \r\n 締め入り日・・・7/30 \r\n\n ときめきロボコンクラブは小学生ロボコン支援活動、山水苑活動、講演会を通しての教育・啓蒙活動、地方自治体への署名・請願活動、ファミリーイベントによる家族交流など様々な活動を通して国民運動に参加します！";
                post1.image = "activityrobocon";
                db.postDao().insert(post1);

                Post post2 = new Post();
                post2.category = "activity";
                post2.title = "異文化交流会";
                post2.image = "activityibunnka";
                db.postDao().insert(post2);

                Post post3 = new Post();
                post3.category = "activity";
                post3.title = "English Summer Camp";
                post3.image = "activitysummercamp";
                db.postDao().insert(post3);

                Post post4 = new Post();
                post4.category = "activity";
                post4.title = "街をきれいに！！";
                post4.image = "activityvolunteer";
                db.postDao().insert(post4);
                // add post2, post3, ...
                // get the posts again
                posts = db.postDao().getPosts(category);
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
        ScrollView scrollView = view.findViewById(R.id.activities_scroll);
        scrollView.addView(layout);
        View leftCell = null;  // fill in rows of 2 columns
        for (Post post : posts) {
            // create button for post
            ImageButton image = new ImageButton(getContext());
            String imageName = post.image != null && !post.image.isEmpty() ? post.image : "activityrobocon";
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
