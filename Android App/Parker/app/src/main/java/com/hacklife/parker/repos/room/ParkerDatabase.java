package com.hacklife.parker.repos.room;

import android.content.Context;

import com.hacklife.parker.repos.room.dao.AchievementDao;
import com.hacklife.parker.repos.room.dao.MessageDao;
import com.hacklife.parker.repos.room.dao.PostDao;
import com.hacklife.parker.repos.room.dao.UserDao;
import com.hacklife.parker.repos.room.entities.Achievement;
import com.hacklife.parker.repos.room.entities.Message;
import com.hacklife.parker.repos.room.entities.Post;
import com.hacklife.parker.repos.room.entities.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Achievement.class, Message.class, Post.class}, version = 1)
public abstract class ParkerDatabase extends RoomDatabase {

    private static ParkerDatabase instance;

    public abstract UserDao userDao();

    public abstract MessageDao messageDao();

    public abstract AchievementDao achievementDao();

    public abstract PostDao postDao();

    public static synchronized ParkerDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ParkerDatabase.class,
                    "parker_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
