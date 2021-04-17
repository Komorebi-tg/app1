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
    public String grade;
    public String birthDate;
    //public Integer index_gender;
    public String firstChoice;
    public String secondChoice;
    public String thirdChoice;
    public String interest1;
    public String interest2;
    public String interest3;
    public String interest4;
    public String email;
    public String phoneNumber;
    // ... add more fields here
}
