package com.example.hetao.uilayouttest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        ActionBar bar = getSupportActionBar();
        if (bar != null){
            bar.hide();
        }

        TextView textView = (TextView)this.findViewById(R.id.title_Text);
        textView.setText("CustomNavigatView");
    }
}
