package com.example.protectscreenshot.ui.protected_view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProtectedViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProtectedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}