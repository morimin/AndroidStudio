package com.astar.smin.komca;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Init extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init);

        initialize();
    }

    private void initialize() {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0, 1500); //3초후 종료시킴.
    }
}