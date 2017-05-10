package com.example.hetao.uilayouttest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

import com.example.hetao.uilayouttest.ChatView.ChatActivity;
import com.example.hetao.uilayouttest.RecyclerActivity;

public class LinearActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        ActionBar bar = getSupportActionBar();
//        bar.setTitle("Linear Layout");
        if (bar != null){
            bar.hide();
        }
        TextView textView = (TextView) this.findViewById(R.id.title_Text);
        textView.setText("Linear Layout");

        imageView = (ImageView) this.findViewById(R.id.first_imageView);
        progressBar = (ProgressBar) this.findViewById(R.id.first_progressBar);
        progressBar.setMax(10);
        progressBar.setProgress(1);
    }

    // OnClickListener 第三种
    public void onBtnClick(View view){

        switch (view.getId())
        {
            case R.id.firstButton_1:
            {
                AlertDialog.Builder dialog = new AlertDialog.Builder(LinearActivity.this);
                dialog.setTitle("是否重置进度?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("重置", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProgressDialog pDialog = new ProgressDialog(LinearActivity.this);
                        pDialog.setTitle("重置中");
                        pDialog.setMessage("点击Back键结束");
                        pDialog.setCancelable(true);
                        pDialog.show();

                        progressBar.setProgress(0);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                dialog.show();
            }
            break;
            case R.id.firstButton_2:
            {
                int progress = progressBar.getProgress();
                progress += 1;
                progressBar.setProgress(progress);
            }
            break;
            case R.id.firstButton_3:
            {
                if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.result_tanhao);
                }else {
                    progressBar.setVisibility(View.GONE);
                    imageView.setImageResource(R.drawable.result_right);
                }
            }
            break;

            case R.id.nextButton_relative:
            {
                Intent intent = new Intent(LinearActivity.this, RelativeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.nextButton_frame:
            {
                Intent intent = new Intent(LinearActivity.this, FrameActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.nextButton_percent:
            {
                Intent intent = new Intent(LinearActivity.this, PercentActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.firstButton_custom:
            {
                Intent intent = new Intent(LinearActivity.this, CustomActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.firstButton_recyclerView:
            {
                Intent intent = new Intent(LinearActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.firstButton_chat:
            {
                Intent intent = new Intent(LinearActivity.this, ChatActivity.class);
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }
}
