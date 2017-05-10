package com.example.hetao.uilayouttest.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hetao.uilayouttest.R;

import java.util.List;

/**
 * Created by hetao on 2017/5/9.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> mFruitList;

    static class FruitViewHolder extends RecyclerView.ViewHolder{
        ImageView holdFruitImage;
        TextView holdFruitName;
        public FruitViewHolder(View view){
            super(view);
            holdFruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            holdFruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final FruitViewHolder holder = new FruitViewHolder(view);

        holder.holdFruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "You Clicked : " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.holdFruitName.setText(fruit.getName());
        holder.holdFruitImage.setImageResource(fruit.getImageId());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
