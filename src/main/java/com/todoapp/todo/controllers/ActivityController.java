package com.todoapp.todo.controllers;

import com.todoapp.todo.entity.Activity;
import com.todoapp.todo.entity.User;
import com.todoapp.todo.services.ActivityService;
import com.todoapp.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    // Save or update an activity
    @PostMapping("/activities")
    private void saveActivity(@RequestBody List<Activity> activities) {
        activityService.saveActivity(activities);
    }

    @GetMapping("/activities")
    private List<Activity> fetchActivities() {
        return activityService.fetchActivities();
    }

    // Get activity by ID
    @GetMapping("/activities/{id}")
    private Activity getActivityById(@PathVariable int id) {
        return activityService.getActivityById(id);
    }

    // Get all activities for a specific user
    /*@GetMapping("/activities/user/{username}")
    private List<Activity> getActivitiesByUsername(@PathVariable String username) {
        return activityService.getActivitiesByUsername(username);
    }*/

    // Create multiple activities for a user
    @PostMapping("/activities/user/{username}")
    private void saveActivitiesForUser(@PathVariable String username, @RequestBody List<Activity> activities) {
        User user = userService.findByUsername(username); // Fetch user by username
        if (user != null) {
            for (Activity activity : activities) {
                activity.setUser(user); // Set the user for each activity
            }
            activityService.saveActivity(activities);
        }
    }

    @GetMapping("/activities/user/{username}")
    private List<Activity> getActivitiesByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return activityService.getActivitiesByUser(user);
        } else {
            return null;
        }
    }

    @PatchMapping("/activities/{id}")
    public Activity updateActivityPartial(@PathVariable int id, @RequestBody Activity updatedActivity) {
        Activity existingActivity = activityService.getActivityById(id);
        if (existingActivity != null) {
            if (updatedActivity.getTitle() != null)
                existingActivity.setTitle(updatedActivity.getTitle());

            if (updatedActivity.getDescription() != null)
                existingActivity.setDescription(updatedActivity.getDescription());

            return activityService.saveSingleActivity(existingActivity);
        } else {
            throw new RuntimeException("Activity not found with id: " + id);
        }
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable int id) {
        try {
            activityService.deleteActivity(id);
            return ResponseEntity.ok("Activity deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
