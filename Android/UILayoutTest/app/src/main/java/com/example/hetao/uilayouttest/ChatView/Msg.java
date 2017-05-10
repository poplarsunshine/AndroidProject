package com.example.hetao.uilayouttest.ChatView;

/**
 * Created by hetao on 2017/5/9.
 */

public class Msg {

    public static final int TYPE_RECEIVED   = 0;    //已接收
    public static final int TYPE_SENT       = 1;    //已发送

    private String content;
    private int type;

    public Msg(String content, int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }
}
