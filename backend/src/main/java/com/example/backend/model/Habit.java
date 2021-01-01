package com.example.backend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Name;

import java.util.UUID;

public class Habit {
    private String id;
    private String title;
    private String type;
    private int status;
    private int target;
    private String notes;

    public Habit(@JsonProperty("id") String id,
                 @JsonProperty("title") String title,
                 @JsonProperty("type") String type,
                 @JsonProperty("status") int status,
                 @JsonProperty("target") int target,
                 @JsonProperty("notes") String notes){
        this.id = id;
        this.title = title;
        this.type = type;
        this.status = status;
        this.target = target;
        this.notes = notes;
    }

    public Habit(){
        id = null;
        title = "";
        type = "";
        status = 0;
        target = 0;
        notes = "";
    }

    public void setId(String newId){
        this.id = newId;
    }

    public void setTitle (String newTitle){
        this.title = newTitle;
    }

    public void setType (String newType){
        this.type = newType;
    }

    public void setStatus (int newStatus){
        this.status = newStatus;
    }

    public void setTarget (int newTarget) {this.target = newTarget;}

    public void setNotes (String newNotes){
        this.notes = newNotes;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getType(){
        return type;
    }

    public int getStatus(){
        return status;
    }

    public int getTarget(){return target;}

    public String getNotes(){
        return notes;
    }


}
