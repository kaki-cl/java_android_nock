package com.example.kakehi.java_android_nock;

import android.app.Application;

public class MyApp extends Application {

    private String testString = "default";

    public void onCreate() {
        super.onCreate();
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String str) {
        testString = str;
    }
}
