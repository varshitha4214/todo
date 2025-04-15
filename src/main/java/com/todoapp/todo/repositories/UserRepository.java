package com.todoapp.todo.repositories;

import com.todoapp.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //User findByUserName(String userName);
    //User findAllUsers();
    //List<User> findAll();
    // User save(User user);

    // Fetch
    //User findById(int id);
    // Fetch user by ID
    //User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findTopByUsername(String username);
    // Fetch user by username
    //List<User> findAll();                       // Fetch all users

    // Save (inherited from JpaRepository)

    // Delete
    //void deleteById(int id);                    // Delete user by ID
    //void delete(User user);                     // Delete by object

}
