package com.example.backend.service;

import com.example.backend.model.Day;
import com.example.backend.model.Habit;
import com.example.backend.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class firebaseService {

//    The function:
//    clean the db
//    add a new day to the days array if needed
//    returns the user object to the frontend
    public User getUser(String email) throws ExecutionException, InterruptedException {

        System.out.println("Initializing a new day object");
        Firestore db = FirestoreClient.getFirestore();

        CollectionReference users = db.collection("users");
        Query query = users.whereEqualTo("email", email);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        int needNew = 1;

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            System.out.println(document.get("email") + " found!");
            User user = document.toObject(User.class);

            LocalDate currDate = new Date(System.currentTimeMillis()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            ArrayList<Day> updatedDays = new ArrayList<Day>();
            ZoneId defaultZoneId = ZoneId.systemDefault();


            for (Day day : user.getDays()){
                LocalDate tempDate = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                System.out.println(tempDate.getYear()+"/"+tempDate.getMonth()+"/"+tempDate.getDayOfMonth());

                if (tempDate.getYear() == currDate.getYear()
                        && tempDate.getDayOfMonth() == currDate.getDayOfMonth()
                        && tempDate.getMonth() == currDate.getMonth()) {
                        needNew = 0;
                    }

                    if (DAYS.between(tempDate, currDate) < 30) {
                        System.out.println("Day found");
                        updatedDays.add(day);
                    }
            }
            if (needNew == 1){
                Day latest = new Day(Date.from(currDate.atStartOfDay(defaultZoneId).toInstant()),
                        user.getHabits(),user.getHabits().size());
                updatedDays.add(latest);
            }
            user.setDays(updatedDays);

            long between = DAYS.between(user.getLastLoggedIn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), currDate);

            if ( between > 1){
                System.out.println("LOST YOUR STREAK");
                user.setStreak(0);
            }else if (between == 1){
                System.out.println("ADDING TO STREAK");
                user.setStreak(user.getStreak() + 1);
            }else{
                System.out.println("SAME DAY LOGIN");
            }

            user.setLastLoggedIn(Date.from(currDate.atStartOfDay(defaultZoneId).toInstant()));

            ApiFuture<WriteResult> collectionsApiFuture = db.collection("users").document(email).set(user);

            return user;
        }
        System.out.println("No user found");
        return null;

    }
    public String saveUser(User user) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        user.setLastLoggedIn(new Date(System.currentTimeMillis()));
//        Potential issue, couldn't read what goes here
        ApiFuture<WriteResult> collectionsApiFuture = db.collection("users").document(user.getName()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    public void addHabit(String email, Habit habit) throws ExecutionException, InterruptedException {
        System.out.println("Adding habit " + habit.getTitle());
        Firestore db = FirestoreClient.getFirestore();

        //add habit to the user's day
        CollectionReference users = db.collection("users");
        Query query = users.whereEqualTo("email", email);
// retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            System.out.println(document.get("email") + " found!");
            User user = document.toObject(User.class);

            Date currDate = new Date(System.currentTimeMillis());
            LocalDate localDate = currDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            for (Day day : user.getDays()){
                LocalDate tempDate = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (tempDate.getYear() == localDate.getYear()
                && tempDate.getDayOfMonth() == localDate.getDayOfMonth()
                    && tempDate.getMonth() == localDate.getMonth()){
                    System.out.println("Day found");

                    ArrayList<Habit> dayHabits = day.getHabits();
                    dayHabits.add(habit);
                    day.setHabits(dayHabits);

                    ArrayList<Habit> userHabits = user.getHabits();
                    userHabits.add(habit);
                    user.setHabits(userHabits);

                    ApiFuture<WriteResult> collectionsApiFuture = db.collection("users").document(email).set(user);
                    System.out.println("Habit added successfully");
                    return;
                }
            }
            break;
        }
        System.out.println("No user found");
    }

    public void removeHabit(String email, Habit habit) throws ExecutionException, InterruptedException{
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference users = db.collection("users");

        Query query = users.whereEqualTo("email", email);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        ArrayList<Habit> updatedHabits = new ArrayList<Habit>();


        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            User user = document.toObject(User.class);

            for (Habit presentHabit : user.getHabits()){
               if (!presentHabit.getId().equals(habit.getId())){
                updatedHabits.add(presentHabit);
               }
            }

            user.setHabits(updatedHabits);
            LocalDate currDate = new Date(System.currentTimeMillis()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


            for (Day day : user.getDays()){
                LocalDate tempDate = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (tempDate.getYear() == currDate.getYear()
                        && tempDate.getDayOfMonth() == currDate.getDayOfMonth()
                        && tempDate.getMonth() == currDate.getMonth()) {
                    for (Habit currHabit : day.getHabits()){
                        if (currHabit.getId().equals (habit.getId())){
//                            replace this one
                            ArrayList<Habit> newHabits = day.getHabits();
                            newHabits.remove(newHabits.indexOf(currHabit));
                            day.setHabits(newHabits);
                            ApiFuture<WriteResult> collectionsApiFuture = db.collection("users").document(email).set(user);
                            System.out.println("Removing " + habit.getTitle());
                            return;
                        }
                    }
                }

            }

            
            return;
        }

    }

    public void updateHabit(String email, Habit habit) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
//        Potential issue, couldn't read what goes here
        CollectionReference users = db.collection("users");
// Create a query against the collection.
        Query query = users.whereEqualTo("email", email);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            System.out.println(document.get("email") + " found!");
            User user = document.toObject(User.class);

            LocalDate currDate = new Date(System.currentTimeMillis()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            for (Day day : user.getDays()){
                LocalDate tempDate = day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (tempDate.getYear() == currDate.getYear()
                        && tempDate.getDayOfMonth() == currDate.getDayOfMonth()
                        && tempDate.getMonth() == currDate.getMonth()) {
                    for (Habit currHabit : day.getHabits()){
                        if (currHabit.getId().equals (habit.getId())){
//                            replace this one
                            ArrayList<Habit> newHabits = day.getHabits();
                            newHabits.set(newHabits.indexOf(currHabit), habit);
                            day.setHabits(newHabits);
                            ApiFuture<WriteResult> collectionsApiFuture = db.collection("users").document(email).set(user);
                            System.out.println("Updating " + habit.getTitle());
                            return;
                        }
                    }
                }

            }
            System.out.println("UpdateHabit did not find the present day");
//            call getUser?
            return;
        }
        System.out.println("No user found");
        return ;
    }

}
