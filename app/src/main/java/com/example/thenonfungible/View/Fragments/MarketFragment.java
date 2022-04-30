package com.example.thenonfungible.View.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thenonfungible.Model.Good;
import com.example.thenonfungible.R;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MarketFragment extends Fragment implements View.OnClickListener {

    private EditText mSearchField;
    private ImageButton mSearchBtn;

    private RecyclerView mResultList;
    private DatabaseReference mGoodDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        mSearchField = (EditText) view.findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) view.findViewById(R.id.searchBtn);
        mResultList = (RecyclerView) view.findViewById(R.id.result_list);

        mResultList.setLayoutManager(new LinearLayoutManager(getActivity()));

        mGoodDatabase = FirebaseDatabase.getInstance().getReference("goods");

        fireBaseSearch("");

        mSearchBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchBtn:
                String searchName = mSearchField.getText().toString();
                fireBaseSearch(searchName);
                break;
        }
    }

    private void fireBaseSearch(String searchName) {
        FirebaseRecyclerOptions<Good> options = new FirebaseRecyclerOptions.Builder<Good>().setQuery(mGoodDatabase.orderByChild("name").startAt(searchName), Good.class).build();

        FirebaseRecyclerAdapter firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Good, GoodsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull GoodsViewHolder holder, int position, @NonNull Good model) {
               holder.setDetails(getActivity(), model.getName(),model.getPrice(),model.getItemImageID());
            }

            @NonNull
            @Override
            public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
                return new GoodsViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class GoodsViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setDetails(FragmentActivity activity, String item_name, String item_price, String item_image) {
            TextView itemName = (TextView) mView.findViewById(R.id.itemDisplayName);
            TextView itemPrice = (TextView) mView.findViewById(R.id.itemDisplayPrice);
            ImageButton itemImage = (ImageButton) mView.findViewById(R.id.itemDisplayButton);
            itemName.setText(item_name);
            itemPrice.setText(item_price);
            Glide.with(activity).load(item_image).into(itemImage);
        }

    }
}