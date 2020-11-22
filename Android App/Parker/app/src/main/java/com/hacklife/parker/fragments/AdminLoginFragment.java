package com.hacklife.parker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hacklife.parker.R;
import com.hacklife.parker.activities.RegViewModel;

public class AdminLoginFragment extends Fragment {

    private RegViewModel viewModel;
    private FragmentManager fm;
    private EditText email;
    private EditText pass;

    public AdminLoginFragment() {
    }

    public static AdminLoginFragment newInstance(RegViewModel viewModel, FragmentManager fm) {
        AdminLoginFragment fragment = new AdminLoginFragment();
        fragment.fm = fm;
        fragment.viewModel = viewModel;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_admin_login, container, false);
        Button log_to_adm = (Button) v.findViewById(R.id.adm_to_log);
        Button login = (Button) v.findViewById(R.id.adm_login_btn);
        Button reg = (Button) v.findViewById(R.id.adm_reg_btn);
        email = (EditText) v.findViewById(R.id.email_admLogin_input);
        pass = (EditText) v.findViewById(R.id.pass_admLogin_input);

        log_to_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame, LoginFragment.newInstance(viewModel, fm)).addToBackStack(null).commit();
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        email.setText(viewModel.getEmail());
        pass.setText(viewModel.getPassword());
    }
}