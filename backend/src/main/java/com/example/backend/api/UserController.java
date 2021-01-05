package com.example.backend.api;

import com.example.backend.model.User;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.backend.model.Habit;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.backend.service.firebaseService;

import javax.annotation.PostConstruct;

@RestController
//@RequestMapping("/api/")
public class UserController {
    @Autowired
    firebaseService firebaseService;

    @PostMapping(path = "/api/addUser")
    public String addUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        System.out.println("Adding " + user.getName());
       return firebaseService.saveUser(user);
    }

    @RequestMapping(path = "/api/user/{someID}")
    public @ResponseBody User getUser(@PathVariable(value="someID") String email) throws ExecutionException, InterruptedException {
        System.out.println("searching for "+ email);
        return firebaseService.getUser(email);
    }

    @PostMapping (path = "/api/addHabit/{emailString}")
    public @ResponseBody void addHabit(@PathVariable(value="emailString") String email, @RequestBody Habit habit) throws ExecutionException, InterruptedException {
        System.out.println("Received put request");
        System.out.println("adding "+ habit.getTitle());
        firebaseService.addHabit(email, habit);
    }

    @PostMapping (path = "/api/removeHabit/{emailString}")
    public @ResponseBody void removeHabit(@PathVariable(value="emailString") String email, @RequestBody Habit habit) throws ExecutionException, InterruptedException {
        System.out.println("Removing "+ habit.getTitle());
        firebaseService.removeHabit(email, habit);
    }

    @PostMapping (path = "/api/updateHabit/{emailString}")
    public @ResponseBody void updateHabit(@PathVariable(value="emailString") String email, @RequestBody Habit habit) throws ExecutionException, InterruptedException {
        System.out.println("Received update request");
        System.out.println("updating "+ habit.getTitle());
        firebaseService.updateHabit(email, habit);
    }


}
