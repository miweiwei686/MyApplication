package com.example.miwei.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTestActivity extends AppCompatActivity {

    private static String TAG = ThreadTestActivity.class.getSimpleName();
    private ExecutorService executorService = null;
    private Button btn_begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
        executorService = new ThreadPoolExecutor(3, 5,
                1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(128));

        btn_begin = (Button)findViewById(R.id.btn_begin);
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"hello");
                beginThread();
            }
        });
    }

    private void beginThread() {

        for (int i = 0; i < 30; i++) {
            final int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    Log.i(TAG, "run: " + finalI);
                }
            };
            executorService.execute(runnable);
        }

    }


}
