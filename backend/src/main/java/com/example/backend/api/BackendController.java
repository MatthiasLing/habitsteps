package com.example.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.backend.model.Habit;
import com.example.backend.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class BackendController {
    @Autowired
    HabitService habitService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/habits")
    public ResponseEntity<?> listHabits() {
        List<Habit> resource = habitService.getAllHabits();
        return ResponseEntity.ok(resource);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/addHabit")
    public Habit addHabit(@RequestBody Habit habit) {
        System.out.println(habit.getTitle());
        int response = habitService.addHabit(habit);
        return habit;
//                ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path = "/updateHabit")
    public int updateHabit(@RequestBody Habit habit) {
        System.out.println("updating:" + habit.getNotes());
        int response = habitService.updateHabit(habit.getId(), habit);
        return response;
    }


}
