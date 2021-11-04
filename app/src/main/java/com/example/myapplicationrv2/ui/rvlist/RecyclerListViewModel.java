package com.example.myapplicationrv2.ui.rvlist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationrv2.model.User;

import java.util.List;

public class RecyclerListViewModel extends ViewModel {

    private MutableLiveData<List<User>> mListUser;

}
