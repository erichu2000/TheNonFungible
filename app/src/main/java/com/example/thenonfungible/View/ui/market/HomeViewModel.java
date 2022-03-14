package com.example.thenonfungible.View.ui.market;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thenonfungible.R;
import com.example.thenonfungible.View.InventoryActivity;
import com.example.thenonfungible.View.MarketActivity;
import com.example.thenonfungible.View.UserProfileActivity;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Market fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}