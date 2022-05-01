package com.example.thenonfungible.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.Model.Avatar;
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

public class ClothingAdapter extends BaseAdapter {
    private Context context;
    List<Good> clothing;

    // Constructor
    public ClothingAdapter(Context c, List<Good> clothing) {
        context = c;
        // Set up database instance
        this.clothing = clothing;
    }

    @Override
    public int getCount() {
        return clothing.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.gridview_item, viewGroup, false);
        }

        ImageView imageView = view.findViewById(R.id.icon);

        Good currentClothing = clothing.get(i);

        Glide.with(context).load(currentClothing.getItemImageID()).into(imageView);

        return view;
    }
}
