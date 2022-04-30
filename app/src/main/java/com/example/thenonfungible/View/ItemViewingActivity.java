package com.example.thenonfungible.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.R;
import com.example.thenonfungible.View.Fragments.MarketFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemViewingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemviewing);

        String receivedItemName;

        ImageView itemPhoto = (ImageView) findViewById(R.id.itemPhoto);
        TextView itemName = (TextView) findViewById(R.id.itemViewName);
        TextView description = (TextView) findViewById(R.id.descriptionTitle);
        TextView itemPrice = (TextView) findViewById(R.id.itemPrice);
        TextView specificDescription = (TextView) findViewById(R.id.specificDescription);
        ImageButton purchaseBtn = (ImageButton) findViewById(R.id.puchaseButton);

        //Glide.with(this).load(Image_URL).into(itemPhoto);

        purchaseBtn.setOnClickListener(view -> {
            startActivity(new Intent(ItemViewingActivity.this, MarketFragment.class));
        });


    }
}
