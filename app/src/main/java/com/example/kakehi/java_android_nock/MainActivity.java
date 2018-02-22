package com.example.kakehi.java_android_nock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeavyTask heavyTask = new HeavyTask();

        // listenerをセット
        heavyTask.setListener(createTestListener());
        // タスクを開始
        heavyTask.taskStart();
    }

    private HeavyTask.SampleListener createTestListener() {
        return new HeavyTask.SampleListener() {
            @Override
            public void onSuccess(int result) {
                Log.d("debug", String.valueOf(result));
            }
        };
    }
}
