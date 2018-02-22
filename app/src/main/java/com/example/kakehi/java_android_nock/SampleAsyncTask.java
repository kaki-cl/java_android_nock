package com.example.kakehi.java_android_nock;

import android.os.AsyncTask;
import android.util.Log;

public class SampleAsyncTask extends AsyncTask<Integer, Integer, Integer> {

    private Listener listener;

    interface Listener {
        void onSuccess(int result);
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }


    /**
     * //AsyncTask<Params, Progress, Result> について
     * @link https://akira-watson.com/android/asynctask.html
     * 可変長引数
     * @link http://www.ne.jp/asahi/hishidama/home/tech/java/varargs.html
     * @param params
     * @return
     */
    // 非同期処理
    @Override
    protected Integer doInBackground(Integer... params) {

        //10秒数える処理
        do {
            try {
                // 1sec sleep
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e("error", e.getMessage());
                Thread.currentThread().interrupt();
            }

            Log.d("doInBackground", "" + params[0]);
            params[0]++;


            // 途中経過を返す
//            publishProgress(params[0]);
            // onProgressUpdateで20が出力される
            publishProgress(20);


        } while (params[0] < 10);

        Log.d("doInBackground at end", "" + params[0]);
//        return params[0];
        // onPostExecuteで30が出力される
        return 30;
    }

    // 途中経過をメインスレッドに返す
    @Override
    protected void onProgressUpdate(Integer... progress) {
        if (listener != null) {
            Log.d("onProgressUpdate", String.valueOf(progress[0]));
            listener.onSuccess(progress[0]);
        }
    }

    // 非同期処理が終了後、結果をメインスレッドに返す
    @Override
    protected void onPostExecute(Integer result) {
        if (listener != null) {
            Log.d("onPostExecute", String.valueOf(result));
            listener.onSuccess(result);
        }
    }
}
