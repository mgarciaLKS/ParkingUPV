package com.lksnext.parking.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> userName;

    public MainViewModel() {
        //Initialize the userName MutableLiveData
        userName = new MutableLiveData<>();
    }

    /**
     * Get the userName as a MutableLiveData object for two-way binding
     * @return the userName
     */
    public MutableLiveData<String> getUserName() {
        return userName;
    }
}
