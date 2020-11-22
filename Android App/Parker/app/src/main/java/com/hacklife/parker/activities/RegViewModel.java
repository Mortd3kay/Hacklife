package com.hacklife.parker.activities;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RegViewModel extends AndroidViewModel {
    private String email = "";
    private String password = "";
    public RegViewModel(@NonNull Application application) {
        super(application);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
