package com.example.myapplicationrv2.ui.sicbo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SicboViewModel extends ViewModel {

    private MutableLiveData<Integer> resultLiveData;

    public LiveData<Integer> getResult() {
        if (resultLiveData != null) {
            resultLiveData = getResultData();
        }
        return resultLiveData;
    }

    private MutableLiveData<Integer> getResultData() {
       return null;
    }

}
