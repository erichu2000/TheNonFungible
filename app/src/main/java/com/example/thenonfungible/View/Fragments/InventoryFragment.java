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
import com.example.thenonfungible.View.GetMineActivity;
import com.example.thenonfungible.View.GetMineActivity;

public class InventoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        ImageButton ownedButton = (ImageButton) view.findViewById(R.id.owned);
        ImageButton sellingButton = (ImageButton) view.findViewById(R.id.selling);

        ownedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GetMineActivity.class);
                intent.putExtra("onSelling", "0");
                startActivity(intent);
            }
        });

        sellingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GetMineActivity.class);
                intent.putExtra("onSelling", "1");
                startActivity(intent);
            }
        });


        return view;
    }
}