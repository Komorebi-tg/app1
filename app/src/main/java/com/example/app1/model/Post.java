package com.example.app1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    public String category;  // university, scholarships, mental_health, activity
    public String body;
    public String image;
}
