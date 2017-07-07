package com.example.homework10.model;

/**
 * Created by ReznichenkoV on 06.07.2017.
 */

public class Student {
    public static final String TABLE_NAME="Students";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_FIRSTNAME="FirstName";
    public static final String COLUMN_LASTNAME="LastName";
    public static final String COLUMN_AGE="Age";



    public Long id;
    public String FirstName;
    public String LastName;
    public long Age;


    public Student() {
    }

    public Student(String firstName, String lastName, long age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("id=%d, name=%s, lastname=%s, age=%d",id,FirstName,LastName,Age);
    }
}
