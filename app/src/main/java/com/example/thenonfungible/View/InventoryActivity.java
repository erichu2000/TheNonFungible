package com.example.thenonfungible.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {

    RecyclerView inventoryRecyclerView;
    List<Good> goodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        inventoryRecyclerView = findViewById(R.id.inventoryRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                InventoryActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        inventoryRecyclerView.setLayoutManager(layoutManager);
        inventoryRecyclerView.setItemAnimator(new DefaultItemAnimator());

        goodList = new ArrayList<>();
        fillGoods();

        InventoryRecyclerViewAdapter adapter = new InventoryRecyclerViewAdapter(goodList);

        inventoryRecyclerView.setAdapter(adapter);
    }

    private void fillGoods() {
        Good A = new Good();
        A.setImageResource(getResources().getIdentifier("@drawable/tshirt1", null, this.getPackageName()));
        Good B = new Good();
        B.setImageResource(getResources().getIdentifier("@drawable/tshirt2", null, this.getPackageName()));
        Good C = new Good();
        C.setImageResource(getResources().getIdentifier("@drawable/tshirt3", null, this.getPackageName()));
        goodList.add(A);
        goodList.add(B);
        goodList.add(C);
    }
}
