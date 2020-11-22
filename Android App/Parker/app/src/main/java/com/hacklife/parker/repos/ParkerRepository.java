package com.hacklife.parker.repos;

import android.app.Application;
import android.os.AsyncTask;

import com.hacklife.parker.repos.room.ParkerDatabase;
import com.hacklife.parker.repos.room.dao.AchievementDao;
import com.hacklife.parker.repos.room.dao.MessageDao;
import com.hacklife.parker.repos.room.dao.PostDao;
import com.hacklife.parker.repos.room.dao.UserDao;
import com.hacklife.parker.repos.room.entities.Achievement;
import com.hacklife.parker.repos.room.entities.Message;
import com.hacklife.parker.repos.room.entities.Post;
import com.hacklife.parker.repos.room.entities.User;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ParkerRepository {

    private UserDao userDao;
    private AchievementDao achievementDao;
    private MessageDao messageDao;
    private PostDao postDao;

    private ParkerDatabase database;

    private LiveData<List<Achievement>> achievements;
    private LiveData<List<Post>> posts;

    public ParkerRepository(Application application) {
        database = ParkerDatabase.getInstance(application);
        userDao = database.userDao();
        achievementDao = database.achievementDao();
        messageDao = database.messageDao();
        postDao = database.postDao();

        achievements = achievementDao.getAllAchievements();
        posts = postDao.getAllPosts();
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao dao;

        public InsertUserAsyncTask(UserDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... entities) {

            dao.insert(entities[0]);

            return null;
        }
    }

    private static class InsertPostAsyncTask extends AsyncTask<Post, Void, Void> {

        private PostDao dao;

        public InsertPostAsyncTask(PostDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Post... entities) {

            dao.insert(entities[0]);

            return null;
        }
    }

    private static class InsertMessageAsyncTask extends AsyncTask<Message, Void, Void> {

        private MessageDao dao;

        public InsertMessageAsyncTask(MessageDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Message... entities) {

            dao.insert(entities[0]);

            return null;
        }
    }

    private static class InsertAchievAsyncTask extends AsyncTask<Achievement, Void, Void> {

        private AchievementDao dao;

        public InsertAchievAsyncTask(AchievementDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Achievement... entities) {

            dao.insert(entities[0]);

            return null;
        }
    }

    private static class UpdatePostAsyncTask extends AsyncTask<Post, Void, Void> {

        private PostDao dao;

        public UpdatePostAsyncTask(PostDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Post... entities) {

            dao.update(entities[0]);

            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao dao;

        public UpdateUserAsyncTask(UserDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... entities) {

            dao.update(entities[0]);

            return null;
        }
    }

    public void insert(User user) {
        new InsertUserAsyncTask(userDao).execute(user);
    }

    public void insert(Message message) {
        new InsertMessageAsyncTask(messageDao).execute(message);
    }

    public void insert(Achievement achievement) {
        new InsertAchievAsyncTask(achievementDao).execute(achievement);
    }

    public void insert(Post post) {
        new InsertPostAsyncTask(postDao).execute(post);
    }

//    public void insertUsers(LiveData<List<User>> users) {
//
//    }
//
//    public void insertMessages(LiveData<List<Message>> messages) {
//
//    }
//
//    public void insertAchievements(LiveData<List<Achievement>> achievements) {
//
//    }
//
//    public void insertPosts(LiveData<List<Post>> posts) {
//
//    }

    public void update(User user) {
        new UpdateUserAsyncTask(userDao).execute(user);
    }

    public void update(Post post) {
        new UpdatePostAsyncTask(postDao).execute(post);
    }

//    public void updateUsers(LiveData<List<User>> users) {
//
//    }
//
//    public void updatePosts(LiveData<List<Post>> posts) {
//
//    }

    public LiveData<List<Achievement>> getAchievements() {
        return achievements;
    }

    public LiveData<User> getUserById(int id) {
        return userDao.getUser(id);
    }

    public LiveData<List<Message>> getMessagesByPostId(int id) {
        return messageDao.getByPostId(id);
    }

    public LiveData<List<Post>> getEvents() {
        return postDao.getAllEvents();
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }

    public LiveData<Post> getPostsByCoordinates(double lat, double lon) {
        return postDao.getByCoordinates(lat, lon);
    }
}
