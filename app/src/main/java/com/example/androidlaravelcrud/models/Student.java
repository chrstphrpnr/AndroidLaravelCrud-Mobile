package com.example.androidlaravelcrud.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {

    private List<Student> data;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("first_name")
    @Expose
    private String first_name;


    @SerializedName("last_name")
    @Expose
    private String last_name;


    @SerializedName("age")
    @Expose
    private int age;



    //Constructor
    public Student(int id, String first_name, String last_name, int age) {
        this.setId(id);
        this.setFirst_name(first_name);
        this.setLast_name(first_name);
        this.setAge(age);
    }



    //Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }


}
