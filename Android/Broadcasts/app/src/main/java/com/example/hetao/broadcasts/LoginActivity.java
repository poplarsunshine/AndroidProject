package com.example.hetao.broadcasts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordField = (EditText) findViewById(R.id.inputPassword);

        Button loginBtn = (Button) findViewById(R.id.login_btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = passwordField.getText().toString();
                String toast;
                if (input.equals("zhimakaimen")){
                    toast = "登录成功";
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    toast = "登录失败";
                }

                Toast.makeText(v.getContext(), toast, Toast.LENGTH_LONG).show();
            }
        });
    }
}
