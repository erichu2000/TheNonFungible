package com.example.thenonfungible.View;


import android.os.Bundle;
import android.widget.TextView;

import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GetMineActivity extends AppCompatActivity {

    // creating variables for our list view.
    RecyclerView recyclerView;
    private DatabaseReference myRef;
    private  ArrayList<Good> goodsList;
    private RecyclerAdapter recyclerAdapter;
    String Uid;
    String onselling;
    TextView lable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
         onselling = extras.getString("onSelling");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        recyclerView = findViewById(R.id.goodsrecycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lable = (TextView) findViewById(R.id.invLabel);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        Uid = mAuth.getCurrentUser().getUid();
        myRef = FirebaseDatabase.getInstance().getReference();
        goodsList = new ArrayList<>();

        // clear first
        ClearAll();

        // get data function
        GetDataFromFireBase();
    }

    private  void GetDataFromFireBase(){
        Query query = myRef.child("goods");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot  snapshot : dataSnapshot.getChildren()) {
                    Good good = snapshot.getValue(Good.class);
                    if (good.ownerId.equals(Uid)){
                        if (onselling.equals("1")){
                            lable.setText("My Selling");
                            if (good.isOnSale){
                                goodsList.add(good);}
                        }
                        else{
                            lable.setText("My NFT");
                            goodsList.add(good);
                        }
                    }
                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), goodsList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ClearAll(){
        if (goodsList != null){
            goodsList.clear();
            if  (recyclerAdapter!=null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        goodsList = new ArrayList<>();


    }
}
