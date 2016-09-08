package com.example.max_code.strongnetwork.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.bean.MovieBean;
import com.example.max_code.strongnetwork.bean.MsgBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by max-code on 2016/9/5.
 */
public class Rev4Adapter extends RecyclerView.Adapter {
    private List<MovieBean> list;
    private RevAdapter.ClickListener clickListener;

    public RevAdapter.ClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(RevAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new TViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        TViewHolder tvd = (TViewHolder) holder;
        tvd.title.setText(list.get(position).id);
        tvd.time.setText(list.get(position).title);
        tvd.content.setText(list.get(position).original_title);
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
    class TViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.item2_title)
        TextView title;
        @Bind(R.id.item2_time)
        TextView time;
        @Bind(R.id.item2_content)
        TextView content;
        public TViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void setItems(List<MovieBean> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
