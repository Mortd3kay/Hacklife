package com.hacklife.parker.repos.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int db_id;
    private String lastName;
    private String firstName;
    private String secondName;
    private String email;
    private String type;

    public User(int db_id, String lastName, String firstName, String secondName, String email, String type) {
        this.db_id = db_id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDb_id() {
        return db_id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }
}
