package com.example.hetao.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.d("ThirdActivity", "Task id is " + getTaskId());
    }

    public void onBtnClick(View view) {
        Toast toast = Toast.makeText(ThirdActivity.this, "ThirdActivity", Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
        startActivity(intent);
    }
}
