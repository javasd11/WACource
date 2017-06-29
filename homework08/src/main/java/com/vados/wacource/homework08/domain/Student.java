package com.vados.wacource.homework08.domain;

/**
 * Created by vadim on 29.06.2017.
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
        return String.format("name=%s, lastname=%s, age=%d", firstName,lastName,age);
    }
}
