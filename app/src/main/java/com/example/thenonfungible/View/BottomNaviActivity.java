package com.example.thenonfungible.View;

import android.os.Bundle;

import com.example.thenonfungible.View.Fragments.CategoryFragment;
import com.example.thenonfungible.View.Fragments.HomeFragment;
import com.example.thenonfungible.View.Fragments.MeFragment;
import com.example.thenonfungible.View.Fragments.MessageFragment;
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

        replaceFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home2:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.category:
                    replaceFragment(new CategoryFragment());
                    break;
                case R.id.message2:
                    replaceFragment(new MessageFragment());
                    break;
                case R.id.me:
                    replaceFragment(new MeFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


}