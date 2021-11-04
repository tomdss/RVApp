package com.example.myapplicationrv2.model;

import androidx.annotation.Nullable;

public class User {
    @Nullable
    private String email;
    @Nullable
    private String password;

    public User(@Nullable String email,@Nullable String password) {
        this.email = email;
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
