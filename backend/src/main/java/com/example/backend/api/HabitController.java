package com.example.backend.api;

import com.example.backend.model.Habit;
import com.example.backend.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/habit")
@RestController
public class HabitController {

    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService){
        this.habitService = habitService;
    }
    @PostMapping
    public void addHabit(@RequestBody Habit habit){
        habitService.addHabit(habit);
    }

    @GetMapping
    public List<Habit> getAllHabits(){
        return habitService.getAllHabits();
    }

    @PutMapping
    public void updateHabit(@RequestBody UUID id, Habit habit){this.habitService.updateHabit(id, habit);}
}
