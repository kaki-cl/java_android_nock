package com.example.kakehi.java_android_nock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SampleAsyncTask sampleAsyncTask;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        Button buttonStart = findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ボタンをタップして非同期処理を開始
                sampleAsyncTask = new SampleAsyncTask();
                // Listenerを設定
                sampleAsyncTask.setListener(createListener());
                sampleAsyncTask.execute(0);
            }
        });

        // 数えた数字をリセットするボタン
        Button buttonClear = findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView.setText(String.valueOf(0));
            }
        });
    }

    @Override
    protected void onDestroy() {
        sampleAsyncTask.setListener(null);
        super.onDestroy();
    }

    private SampleAsyncTask.Listener createListener() {
        return new SampleAsyncTask.Listener() {
            @Override
            public void onSuccess(int count) {
                textView.setText(String.valueOf(count));
            }
        };
    }
}
