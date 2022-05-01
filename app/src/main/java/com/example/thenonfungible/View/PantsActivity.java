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

public class PantsActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    List<Good> pants = new ArrayList<>();

    private final PantsAdapter pantsAdapter = new PantsAdapter(this, pants);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pants);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        GridView gridView = (GridView) findViewById(R.id.pantsGrid);
        gridView.setAdapter(pantsAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Save changes in database
                DatabaseReference userAvatarReference = database.getReference("avatars").child(mAuth.getCurrentUser().getUid());
                userAvatarReference.child("pants").setValue(pants.get(i));
                // Page transition
                startActivity(new Intent(PantsActivity.this, BottomNaviActivity.class));
            }
        });

        // Get goods reference
        DatabaseReference goodsReference = database.getReference().child("goods");

        final ValueEventListener goodsDataListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> goodsChildren = snapshot.getChildren();

                pants.clear();

                for (DataSnapshot good : goodsChildren) {
                    Good goodItem = good.getValue(Good.class);
                    if (goodItem.getOwnerId().equals(mAuth.getCurrentUser().getUid()) && goodItem.getItemType().equals("Pants")) {
                        pants.add(goodItem);
                    }
                }

                pantsAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        goodsReference.addListenerForSingleValueEvent(goodsDataListener);
    }





}
