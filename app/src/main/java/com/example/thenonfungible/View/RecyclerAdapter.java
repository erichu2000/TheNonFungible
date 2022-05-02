package com.example.thenonfungible.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private  static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<Good> goodList;
    private DatabaseReference myRef;

    public RecyclerAdapter(Context mContext, ArrayList<Good> goodList){
        this.mContext = mContext;
        this.goodList = goodList;

    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return  new ViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textNameView.setText(goodList.get(position).getName());
        holder.textPriceView.setText(goodList.get(position).getPrice());
        Boolean isOnsale = goodList.get(position).isOnSale;
        String goodId = goodList.get(position).getGoodId();
        if (isOnsale){
            holder.sellButton.setClickable(false);
            holder.sellButton.setEnabled(false);
            holder.stopSellButton.setClickable(true);
            holder.stopSellButton.setEnabled(true);
        }
        else{
            holder.sellButton.setClickable(true);
            holder.sellButton.setEnabled(true);
            holder.stopSellButton.setClickable(false);
            holder.stopSellButton.setEnabled(false);
        }
        myRef = FirebaseDatabase.getInstance().getReference();
        holder.sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("goods").child(goodId).child("isOnSale").setValue(true);
            }
        });

        holder.stopSellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("goods").child(goodId).child("isOnSale").setValue(false);
            }
        });

        Glide.with(mContext).load(goodList.get(position).getItemImageID()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return goodList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textNameView;
        TextView textPriceView;
        Button sellButton;
        Button stopSellButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            textNameView = itemView.findViewById(R.id.itemName);
            textPriceView = itemView.findViewById(R.id.itemPrice);
            sellButton = itemView.findViewById(R.id.sellButton);
            stopSellButton = itemView.findViewById(R.id.stopSellButton);

        }
    }
}
