package com.hacklife.parker.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hacklife.parker.R;
import com.hacklife.parker.repos.room.entities.Post;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    GoogleMap map;
    AlertDialog.Builder postDialog;
    private boolean isBusiness;
    private double latitude;
    private double longitude;
    private String address;
    private Marker marker;
    private AlertDialog dlg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        View dialog = inflater.inflate(R.layout.map_post_dialog, null);

        final EditText title = (EditText) dialog.findViewById(R.id.title_input);
        final EditText desc = (EditText) dialog.findViewById(R.id.desc_input);
        final EditText phone = (EditText) dialog.findViewById(R.id.phone_input);
        final EditText email = (EditText) dialog.findViewById(R.id.email_input);
        CheckBox business = (CheckBox) dialog.findViewById(R.id.is_business);
        final TextView addressDlg = (TextView) dialog.findViewById(R.id.marker_address);

        business.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    phone.setVisibility(View.VISIBLE);
                    email.setVisibility(View.VISIBLE);
                } else {
                    phone.setVisibility(View.INVISIBLE);
                    email.setVisibility(View.INVISIBLE);
                }
                isBusiness = isChecked;
            }
        });

        postDialog = new AlertDialog.Builder(getContext());
        postDialog.setView(dialog);
        postDialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (title.getText().toString().equals("") && desc.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
                    marker.remove();
                }
                else {
                    homeViewModel.addPost(new Post(0,
                            title.getText().toString(),
                            desc.getText().toString(),
                            phone.getText().toString().equals("") ? null : phone.getText().toString(),
                            email.getText().toString().equals("") ? null : email.getText().toString(),
                            isBusiness,
                            "Unknown",
                            address,
                            longitude,
                            latitude,
                            isBusiness ? "business" : "common",
                            false, 0));
                    title.setText("");
                    desc.setText("");
                    isBusiness = false;
                    longitude = 0;
                    latitude = 0;
                    address = null;
                    dialog.cancel();
                }
            }
        });
        postDialog.setTitle("Метка");

        postDialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                marker.remove();
                marker = null;
                title.setText("");
                desc.setText("");
                isBusiness = false;
                longitude = 0;
                latitude = 0;
                address = null;
            }
        });

        dlg = postDialog.create();

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {

                        marker = map.addMarker(new MarkerOptions().position(latLng));
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
                        dlg.show();

                    }
                });
            }
        });

        return root;
    }
}