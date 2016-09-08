package com.example.max_code.strongnetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.max_code.strongnetwork.Adapter.Rev2Adapter;
import com.example.max_code.strongnetwork.Base.BaseFragment;
import com.example.max_code.strongnetwork.DataSource.DataGet;
import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.bean.MsgBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;

/**
 * Created by max-code on 2016/9/4.
 */
public class MainFragment2 extends BaseFragment {
    @Bind(R.id.main2_rev)
    RecyclerView rev;
    Subscription subscription;
    Rev2Adapter read2 = new Rev2Adapter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fraglayout1,container,false);
        ButterKnife.bind(this,view);
//        subscription = DataGet.getDataGet().getCSSSubscription(new Observer<List<MsgBean>>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(getActivity().getApplicationContext(), "css数据加载完成", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("异常-->",e.getMessage());
//            }
//
//            @Override
//            public void onNext(List<MsgBean> msgBeen) {
//                //结束引用防止内存泄漏
//                Log.e("msgbean.size-->",String.valueOf(msgBeen.size()));
//                unsubscribe();
//                rev.setLayoutManager(new LinearLayoutManager(getActivity()));
//                rev.setAdapter(read2);
//                read2.setItems(msgBeen);
//            }
//        });

        return view;

    }
}
