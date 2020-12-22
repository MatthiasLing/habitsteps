package com.example.backend.dao;

import com.example.backend.model.Habit;

import java.util.List;
import java.util.UUID;

public interface HabitDao {

    int insertHabit(UUID id, Habit habit);

    default int addHabit(Habit habit){
        UUID id = UUID.randomUUID();
        return insertHabit(id, habit);
    }

    int updateHabit(UUID id, Habit habit);

    List<Habit> getAllHabits();
}
