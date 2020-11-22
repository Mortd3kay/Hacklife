package com.hacklife.parker.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.hacklife.parker.R;
import com.hacklife.parker.activities.MainActivity;
import com.hacklife.parker.activities.RegViewModel;

public class RegFragment extends Fragment {

    private RegViewModel regViewModel;
    private FragmentManager fm;
    private EditText email;
    private EditText pass;

    public RegFragment() {
        // Required empty public constructor
    }

    public static RegFragment newInstance(RegViewModel viewModel, FragmentManager fm) {
        RegFragment fragment = new RegFragment();
        fragment.fm = fm;
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
        View v = inflater.inflate(R.layout.fragment_reg, container, false);
        email = (EditText) v.findViewById(R.id.email_reg_input);
        final EditText fio = (EditText) v.findViewById(R.id.fio_reg_input);
        final EditText city = (EditText) v.findViewById(R.id.city_reg_input);
        pass = (EditText) v.findViewById(R.id.pass_reg_input);
        final CheckBox isAdmin = (CheckBox) v.findViewById(R.id.is_admin);
        Button reg = (Button) v.findViewById(R.id.reg_reg_btn);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("")&& !fio.getText().toString().equals("")&&!city.getText().toString().equals("")&&!pass.getText().toString().equals("")) {
                    if (isAdmin.isChecked()){
                        ///переход в панель для представителей администрации
                    } else {
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                }
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