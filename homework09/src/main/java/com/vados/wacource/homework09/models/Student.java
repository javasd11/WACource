package com.vados.wacource.homework09.models;

/**
 * Created by vadim on 02.07.2017.
 */

public class Student {
    public String firstName;
    public String lastName;
    public int age;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name =%s, lastname=%s, age=%d",firstName,lastName,age);
    }
}
