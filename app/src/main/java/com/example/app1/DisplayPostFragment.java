package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.app1.dao.AppDatabase;
import com.example.app1.model.Post;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayPostFragment extends Fragment {
    private static final String POST_UID = "postUid";

    private long postUid;

    public DisplayPostFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param postUid uid of the post we want to display.
     * @return A new instance of fragment DisplayPostFragment.
     */
    public static DisplayPostFragment newInstance(long postUid) {
        DisplayPostFragment fragment = new DisplayPostFragment();
        Bundle args = new Bundle();
        args.putLong(POST_UID, postUid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            postUid = getArguments().getLong(POST_UID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_post, container, false);
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "app-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        Post post = db.postDao().getPost(postUid);
        if (post != null) {
            TextView body = view.findViewById(R.id.display_post_body);
            if (body != null && post.body != null) {
                body.setText(post.body);
            }
            ImageView image = view.findViewById(R.id.display_post_image);
            if (image != null && post.image != null) {
                image.setBackgroundResource(getResources().getIdentifier(post.image, "drawable", "com.example.app1"));
            }
            TextView title = view.findViewById(R.id.display_post_title);
            if (title != null && post.title != null) {
                title.setText(post.title);
            }
            TextView subtitle = view.findViewById(R.id.display_post_subtitle);
            if (subtitle != null && post.subtitle != null) {
                title.setText(post.subtitle);
            }
            TextView category = view.findViewById(R.id.display_post_category);
            if (category != null && post.category != null) {
                category.setText(post.category);
            }
        }
        return view;
    }
}