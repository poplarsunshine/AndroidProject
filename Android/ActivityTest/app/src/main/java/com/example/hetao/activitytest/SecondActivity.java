package com.example.hetao.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String data = intent.getStringExtra("dataKey");
        Toast toast = Toast.makeText(SecondActivity.this, data, Toast.LENGTH_LONG);
        toast.show();

        Log.d("SecondActivity", "Task id is " + getTaskId());
    }

    @Override
    public void onBackPressed() {
        this.backAction();
    }

    public void onBtnClick(View view) {
        Toast toast = Toast.makeText(SecondActivity.this, "SecondActivity", Toast.LENGTH_SHORT);
        toast.show();

//        this.backAction();

        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intent);
    }

    // 回传参数
    public  void backAction(){
        Intent intent = new Intent();
        intent.putExtra("backDataKey", "hello, back from secondActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
