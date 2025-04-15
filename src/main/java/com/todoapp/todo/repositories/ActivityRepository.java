package com.todoapp.todo.repositories;

import com.todoapp.todo.entity.Activity;
import com.todoapp.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    //Activity findById(int activityId);
    //List<Activity> findAll();
    //Activity save(Activity activity);
    List<Activity> findByUser(User user);

    // Fetch
    //Activity findById(int id);                  // Fetch activity by ID
    //List<Activity> findAll();                   // Fetch all activities
    //List<Activity> findByUsername(String username); // Fetch all activities for a user

    //Save (inherited from JpaRepository)
    //Activity save(Activity activity);           // Save or update an activity

    // Delete
    //void deleteById(int id);                    // Delete activity by ID
    //void delete(Activity activity);             // Delete by object
}
