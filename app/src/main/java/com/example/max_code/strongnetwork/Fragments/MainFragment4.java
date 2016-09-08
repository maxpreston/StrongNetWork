package com.example.max_code.strongnetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.max_code.strongnetwork.Adapter.Rev4Adapter;
import com.example.max_code.strongnetwork.Base.BaseFragment;
import com.example.max_code.strongnetwork.NetJSON.MovieJSON;
import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.bean.MovieBean;
import com.example.max_code.strongnetwork.network.MovieNetWork;
import com.jakewharton.rxbinding.view.RxView;

import java.util.List;
import java.util.Observable;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by max-code on 2016/9/4.
 */
public class MainFragment4 extends BaseFragment {
    @Bind(R.id.main4_rev)
    RecyclerView rev;
    Rev4Adapter read4 = new Rev4Adapter();
    Call<MovieJSON> call;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fraglayout3,container,false);
        ButterKnife.bind(this,view);
        call = MovieNetWork.getMovieNetWork().getMovieInfo("https://api.douban.com/v2/movie/");
        call.enqueue(new Callback<MovieJSON>() {
            @Override
            public void onResponse(Call<MovieJSON> call, Response<MovieJSON> response) {
                Toast.makeText(getActivity(), "成功获取电影信息,请返回日志查看", Toast.LENGTH_SHORT).show();
                rev.setLayoutManager(new LinearLayoutManager(getActivity()));
                rev.setAdapter(read4);
                read4.setItems(response.body().movieBeanList);
                for (MovieBean mj:response.body().movieBeanList){
                    Log.e("电影信息-->",mj.original_title);
                }
                call.cancel();
            }

            @Override
            public void onFailure(Call<MovieJSON> call, Throwable t) {
                Toast.makeText(getActivity(), "获取电影信息失败", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
