package com.example.app1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Profile {
    @PrimaryKey
    public long uid;
    public String name;
    public String nickname;
    public String gender;
    public String schoolName;
    // ... add more fields here
}
