package com.example.backend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Name;

import java.util.UUID;

public class Habit {
    private final UUID id;
    private final String title;
    private final String type;
    private final int status;
    private final String notes;

    public Habit(@JsonProperty("id") UUID id,
                 @JsonProperty("title") String title,
                 @JsonProperty("type") String type,
                 @JsonProperty("status") int status,
                 @JsonProperty("notes") String notes){
        this.id = id;
        this.title = title;
        this.type = type;
        this.status = status;
        this.notes = notes;
    }

    public UUID getId(){
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

    public String getNotes(){
        return notes;
    }


}
