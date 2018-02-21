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

    private TextView textView;
    static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        final EditText editText = (EditText)findViewById(R.id.edit_text);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                if (editText.getText() != null) {
                    String str = editText.getText().toString();
                    intent.putExtra("MESSAGE1", str);
                    editText.setText("");
                }
                startActivityForResult(intent, RESULT_SUBACTIVITY);
            }
        });
    }

    // SubAcitivity からの返しの結果を受け取る
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY && null != intent) {
            String res = intent.getStringExtra("MESSAGE2");
            textView.setText(res);
        }
    }
}
