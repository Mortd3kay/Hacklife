package com.hacklife.parker.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hacklife.parker.R;
import com.hacklife.parker.activities.MainActivity;
import com.hacklife.parker.activities.RegViewModel;


public class LoginFragment extends Fragment {

    private FragmentManager fm;
    private RegViewModel regViewModel;
    private EditText email;
    private EditText pass;


    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance(RegViewModel viewModel, FragmentManager fragmentManager) {
        LoginFragment fragment = new LoginFragment();
        fragment.fm = fragmentManager;
        fragment.regViewModel = viewModel;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        Button log_to_adm = (Button) v.findViewById(R.id.log_to_adm);
        Button login = (Button) v.findViewById(R.id.login_btn);
        Button reg = (Button) v.findViewById(R.id.reg_btn);
        email = (EditText) v.findViewById(R.id.email_Login_input);
        pass = (EditText) v.findViewById(R.id.pass_Login_input);

        log_to_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame, AdminLoginFragment.newInstance(regViewModel, fm)).commit();
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame, RegFragment.newInstance(regViewModel, fm)).addToBackStack(null).commit();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !pass.getText().toString().equals("")) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else Toast.makeText(getContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        email.setText(regViewModel.getEmail());
        pass.setText(regViewModel.getPassword());
    }
}