package com.example.myapplicationrv2.ui.login;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.myapplicationrv2.BR;

public class LoginViewModel extends BaseObservable {

    private String email;
    private String password;

    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isLoginSuccess = new ObservableField<>();
    public ObservableField<Boolean> isClickLogin = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin() {
        isClickLogin.set(true);
        if (!TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() && getPassword().length() > 5) {
            isLoginSuccess.set(true);
            messageLogin.set("Login Success");
        } else {
            isLoginSuccess.set(false);
            messageLogin.set("Login Invalid");
        }
    }


}
