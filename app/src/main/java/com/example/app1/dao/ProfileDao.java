package com.example.app1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app1.model.Profile;

@Dao
public interface ProfileDao {
    @Query("SELECT * FROM profile LIMIT 1")
    Profile getProfile();

    @Insert
    void insert(Profile profile);

    @Query("DELETE FROM profile")
    void delete();
}
