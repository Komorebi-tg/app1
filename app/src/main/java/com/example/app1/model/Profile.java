package com.example.app1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Profile {
    @PrimaryKey
    public long uid;
    public String name;
    // ... add more fields here
}
