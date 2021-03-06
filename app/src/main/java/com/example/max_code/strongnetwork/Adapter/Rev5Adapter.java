package com.example.max_code.strongnetwork.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.bean.ImageEntity;
import com.example.max_code.strongnetwork.bean.ZhuangBiBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by max-code on 2016/9/4.
 */
public class Rev5Adapter extends RecyclerView.Adapter<Rev5Adapter.MyViewHolder> {
    ClickListener clickListener;
    List<ZhuangBiBean> list = new ArrayList<ZhuangBiBean>();
    public ClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public Rev5Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        MyViewHolder mvd = (MyViewHolder) holder;
        Glide.with(holder.itemView.getContext()).load(list.get(position).image_url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.NONE).into(mvd.img);
        mvd.name.setText(list.get(position).description);
        if(clickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.SetClickListener(holder.getLayoutPosition(),v);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    clickListener.SetClickLongListener(holder.getLayoutPosition(),v);
                    return true;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size();
    }

    public void setItems(List<ZhuangBiBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.item_img)
        ImageView img;
        @Bind(R.id.item_text)
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    interface ClickListener{
        public void SetClickListener(int position, View view);
        public void SetClickLongListener(int position, View view);
    }
}
