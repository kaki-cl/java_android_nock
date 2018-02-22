package com.example.kakehi.java_android_nock;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by kakehi on 2018/02/19.
 */
public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String accessUrl = "https://akira-watson.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);

        //WebView
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.web);
                webView = findViewById(R.id.web_view);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setDomStorageEnabled(true);
                getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
                );
                webView.loadUrl(accessUrl);
            }
        });

        // Browser
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(accessUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    /**
     * @link https://developer.android.com/reference/android/view/KeyEvent.html#ACTION_DOWN
     * @param keyCode
     * @param event
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //event.getAction() == KeyEvent.ACTION_DOWN キーが押されたイベントが発生したことを示す
        //keyCode == KeyEvent.KEYCODE_BACK 押されたキーがBack Keyであることを示す
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }
}
