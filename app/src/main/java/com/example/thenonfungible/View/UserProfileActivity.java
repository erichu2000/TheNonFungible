package com.example.thenonfungible.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thenonfungible.R;

public class UserProfileActivity extends AppCompatActivity {

    ImageView userAvatar;
    Button inventoryButton;
    Button marketButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        inventoryButton = findViewById(R.id.inventoryButton);
        marketButton = findViewById(R.id.marketButton);
        userAvatar = findViewById(R.id.userAvatar);

        inventoryButton.setOnClickListener( view -> {
            startActivity(new Intent(UserProfileActivity.this, InventoryActivity.class));
        });

        marketButton.setOnClickListener(view -> {
            startActivity(new Intent(UserProfileActivity.this, MarketActivity.class));
        });

        userAvatar.setImageResource(getResources().getIdentifier("@drawable/avatar", null, this.getPackageName()));
    }
}
