package com.example.thenonfungible.View.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;
import com.example.thenonfungible.View.InventoryAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InventoryFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    List<Good> ownedGoods = new ArrayList<>();
    private InventoryAdapter inventoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        RecyclerView inventoryRecyclerView = view.findViewById(R.id.goodsrecycle);
        TextView inventoryTitle = view.findViewById(R.id.invLabel);

        inventoryAdapter = new InventoryAdapter(view.getContext(), ownedGoods);
        inventoryRecyclerView.setAdapter(inventoryAdapter);
        inventoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        getItemFromFirebase();

        return view;
    }

    private void getItemFromFirebase() {
        DatabaseReference goodsReference = database.getReference("goods");
        final ValueEventListener goodsDataListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> goodsChildren = snapshot.getChildren();
                ownedGoods.clear();
                for (DataSnapshot good : goodsChildren) {
                    Good goodItem = good.getValue(Good.class);
                    if (goodItem.getOwnerId().equals(mAuth.getCurrentUser().getUid())) {
                        ownedGoods.add(goodItem);
                    }
                }
                inventoryAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        goodsReference.addListenerForSingleValueEvent(goodsDataListener);
    }
}