package com.todoapp.todo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Many-to-One relationship with User
    /*@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Foreign key column
    private User user;*/

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    //@Column(name="username")
    //private String username;
    private String title;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
