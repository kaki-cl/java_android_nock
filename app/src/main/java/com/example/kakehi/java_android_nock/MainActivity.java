package com.example.kakehi.java_android_nock;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by kakehi on 2018/02/19.
 */
public class MainActivity extends AppCompatActivity {

    private Button button[] = new Button[5];
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        layout.setGravity(Gravity.CENTER);

        //背景色
        layout.setBackgroundColor(Color.rgb(0xdd, 0xff, 0xee));
        setContentView(layout);

        float dp = getResources().getDisplayMetrics().density;
        int buttonWidh = (int) (250 * dp);
        int margins = (int) (10 * dp);


        // TextViewの設定
        textView = new TextView(this);
        String str = "TextView";
        textView.setText(str);
        textView.setTextColor(0xff000000);
        textView.setTextSize(10*dp);
        layout.addView(textView,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        // Button[] 配列の設定
        for (int i = 0; i < button.length ; i++) {
            button[i] = new Button(this);
            button[i].setTag(String.valueOf(i));
            button[i].setText(String.format(Locale.JAPAN, "Button %d", i));

            LinearLayout.LayoutParams buttonLayoutParams =
                    new LinearLayout.LayoutParams(buttonWidh,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(margins, margins, margins, margins);

            button[i].setLayoutParams(buttonLayoutParams);
            layout.addView(button[i]);

            // Listnerをセット
            button[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // ViewからTagを取り出す
                    textView.setText(String.format(Locale.JAPAN,
                     "Button: %s", view.getTag().toString()));
                }
            });
        }
    }
}
