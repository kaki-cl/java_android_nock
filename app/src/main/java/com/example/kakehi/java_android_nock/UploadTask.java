package com.example.kakehi.java_android_nock;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UploadTask extends AsyncTask<String, Void, String> {

    private UploadListener uploadListener;

    @Override
    protected String doInBackground(String... params) {

        String urlSt = "http://10.0.2.2:8000/pass_check.php";

        HttpURLConnection connection = null;
        String result = null;
        String word = "word=" + params[0];

        try {
            URL url = new URL(urlSt);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setInstanceFollowRedirects(false);
            connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(20000);

            connection.connect();
            OutputStream out = null;
            try {
                out = connection.getOutputStream();
                out.write(word.getBytes("UTF-8"));
                out.flush();
                Log.d("debug", "flush");
            } catch (IOException e) {
                e.printStackTrace();
                result = "POST送信エラー";
            } finally {
                if (out != null) {
                    out.close();
                }
            }

            final int status = connection.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                result = "HTTP_OK";
            } else {
                result = "status=" + String.valueOf(status);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (uploadListener != null) {
            uploadListener.onSuccess(result);
        }
    }

    interface UploadListener {
        void onSuccess(String result);
    }

    void setListener(UploadListener uploadListener) {
        this.uploadListener = uploadListener;
    }
}
