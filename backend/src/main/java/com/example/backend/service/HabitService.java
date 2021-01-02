//package com.example.backend.service;
//
//import com.example.backend.dao.HabitDao;
//import com.example.backend.model.Habit;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class HabitService {
//
//    private final HabitDao habitDao;
//
//    @Autowired
////    Change this qualifier for future db services
//    public HabitService(@Qualifier("fakeDao") HabitDao habitDao){
//        this.habitDao = habitDao;
//    }
//
//    public int addHabit(Habit habit){
//        return habitDao.addHabit(habit);
//    }
//
//    public List<Habit> getAllHabits(){
//        return habitDao.getAllHabits();
//    }
//
//    public int updateHabit(String id, Habit habit){
//        return habitDao.updateHabit(id, habit);
//    }
//}
