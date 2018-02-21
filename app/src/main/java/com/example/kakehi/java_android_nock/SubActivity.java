package com.example.kakehi.java_android_nock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        MyApp myApp = (MyApp) this.getApplication();
        String str = myApp.getTestString();

        TextView textViewSub = findViewById(R.id.textview_sub);
        textViewSub.setText(str);
    }
}
