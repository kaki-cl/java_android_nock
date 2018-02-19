package com.example.kakehi.java_android_nock;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kakehi on 2018/02/19.
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false;
    private Button button;
    private LinearLayout.LayoutParams buttonLayoutParams;
    private float scale;
    private int buttonWidth;
    private int margins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        // レイアウト中央寄せ
        layout.setGravity(Gravity.CENTER);
        setContentView(layout);
        // レイアウトファイルは呼ばない
//        setContentView(R.layout.activity_main);

        // テキスト設定
        textView = new TextView(this);
        textView.setText("Hello");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        textView.setTextColor(Color.rgb(0x0, 0x0, 0x0));

        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textLayoutParams);
        layout.addView(textView);

        // ボタンの設定
        Button button = new Button(this);
        button.setText("Button");
        float scale = getResources().getDisplayMetrics().density;
        int buttonWidth = (int) (150 * scale);
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                buttonWidth,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        int margins = (int) (20 * scale);
        buttonLayoutParams.setMargins(margins, margins, margins, margins);

        button.setLayoutParams(buttonLayoutParams);
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag) {
                    textView.setText("Hello");
                    flag = false;
                } else {
                    textView.setText("World");
                    flag = true;
                }
            }
        });


    }


}
