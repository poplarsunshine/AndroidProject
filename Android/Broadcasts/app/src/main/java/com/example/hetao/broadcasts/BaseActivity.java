package com.example.hetao.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    private LogoutBoardReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);

        setContentView(R.layout.activity_base);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasts.LogOut");
        receiver = new LogoutBoardReceiver();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
        unregisterReceiver(receiver);
    }

    class LogoutBoardReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            //Toast.makeText(context, "LogoutBoardReceiver" + context.getClass(), Toast.LENGTH_LONG).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("提示");
            builder.setMessage("你已经下线，请重新登录");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO 销毁所有活动
                    ActivityCollector.finishAll();

                    Intent activityIntent = new Intent(context, LoginActivity.class);
                    context.startActivity(activityIntent);
                }
            });
            builder.show();
        }
    }
}
