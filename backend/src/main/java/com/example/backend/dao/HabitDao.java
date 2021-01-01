package com.example.backend.dao;

import com.example.backend.model.Habit;

import java.util.List;
import java.util.UUID;

public interface HabitDao {

    int insertHabit(String id, Habit habit);

    default int addHabit(Habit habit){
        String id = UUID.randomUUID().toString();
        return insertHabit(id, habit);
    }

    int updateHabit(String id, Habit habit);

    List<Habit> getAllHabits();
}
