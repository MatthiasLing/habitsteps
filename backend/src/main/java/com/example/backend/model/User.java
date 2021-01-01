package com.example.backend.model;
import com.example.backend.model.Day;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String name;
    private String email;
    private  ArrayList<Day> days;
    private ArrayList<Habit> habits;

    public User(

                 @JsonProperty("name") String name,
                 @JsonProperty("email") String email,
                 @JsonProperty("days") ArrayList<Day> days,
                 @JsonProperty("habits") ArrayList<Habit> habits
    ){
        this.name = name;
        this.email = email;
        this.days = days;
        this.habits = habits;
    }

    public User(){
        System.out.println("constructor called");
        this.name = "";
        this.email = "";
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setEmail (String newEmail){
        this.email = newEmail;
    }

    public void setDays(ArrayList<Day> newDays){
        this.days = newDays;
    }

    public void setHabits(ArrayList<Habit> newHabits){
        this.habits = newHabits;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<Day> getDays(){
        return days;
    }

    public ArrayList<Habit> getHabits() {
        return habits;
    }

    //    clean and modify functions here


}
