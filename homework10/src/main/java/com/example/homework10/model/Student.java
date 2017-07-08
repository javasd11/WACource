package com.example.homework10.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ReznichenkoV on 06.07.2017.
 */

public class Student implements Parcelable{
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
        dest.writeLong(this.Age);
    }

    protected Student(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.FirstName = in.readString();
        this.LastName = in.readString();
        this.Age = in.readLong();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
