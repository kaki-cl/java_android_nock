package com.example.kakehi.java_android_nock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private UploadTask task;
    private TextView textView;
    private EditText editText;
    String url = "http://10.0.2.2:8000/pass_check.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        editText = findViewById(R.id.uriname);
        Button post = findViewById(R.id.post);

        // ボタンを押して非同期処理を開始
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String param0 = editText.getText().toString();
                if (param0.length() != 0) {
                    task = new UploadTask();
                    task.setListener(createListener());
                    task.execute(param0);
                }
            }
        });

        Button browser = findViewById(R.id.browser);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                textView.setText("");
            }
        });
    }

    @Override
    protected void onDestroy() {
        task.setListener(null);
        super.onDestroy();
    }

    private UploadTask.UploadListener createListener() {
        return new UploadTask.UploadListener() {
            @Override
            public void onSuccess(String count) {
                textView.setText(String.valueOf(count));
            }
        };
    }
}
