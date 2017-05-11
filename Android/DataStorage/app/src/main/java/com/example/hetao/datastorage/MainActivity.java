package com.example.hetao.datastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private TextView textLabel;
    private EditText textField;
    private static String filename = "fileName";
    private static String preferencesFileName = "preferencesFileName";
    private static String preferencesDataKey = "preferencesDataKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLabel = (TextView) findViewById(R.id.textView);
        textField = (EditText) findViewById(R.id.input);
    }

    void onBtnClick(View view){
        switch (view.getId()) {
            case R.id.btnSet: {
                String input = textField.getText().toString();
                saveInput(input);
            }
            break;
            case R.id.btnGet: {
                String input = loadFromFile();
//                String input = textField.getText().toString();
                textLabel.setText("File: " + input);
            }
            break;
            case R.id.shareBtnSet: {
                String input = textField.getText().toString();
                saveToSharePreferencesInput(input);
            }
            break;
            case R.id.shareBtnGet: {
                String input = getFromSharePreferencesInput();
//                String input = textField.getText().toString();
                textLabel.setText("SharePreferences: " + input);
            }
            break;
            default:
                break;
        }
    }

    // 存

    /*文件路径：
    * Android Studio Menu > Tools > Android > Android Device Monitor >
    * File Explorer >
    * /data/data/com.example.DataStorage/files/fileName
    * */
    public void saveInput (String text){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput(filename, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (writer != null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // 取
    public String loadFromFile () {
        StringBuilder content = new StringBuilder();

        FileInputStream in = null;
        BufferedReader reader = null;

        try {
            in = openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null){
                content.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    // SharePreferences 存
    /*文件路径：
    * Android Studio Menu > Tools > Android > Android Device Monitor >
    * File Explorer >
    * /data/data/com.example.DataStorage/shared_prefs/preferencesFileName.xml
    * */
    public void saveToSharePreferencesInput(String text) {
        SharedPreferences.Editor editor = getSharedPreferences(preferencesFileName, MODE_PRIVATE).edit();
        editor.putString(preferencesDataKey, text);
        editor.apply();
    }

    // SharePreferences 取
    public String getFromSharePreferencesInput () {
        SharedPreferences pref = getSharedPreferences(preferencesFileName, MODE_PRIVATE);
        String content = pref.getString(preferencesDataKey, "");
        return content;
    }
}
