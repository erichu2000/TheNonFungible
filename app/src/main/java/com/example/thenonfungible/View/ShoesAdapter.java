package com.example.thenonfungible.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;

import java.util.List;

public class ShoesAdapter extends BaseAdapter {
    private Context context;
    List<Good> shoes;

    // Constructor
    public ShoesAdapter(Context c, List<Good> shoes) {
        context = c;
        // Set up database instance
        this.shoes = shoes;
    }

    @Override
    public int getCount() {
        return shoes.size();
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

        Good currentShoes = shoes.get(i);

        Glide.with(context).load(currentShoes.getItemImageID()).into(imageView);

        return view;
    }

}
