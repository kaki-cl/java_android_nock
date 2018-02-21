package com.example.kakehi.java_android_nock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private EditText editText;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // MainActivityからのデータを受け取る
        final Intent intent = getIntent();
        message = intent.getStringExtra("MESSAGE1");

        TextView textView = findViewById(R.id.text_view);
        textView.setText(message);

        editText = (EditText) findViewById(R.id.edit_text);

        // MainActivity へ戻るボタン
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent();
                if (editText.getText() != null) {
                    //messageはmainで入力されたもの
                    String str = message + editText.getText().toString();
                    intent.putExtra("MESSAGE2", str);
                    editText.setText("");
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

}
