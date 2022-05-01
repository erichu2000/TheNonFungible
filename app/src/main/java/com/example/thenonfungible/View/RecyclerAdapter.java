package com.example.thenonfungible.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private  static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<Good> goodList;

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
        holder.textView.setText(goodList.get(position).getName());
        Glide.with(mContext).load(goodList.get(position).getItemImageID()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return goodList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            textView = itemView.findViewById(R.id.item_text);
        }
    }
}
