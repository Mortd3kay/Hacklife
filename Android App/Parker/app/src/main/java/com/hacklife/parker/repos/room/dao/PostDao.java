package com.hacklife.parker.repos.room.dao;

import com.hacklife.parker.repos.room.entities.Post;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PostDao{
    @Insert
    void insert(Post post);

    @Update
    void update(Post post);

    @Delete
    void delete(Post post);

    @Query("select * from post")
    LiveData<List<Post>> getAllPosts();

    @Query("select * from post where type = 'event'")
    LiveData<List<Post>> getAllEvents();

    @Query("select * from post where id = :id")
    LiveData<Post> getPost(int id);

    @Query("select * from post where creator = :id")
    LiveData<Post> getByCreator(int id);

    @Query("select * from post where latitude = :lat and longitude = :lon")
    LiveData<Post> getByCoordinates(double lat, double lon);
}
