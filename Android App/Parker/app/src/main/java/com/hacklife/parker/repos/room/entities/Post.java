package com.hacklife.parker.repos.room.entities;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "post")
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int db_id;
    private String title;
    private String desc;
    private boolean business;
    private String creator;
    private String address;
    private double longitude;
    private double latitude;
    private String type;
    private boolean confirmed;
    private int pluses;

    @Ignore
    private LiveData<List<Message>> messages;

    public Post(int db_id, String title, String desc, boolean business, String creator, String address, double longitude, double latitude, String type, boolean confirmed, int pluses) {
        this.db_id = db_id;
        this.title = title;
        this.desc = desc;
        this.business = business;
        this.creator = creator;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
        this.confirmed = confirmed;
        this.pluses = pluses;
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

    public LiveData<List<Message>> getMessages() {
        return messages;
    }

    public void setMessages(LiveData<List<Message>> messages) {
        this.messages = messages;
    }

    public int getPluses() {
        return pluses;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isBusiness() {
        return business;
    }

    public String getCreator() {
        return creator;
    }

    public String getAddress() {
        return address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getType() {
        return type;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
