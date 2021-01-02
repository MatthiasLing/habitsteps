package com.example.backend.model;
import com.example.backend.model.Day;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;


public class User {
    private String name;
    private String email;
    private  ArrayList<Day> days;
    private ArrayList<Habit> habits;
    private int streak;
    private Date lastLoggedIn;

    public User(

                 @JsonProperty("name") String name,
                 @JsonProperty("email") String email,
                 @JsonProperty("days") ArrayList<Day> days,
                 @JsonProperty("habits") ArrayList<Habit> habits,
                 @JsonProperty("streak") int streak,
                 @JsonProperty("lastLoggedIn") Date lastLoggedIn
    ){
        this.name = name;
        this.email = email;
        this.days = days;
        this.habits = habits;
        this.streak = streak;
        this.lastLoggedIn = lastLoggedIn;
    }

    public User(){
        this.name = "";
        this.email = "";
        this.streak = 0;
        this.lastLoggedIn = null;
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

    public void setLastLoggedIn(Date lastLoggedIn){this.lastLoggedIn = lastLoggedIn;}

    public void setStreak(int streak){this.streak = streak;}

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

    public Date getLastLoggedIn(){return lastLoggedIn;}

    public int getStreak(){
        return streak;}
}
