package com.example.thenonfungible.View;

import android.os.Bundle;

import com.example.thenonfungible.View.Fragments.InventoryFragment;
import com.example.thenonfungible.View.Fragments.MarketFragment;
import com.example.thenonfungible.View.Fragments.MeFragment;
import com.example.thenonfungible.R;
import com.example.thenonfungible.databinding.ActivityBottomNaviBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class BottomNaviActivity extends AppCompatActivity {

    private ActivityBottomNaviBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBottomNaviBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.me:
                    replaceFragment(new MeFragment());
                    break;
                case R.id.inventory:
                    replaceFragment(new InventoryFragment());
                    break;
                case R.id.market:
                    replaceFragment(new MarketFragment());
                    break;
            }
            return true;
        });

        String data = getIntent().getStringExtra("fromItemViewing");
        if (data != null && data.contentEquals("2")) {
            bottomNavigationView.setSelectedItemId(R.id.market);
            replaceFragment(new MarketFragment());
        } else {
            replaceFragment(new MeFragment());
        }


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


}