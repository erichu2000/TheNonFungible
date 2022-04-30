package com.example.thenonfungible.View.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thenonfungible.R;
import com.example.thenonfungible.View.MeShowme;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    private DatabaseReference database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        // Grab database reference
        database = FirebaseDatabase.getInstance().getReference();


        // Reference for clothing, pants, and shoes image button
        ImageButton clothing = (ImageButton) view.findViewById(R.id.clothing);
        ImageButton pants = (ImageButton) view.findViewById(R.id.pants);
        ImageButton shoes = (ImageButton) view.findViewById(R.id.shoes);





        return view;


    }
}