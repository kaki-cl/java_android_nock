package com.example.kakehi.java_android_nock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by kakehi on 2018/02/19.
 */
public class MainActivity extends AppCompatActivity {

    private TextView textImageButton;
    private TextView textButton;
    private boolean flg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // イメージボタンを設定
        ImageButton imageButton = findViewById(R.id.image_button);
        // TextViewの設定
        textImageButton = findViewById(R.id.text_imagebutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flg) {
                    textImageButton.setText(R.string.tapped);
                    flg = false;
                } else {
                    textImageButton.setText(R.string.image_button);
                    flg = true;
                }
            }
        });

        // ボタンを設定
        Button button = findViewById(R.id.button);
        // TextViewの設定
        textButton = findViewById(R.id.text_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flg) {
                    textButton.setText(R.string.tapped);
                    flg = false;
                } else {
                    textButton.setText(R.string.button);
                    flg = true;
                }
            }
        });
    }
}
