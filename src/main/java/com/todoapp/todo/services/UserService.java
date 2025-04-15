package com.todoapp.todo.services;

import com.todoapp.todo.entity.User;
import com.todoapp.todo.repositories.UserRepository;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method to get user by username
    public User findByUsername(String username) {
        return userRepository.findTopByUsername(username); // Retrieve a user by username
    }

        public User getUser(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public boolean findUserByUsername(String username) {
        boolean username_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username present (U): " + username_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present;
    }

    public void saveUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
