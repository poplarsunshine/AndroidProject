package com.example.hetao.uilayouttest.ChatView;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hetao.uilayouttest.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<Msg>();
    private MsgAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }

        TextView textView = (TextView) this.findViewById(R.id.title_Text);
        textView.setText("消息");
        Button btn = (Button) this.findViewById(R.id.title_rightBtn);
        btn.setText("清空");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgList.clear();
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(msgList.size() - 1);

                hideKeyboard(v);
            }
        });

        initDatas();

        recyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
    }

    private void initDatas() {
        Msg msg1 = new Msg("Mango", Msg.TYPE_RECEIVED);
        msgList.add(msg1);

        Msg msg2 = new Msg("who is it?", Msg.TYPE_SENT);
        msgList.add(msg2);
    }

    public void onBtnClick(View view) {

        EditText textField = (EditText) this.findViewById(R.id.input_text);
        String message = textField.getText().toString();
        if (message != null && message.length() > 0) {
            Msg msg1 = new Msg(message, Msg.TYPE_SENT);
            msgList.add(msg1);
            Msg msg2 = new Msg("收到了：" + message, Msg.TYPE_RECEIVED);
            msgList.add(msg2);
            adapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(msgList.size() - 1);
            textField.setText("");
        } else {
            Toast.makeText(this, "No message", Toast.LENGTH_SHORT).show();
        }

        hideKeyboard(view);
    }

    // 隐藏键盘
    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
