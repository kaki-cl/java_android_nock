package com.example.kakehi.java_android_nock;


public class HeavyTask {

    private SampleListener listener;

    interface SampleListener {
        void onSuccess(int result);
    }

    // listener
    void setListener(SampleListener listener) {
        this.listener = listener;
    }

    void taskStart() {
        int sum = 1;
        for (int i = 0; i < 20; i++) {
            sum += sum;
        }

        if (listener != null) {
            // 計算が終わったら結果をlistnerに渡す
            // HeavyTask.TestListerインターフェイスのonSuccessメソッドを実行している
            listener.onSuccess(sum);

        }
    }


}
