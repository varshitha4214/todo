package com.todoapp.todo.controllers;

import com.todoapp.todo.entity.User;
import com.todoapp.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    private String  getUser(@RequestBody User user) {
        User resp = userService.getUser(user);
        if (resp != null){
            return "login success!!!";
        } else {
            return "login failed!!!";
        }
    }

    @PostMapping("/user")
    private boolean saveUser(@RequestBody User user) {
        boolean userExists = userService.findUserByUsername(user.getUsername());

        if (userExists) {
            System.out.println("User Exists already!!!");
            return false;
        } else {
            userService.saveUser(user);
            return true;
        }
    }
    @PostMapping("/users")
    private void saveUsers(@RequestBody List<User> users) {
        userService.saveUsers(users);
    }

    @GetMapping("/users")
    private List<User> fetchUsers() {
        return userService.fetchUsers();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

