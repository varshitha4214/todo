package com.todoapp.todo.services;

import com.todoapp.todo.entity.Activity;
import com.todoapp.todo.entity.User;
import com.todoapp.todo.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // Save or update an activity
    public void saveActivity(List<Activity> activities) {
        activityRepository.saveAll(activities);
    }

    // Get activity by ID
    public Activity getActivityById(int id) {
        return activityRepository.findById(id).orElse(null);
    }

    /*public List<Activity> getActivitiesByUsername(String username) {
        return activityRepository.findByUsername(username);
    }*/
    public List<Activity> getActivitiesByUser(User user) {
        return activityRepository.findByUser(user);
    }


    public List<Activity> fetchActivities() {
        return activityRepository.findAll();
    }

    public Activity saveSingleActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public void deleteActivity(int id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
        activityRepository.delete(activity);
    }

}
