package com.example.dell.h1810a_5_29_1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.h1810a_5_29_1.R;
import com.example.dell.h1810a_5_29_1.bean.GrilBean;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<GrilBean.ResultsBean> mList;

    public MainAdapter(Context context, ArrayList<GrilBean.ResultsBean> list) {
        mContext = context;
        mList = list;
    }

    public void setList(ArrayList<GrilBean.ResultsBean> list) {
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GrilBean.ResultsBean resultsBean = mList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(resultsBean.getCreatedAt());
        Glide.with(mContext).load(resultsBean.getUrl()).into(myViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
