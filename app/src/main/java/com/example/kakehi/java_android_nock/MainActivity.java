package com.example.kakehi.java_android_nock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MyApp myApp;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApp = (MyApp) this.getApplication();
        editText = findViewById(R.id.edit_text);

        Button buttonMain = findViewById(R.id.button_main);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                myApp.setTestString(message);
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);
            }
        });
    }
}
