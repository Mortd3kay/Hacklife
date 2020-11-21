package com.hacklife.parker.repos.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "achiev")
public class Achievement {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String src;

    public Achievement(String name, String src) {
        this.name = name;
        this.src = src;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSrc() {
        return src;
    }
}
