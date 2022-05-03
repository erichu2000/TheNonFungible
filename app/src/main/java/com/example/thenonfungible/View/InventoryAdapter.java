package com.example.thenonfungible.View;

import android.content.Context;
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
import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {
    private Context mContext;
    private List<Good> goodList;
    private DatabaseReference myRef;

    public InventoryAdapter(Context mContext, List<Good> goodList){
        this.mContext = mContext;
        this.goodList = goodList;

    }
    @NonNull
    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull InventoryAdapter.ViewHolder holder, int position) {
        holder.textNameView.setText(goodList.get(position).getName());
        holder.textPriceView.setText(goodList.get(position).getPrice());
        boolean onSale = goodList.get(position).isOnSale();
        String goodId = goodList.get(position).getGoodId();
        String goodName = goodList.get(position).getName();
        if (onSale){
            setButtonStatus(holder.sellButton, false);
            setButtonStatus(holder.stopSellButton, true);
        }
        else{
            setButtonStatus(holder.sellButton, true);
            setButtonStatus(holder.stopSellButton, false);
        }
        myRef = FirebaseDatabase.getInstance().getReference();
        holder.sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("goods").child(goodId).child("onSale").setValue(true);
                myRef.child("goods").child(goodId).child("onSale_name").setValue("true_" + goodName);
                setButtonStatus(holder.sellButton, false);
                setButtonStatus(holder.stopSellButton, true);
            }
        });

        holder.stopSellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("goods").child(goodId).child("onSale").setValue(false);
                myRef.child("goods").child(goodId).child("onSale_name").setValue("false_" + goodName);
                setButtonStatus(holder.sellButton, true);
                setButtonStatus(holder.stopSellButton, false);
            }
        });
        Glide.with(mContext).load(goodList.get(position).getItemImageID()).into(holder.imageView);
    }

    private void setButtonStatus(Button button, boolean status) {
        button.setClickable(status);
        button.setEnabled(status);
    }

    @Override
    public int getItemCount() {
        return goodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
