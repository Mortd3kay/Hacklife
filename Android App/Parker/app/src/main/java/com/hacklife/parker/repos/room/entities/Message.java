package com.hacklife.parker.repos.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "message")
public class Message {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int sender;
    private int post_id;
    private String text;
    private String time;

    public Message(int sender, int post_id, String text, String time) {
        this.sender = sender;
        this.post_id = post_id;
        this.text = text;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getSender() {
        return sender;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }
}
