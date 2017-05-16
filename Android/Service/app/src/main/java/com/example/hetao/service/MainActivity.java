package com.example.hetao.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int UPDATE_TEXT = 1;
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private Handler myhandler = new Handler() {
      public void handleMessage(Message msg) {
          switch (msg.what) {
              case UPDATE_TEXT:
              {
                  // 处理具体逻辑
                  Log.d("tag", "子线程干点啥?");

                  Toast.makeText(MainActivity.this, "From Sub Thread", Toast.LENGTH_SHORT).show();

                  Log.d("tag", "子线程弹了个窗");
              }
                  break;
              default:
                  break;
          }
      }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view){
        switch (view.getId()){
            case R.id.btnThread:
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = UPDATE_TEXT;
                        myhandler.sendMessage(msg);
                    }
                }).start();
            }
                break;
            case R.id.btnStartService:
            {
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
            }
            break;
            case R.id.btnStopService:
            {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
            }
            break;
            case R.id.btnBindService:
            {
                Intent intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
            break;
            case R.id.btnUnBindService:
            {
                unbindService(connection);
            }
            break;
            case R.id.btnIntentService:
            {
                Log.d("MyActivity", "Thread id = " + Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
            }
            break;
            default:
                break;
        }
    }
}
