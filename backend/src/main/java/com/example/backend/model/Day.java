package com.example.backend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.type.DateTime;

import java.util.ArrayList;
import java.util.Date;

public class Day {
    private Date date;
    private ArrayList<Habit> habits;
    private int score;

    public Day(
            @JsonProperty("date") Date date,
            @JsonProperty("habits") ArrayList<Habit> habits,
            @JsonProperty("score") int score){
        this.date = date;
        this.habits = habits;
        this.score = score;
    }

    public Day(){
        this.date = null;
    }

    public void setDate(Date newDate) {
        this.date = newDate;
    }

    public void setHabits(ArrayList<Habit> newHabits){
        this.habits = newHabits;
    }

    public void setScore(int score){
        this.score = score;
    }
    public Date getDate(){
        return date;
    }

    public ArrayList<Habit> getHabits(){
        return habits;
    }

    public int getScore(){
        System.out.println("getting the score: " + habits.size());
        return habits.size();
    }



//    clean and modify functions here


}
