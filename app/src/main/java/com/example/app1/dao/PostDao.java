package com.example.app1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app1.model.Post;

import java.util.List;

@Dao
public interface PostDao {
    @Query("SELECT * FROM post WHERE uid = :uid")
    Post getPost(long uid);

    @Query("SELECT * FROM post WHERE category = :category")
    List<Post> getPosts(String category);

    @Insert
    void insert(Post post);

    @Query("DELETE FROM post WHERE uid = :uid")
    void delete(long uid);
}
