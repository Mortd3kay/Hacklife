package com.hacklife.parker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hacklife.parker.R;

public class RegFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EMAIL = "email";
    private static final String PASS = "pass";

    // TODO: Rename and change types of parameters
    private String email;
    private String pass;

    public RegFragment() {
        // Required empty public constructor
    }

    public static RegFragment newInstance(String email, String pass) {
        RegFragment fragment = new RegFragment();
        Bundle args = new Bundle();
        args.putString(EMAIL, email);
        args.putString(PASS, pass);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            email = getArguments().getString(EMAIL);
            pass = getArguments().getString(PASS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        return v;
    }
}