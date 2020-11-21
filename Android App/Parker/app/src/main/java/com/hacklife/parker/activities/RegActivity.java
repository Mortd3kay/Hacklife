package com.hacklife.parker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.hacklife.parker.R;
import com.hacklife.parker.fragments.LoginFragment;

public class RegActivity extends AppCompatActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.frame, LoginFragment.newInstance(null, null)).commit();
    }
}