package com.example.hetao.activitytest;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    private static final int FirstToSecondTAG = 10001;

    // 重写MenuUI
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 重写Menu 事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = "MenuItem";
        switch (item.getItemId()){
            case R.id.add_item:
            {
                title = "R.id.add_item " + R.id.add_item;
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            break;
            case R.id.remove_item:
            {
                title = "R.id.remove_item " + R.id.remove_item;
                finish();
            }
            break;

            default:
                break;
        }
        String toastTitle = "onBtnClick " + title;
        Toast toast = Toast.makeText(FirstActivity.this, toastTitle, Toast.LENGTH_SHORT);
        toast.show();

        return true;
    }

    // 重写onActivityResult()
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case FirstToSecondTAG:
            {
                if (resultCode == RESULT_OK){
                    String resultData = data.getStringExtra("backDataKey");
                    Toast toast = Toast.makeText(FirstActivity.this, resultData, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.first_layout);

        Log.d("FirstActivity", "Task id is " + getTaskId());

        Button btn1 = (Button)this.findViewById(R.id.firstButton_1);
        Button btn2 = (Button)this.findViewById(R.id.firstButton_2);

        // OnClickListener 第一种
//        btn1.setOnClickListener(new View.OnClickListener(){
//            public void  onClick(View view){
//                Toast toast = Toast.makeText(FirstActivity.this, "第一种 You clicked Button 1", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener(){
//            public void  onClick(View view){
//                Toast toast = Toast.makeText(FirstActivity.this, "第一种 You clicked Button 2", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });

        // OnClickListener 第二种
        View.OnClickListener listener = new View.OnClickListener(){
            public void  onClick(View view){
                FirstActivity.this.onBtnClick(view);
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
    }

    // OnClickListener 第三种
    public void onBtnClick(View view){
        String title = "button";
        switch (view.getId())
        {
            case R.id.firstButton_1:
            {
                title = "button 1";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("dataKey", "hello secondActivity, From firstActitvity");
//                startActivity(intent);
                startActivityForResult(intent, FirstToSecondTAG);
            }
            break;
            case R.id.firstButton_2:
            {
                title = "button 2";
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
            break;
            case R.id.firstButton_3:
            {
                title = "button 3";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.helijia.com"));
                intent.setData(Uri.parse("tel:13488838432"));
                startActivity(intent);
            }
            break;
        }
        String toastTitle = "onBtnClick " + title;
        Toast toast = Toast.makeText(FirstActivity.this, toastTitle, Toast.LENGTH_SHORT);
        toast.show();
    }
}
