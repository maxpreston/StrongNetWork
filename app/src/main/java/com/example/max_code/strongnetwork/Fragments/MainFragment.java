package com.example.max_code.strongnetwork.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.max_code.strongnetwork.Adapter.RevAdapter;
import com.example.max_code.strongnetwork.Base.BaseFragment;
import com.example.max_code.strongnetwork.Base.MainActivity;
import com.example.max_code.strongnetwork.DataSource.DataGet;
import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.bean.ImageEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;

/**
 * Created by max-code on 2016/9/4.
 */
public class MainFragment extends BaseFragment {
    @Bind(R.id.main_rev)
    RecyclerView rev;
    @Bind(R.id.main_refresh)
    SwipeRefreshLayout refreshLayout;
    RevAdapter revAdapter = new RevAdapter();
    Subscription sb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fraglayout,container,false);
        ButterKnife.bind(this,view);
        unsubscribe();
        Toast.makeText(getActivity(), "重新调用oncreateview()", Toast.LENGTH_SHORT).show();
        sb = DataGet.getDataGet().subscriptionData(new Observer<List<ImageEntity>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getActivity(), "完成了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("异常-->",e.getMessage());
            }

            @Override
            public void onNext(List<ImageEntity> imageEntityList) {
                Toast.makeText(getActivity(), DataGet.getDataGet().getDATAResource(), Toast.LENGTH_SHORT).show();
                Log.e("imgs.size-->",String.valueOf(imageEntityList.size()));
                rev.setLayoutManager(new GridLayoutManager(getActivity(),2));
                revAdapter.setItems(imageEntityList);
                rev.setAdapter(revAdapter);
            }
        });
        refreshLayout.setColorSchemeColors(Color.BLUE,Color.BLUE,Color.BLUE);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "刷新了", Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "销毁", Toast.LENGTH_SHORT).show();
    }
}
