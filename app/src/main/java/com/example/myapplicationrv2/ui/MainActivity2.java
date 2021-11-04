package com.example.myapplicationrv2.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationrv2.R;
import com.example.myapplicationrv2.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button btnNumber;
    private TextView btnT, btnX;
    private ImageButton btnReset;
    private ProgressBar progressBar;
    private TextView tvNum1, tvNum2, tvNum3;
    private LinearLayout llResult, llTX;
    private int number = 0;

    public static final String TAG = MainActivity2.class.getSimpleName();

    public static String stateSelect = CommonUtils.StateSelect.STATE_N;

    private ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }

    private void initViews() {
        textView = findViewById(R.id.text);
        btnNumber = findViewById(R.id.btnNumber);
        progressBar = findViewById(R.id.progressBar);
        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        tvNum3 = findViewById(R.id.tvNum3);
        btnT = findViewById(R.id.btnT);
        btnX = findViewById(R.id.btnX);
        btnReset = findViewById(R.id.btnReset);
        btnNumber.setOnClickListener(this);
        btnT.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    private void registerObserver(Observable<Long> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long integer) {
                Log.d(TAG, "onNext THREAD = " + Thread.currentThread().getName());
                Log.d(TAG, "onNext object = " + integer);
                progressBar.setProgress(Integer.valueOf(integer.toString()));
                if (integer == 100L) {
                    btnNumber.setEnabled(true);
                    btnT.setEnabled(false);
                    btnX.setEnabled(false);
                    btnNumber.setText("select");
                    btnNumber.setEnabled(false);
                    registerObserver2(observable);

                }
                textView.setText("SELECT = " + stateSelect + "  *  Number = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void registerObserver2(Observable<Long> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long integer) {
                Log.d(TAG, "onNext THREAD = " + Thread.currentThread().getName());
                Log.d(TAG, "onNext object = " + integer);
                progressBar.setProgress(100 - Integer.valueOf(integer.toString()));
                textView.setText("SELECT = " + stateSelect + "  *  Number = " + (100L - integer));
                int num1 = 1, num2 = 1, num3 = 1;
                if (integer % 2 == 0) {
                    num1 = new Random().nextInt(6) + 1;
                    tvNum1.setText("" + num1);
                    num2 = new Random().nextInt(6) + 1;
                    tvNum2.setText("" + num2);
                    num3 = new Random().nextInt(6) + 1;
                    tvNum3.setText("" + num3);
                }
                if (integer == 100L) {
                    btnNumber.setEnabled(true);
                    CheckResult(num1 + num2 + num3);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void CheckResult(int i) {
        switch (stateSelect) {
            case CommonUtils.StateSelect.STATE_T:
                if (i >= 11 && i <= 17) {
                    textView.setText("W");
                } else {
                    textView.setText("L");
                }
                break;
            case CommonUtils.StateSelect.STATE_X:
                if (i >= 4 && i <= 10) {
                    textView.setText("W");
                } else {
                    textView.setText("L");
                }
                break;
            case CommonUtils.StateSelect.STATE_N:
                textView.setText("D");
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnNumber:
                Observable<Long> observable = Observable.interval(
                        25, TimeUnit.MILLISECONDS, Schedulers.io()
                ).takeWhile(it -> it <= 100L);
                if (btnNumber.getText().equals("select")) {
                    btnT.setSelected(false);
                    btnX.setSelected(false);
                    registerObserver(observable);
                    btnNumber.setText("run");
                    btnNumber.setEnabled(false);
                    btnT.setEnabled(true);
                    btnX.setEnabled(true);
                    tvNum1.setText("N1");
                    tvNum2.setText("N2");
                    tvNum3.setText("N3");
                }
                break;
            case R.id.btnT:
                stateSelect = CommonUtils.StateSelect.STATE_T;
                btnT.setSelected(true);
                btnX.setSelected(false);
                break;
            case R.id.btnX:
                stateSelect = CommonUtils.StateSelect.STATE_X;
                btnT.setSelected(false);
                btnX.setSelected(true);
                break;
            case R.id.btnReset:
                stateSelect = CommonUtils.StateSelect.STATE_N;
                btnT.setSelected(false);
                btnX.setSelected(false);
                break;
        }
    }
}