package com.example.cristianduarte.intentslesson;

import java.io.Serializable;

/**
 * Created by cduarte on 1/8/16.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -7060210544600464481L;
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}