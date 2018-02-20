package com.example.kakehi.java_android_nock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by kakehi on 2018/02/19.
 */
public class MainActivity extends AppCompatActivity {

    private TextView textImageButton;
    private boolean flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextViewの設定
        textImageButton = findViewById(R.id.text_view);

        // イメージボタンを設定
        ImageButton imageButton = findViewById(R.id.image_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flg) {
                    textImageButton.setText(R.string.touchme);
                    flg = false;
                } else {
                    textImageButton.setText(R.string.thanks);
                    flg = true;
                }
            }
        });
    }
}
