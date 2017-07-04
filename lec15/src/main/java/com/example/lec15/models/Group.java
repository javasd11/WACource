package com.example.lec15.models;

/**
 * Created by vadim on 02.07.2017.
 */

public class Group {
    public String GroupName;
    public Student[] students;

    public Group() {
    }

    public Group(String groupName, Student[] students) {
        GroupName = groupName;
        this.students = students;
    }
}
