package com.example.backend.dao;

import com.example.backend.model.Habit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeHabitDataAccessService implements HabitDao{

    private static List<Habit> DB = new ArrayList<Habit>(
            Arrays.asList(
                    new Habit(UUID.randomUUID(), "Make The Bed", "boolPos", 0, "boolean habit"),
                    new Habit(UUID.randomUUID(), "Drink Water", "countPos", 2, "positive counter"),
                    new Habit(UUID.randomUUID(), "Less Distraction", "slideNeg", 56, "this is a slide")
            )

    );

    @Override
    public int insertHabit(UUID id, Habit habit){
        DB.add(new Habit(id, habit.getTitle(), habit.getType(), habit.getStatus(), habit.getNotes()));
        return 1;
    }

    @Override
    public List<Habit> getAllHabits(){
        return DB;
    }

    @Override
    public int updateHabit(UUID id, Habit habit) {
        System.out.println(id + " " + habit.getId() +"  " + habit.getTitle());
        for (int index=0;index < DB.size(); index ++){
            System.out.println(DB.get(index).getId() + " " + id);
            if (DB.get(index).getId().equals(id)){
                DB.set(index, habit);
                return 1;
            }
        }
        return 0;
    }
}
