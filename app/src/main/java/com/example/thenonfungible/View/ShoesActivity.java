package com.example.thenonfungible.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShoesActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    List<Good> shoes = new ArrayList<>();

    private final ShoesAdapter shoesAdapter = new ShoesAdapter(this, shoes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        GridView gridView = (GridView) findViewById(R.id.shoesGrid);
        gridView.setAdapter(shoesAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Save changes in database
                DatabaseReference userAvatarReference = database.getReference("avatars").child(mAuth.getCurrentUser().getUid());
                userAvatarReference.child("pants").setValue(shoes.get(i));
                // Page transition
                startActivity(new Intent(ShoesActivity.this, BottomNaviActivity.class));
            }
        });

        // Get goods reference
        DatabaseReference goodsReference = database.getReference().child("goods");

        final ValueEventListener goodsDataListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> goodsChildren = snapshot.getChildren();

                shoes.clear();

                for (DataSnapshot good : goodsChildren) {
                    Good goodItem = good.getValue(Good.class);
                    if (goodItem.getOwnerId().equals(mAuth.getCurrentUser().getUid()) && goodItem.getItemType().equals("Shoes")) {
                        shoes.add(goodItem);
                    }
                }

                shoesAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        goodsReference.addListenerForSingleValueEvent(goodsDataListener);
    }

}
