package com.hacklife.parker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hacklife.parker.R;
import com.hacklife.parker.fragments.LoginFragment;

public class RegActivity extends FragmentActivity {

    FragmentManager fm;
    private RegViewModel regViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        regViewModel = ViewModelProviders.of(this).get(RegViewModel.class);

        fm = getSupportFragmentManager();
    }

    @Override
    public void onResume(){
        super.onResume();
        fm.beginTransaction().add(R.id.frame, LoginFragment.newInstance(regViewModel,fm)).commit();
        ImageView label = (ImageView) findViewById(R.id.main_label);
        label.setVisibility(View.GONE);
    }
}