package com.hacklife.parker.repos.room.dao;

import com.hacklife.parker.repos.room.entities.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao{
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("select * from user")
    LiveData<List<User>> getAllUsers();

    @Query("select * from user where id = :id")
    LiveData<User> getUser(int id);

}
