package com.hacklife.parker.repos.room.dao;

import com.hacklife.parker.repos.room.entities.Achievement;
import com.hacklife.parker.repos.room.entities.Message;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MessageDao{

    @Insert
    void insert(Message message);

    @Update
    void update(Message message);

    @Delete
    void delete(Message message);

    @Query("select * from message where post_id = :id")
    LiveData<List<Message>> getByPostId(int id);

}
