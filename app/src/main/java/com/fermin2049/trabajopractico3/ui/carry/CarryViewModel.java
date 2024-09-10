package com.fermin2049.trabajopractico3.ui.carry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CarryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}