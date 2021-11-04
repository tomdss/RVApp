package com.example.myapplicationrv2.ui.rvlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myapplicationrv2.R;
import com.example.myapplicationrv2.databinding.ActivityRecycerListBinding;

public class RecyclerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycer_list);
        ActivityRecycerListBinding activityRecycerListBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycer_list);

    }
}