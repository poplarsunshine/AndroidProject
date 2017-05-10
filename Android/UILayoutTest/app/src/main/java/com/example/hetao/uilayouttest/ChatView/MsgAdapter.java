package com.example.hetao.uilayouttest.ChatView;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hetao.uilayouttest.R;

import java.util.List;

/**
 * Created by hetao on 2017/5/9.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder> {

    private List<Msg> mMsgList;

    static class MsgViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsgTextView;
        TextView rightMsgTextView;

        public MsgViewHolder(View view){
            super(view);
            leftMsgTextView = (TextView) view.findViewById(R.id.msg_text_left);
            rightMsgTextView = (TextView) view.findViewById(R.id.msg_text_right);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
        }
    }

    public MsgAdapter(List<Msg> list){
        mMsgList = list;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        final MsgViewHolder holder = new MsgViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if(msg.getType() == Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsgTextView.setText("L " + msg.getContent());
        }else {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsgTextView.setText("R " + msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
