package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Post;

import java.util.List;

public class MentalHealthFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mental_health, container, false);
        displayPosts(view, "mental_health", null);
        SearchView searchView = view.findViewById(R.id.mental_health_search);
        searchView.setOnSearchClickListener((View view2) -> {
            ScrollView scrollView = view.findViewById(R.id.mental_health_scroll);
            scrollView.removeAllViews();
            String query = searchView.getQuery().toString();
            displayPosts(view, "mental_health", query);
        });
        return view;
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
                post1.category = category;
                post1.title = "睡眠は大事！？";
                post1.subtitle = "【睡眠を制する者は受験を制する！？】驚きの研究結果が明らかに！";
                post1.body = "　睡眠と勉強のバランスをどう保つか、という問題は数多くの受験生が抱えている問題です。みなさんの中にも「寝ても寝ても疲れがとれない」だとか「寝ようと思ったらもう2時を回っていた」なんて経験がある方も多いのでは無いでしょうか？私も受験生のときにはよくクマを作って家族に心配されていました。  　この睡眠と勉強のバランスをどうとるべきかという問題は永遠の命題と思われがちですが最新の研究でもっとも効率的な両立方法が明らかになりました。東京大学のOOO教授の研究結果によると、毎日同じ時間に就寝するのがもっとも効率的に生産力を上げることができるようです。以下がその研究データで、毎日同じ時間帯に就寝した人とバラバラの時間帯に就寝した人の集中力の持続時間は1セット平均30分以上も変わってくるようです。またデータ2にもあるように勉強時間自体も1週間で3時間ほどの差が生じることも明らかになりました。" ;
                post1.image = "mentalhealthsuiminn";
                db.postDao().insert(post1);
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
        ScrollView scrollView = view.findViewById(R.id.mental_health_scroll);
        scrollView.addView(layout);
        View leftCell = null;  // fill in rows of 2 columns
        for (Post post : posts) {
            // create button for post
            ImageButton image = new ImageButton(getContext());
            String imageName = post.image != null && !post.image.isEmpty() ? post.image : "mentalhealthsuiminn";
            image.setBackgroundResource(getResources().getIdentifier(imageName, "drawable", "com.example.app1"));
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
    }


}
