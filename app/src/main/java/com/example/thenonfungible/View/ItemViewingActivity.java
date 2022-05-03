package com.example.thenonfungible.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;
import com.example.thenonfungible.View.Fragments.MarketFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemViewingActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemviewing);

        // Connect to database
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        Bundle extras = getIntent().getExtras();

        ImageView itemPhoto = (ImageView) findViewById(R.id.itemPhoto);
        TextView itemName = (TextView) findViewById(R.id.itemViewName);
        TextView itemPrice = (TextView) findViewById(R.id.itemPrice);
        TextView specificDescription = (TextView) findViewById(R.id.specificDescription);
        Button purchaseBtn = (Button) findViewById(R.id.puchaseButton);
        Button backBtn = (Button) findViewById(R.id.viewingBack);

        itemName.setText(extras.getString("itemName"));
        itemPrice.setText(extras.getString("itemPrice"));
        specificDescription.setText(extras.getString("itemDescription"));
        Glide.with(this).load(extras.getString("itemImage")).into(itemPhoto);

        purchaseBtn.setOnClickListener(view -> {
            DatabaseReference goodsReference = database.getReference("goods");
            goodsReference.child(extras.getString("itemID")).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        Good currentGood = task.getResult().getValue(Good.class);
                        String oldOwnerId = currentGood.getOwnerId();
                        String currentUserId = mAuth.getCurrentUser().getUid();
                        if (!currentUserId.equals(oldOwnerId)) {
                            // Remove old avatar
                            database.getReference("avatars").child(oldOwnerId).removeValue();
                            // Update owner
                            currentGood.setOwnerId(currentUserId);
                            goodsReference.child(extras.getString("itemID")).setValue(currentGood);
                        }
                    }
                }
            });
            Intent i = new Intent(ItemViewingActivity.this, BottomNaviActivity.class);
            i.putExtra("fromItemViewing", "2");
            startActivity(i);
        });

        backBtn.setOnClickListener(view -> {
            Intent i = new Intent(ItemViewingActivity.this, BottomNaviActivity.class);
            i.putExtra("fromItemViewing", "2");
            startActivity(i);
        });


    }
}
