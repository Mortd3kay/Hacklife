package com.hacklife.parker.repos.room.dao;

import com.hacklife.parker.repos.room.entities.Achievement;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AchievementDao{
    @Insert
    void insert(Achievement achievement);

    @Update
    void update(Achievement achievement);

    @Delete
    void delete(Achievement achievement);

    @Query("select * from achiev where id = :id")
    LiveData<List<Achievement>> getAchievement(int id);

    @Query("select * from achiev")
    LiveData<List<Achievement>> getAllAchievements();
}
