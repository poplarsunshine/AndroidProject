package com.example.hetao.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by hetao on 2017/5/16.
 */

public class MyIntentService extends IntentService {
    public MyIntentService (){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // 打印当前线程ID
        Log.d("MyIntentService", "Thread id = " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy: executed");
    }
}
