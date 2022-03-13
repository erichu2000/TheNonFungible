package com.example.thenonfungible.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;

import java.util.ArrayList;
import java.util.List;

public class InventoryRecyclerViewAdapter extends RecyclerView.Adapter<InventoryRecyclerViewAdapter.ViewHolder> {

    private List<Good> goodList;

    public InventoryRecyclerViewAdapter(List<Good> goodList) {
        this.goodList = goodList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_recyclerview_item, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setImageResource(goodList.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return goodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.inventoryRecyclerViewItem);
        }

        public ImageView getTextView() {
            return imageView;
        }
    }
}
