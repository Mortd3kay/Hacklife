package com.hacklife.parker.ui.home;

import android.app.Application;

import com.hacklife.parker.repos.ParkerRepository;
import com.hacklife.parker.repos.room.entities.Post;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private ParkerRepository repository;

    public HomeViewModel(Application application) {
        super(application);
        repository = new ParkerRepository(application);
    }

    public void addPost(Post post){
        repository.insert(post);
    }
}