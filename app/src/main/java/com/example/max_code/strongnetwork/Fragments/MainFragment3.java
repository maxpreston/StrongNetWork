package com.example.max_code.strongnetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.max_code.strongnetwork.Base.BaseFragment;
import com.example.max_code.strongnetwork.NetJSON.CommToBean;
import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.api.NetWorkAPI;
import com.example.max_code.strongnetwork.bean.MessageEntitys;

import java.util.List;

import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by max-code on 2016/9/4.
 */
public class MainFragment3 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fraglayout2,container,false);
        ButterKnife.bind(this,view);
        sb = NetWorkAPI.
                getNetWorkAPI().
                getCommInfo().
                getCommInfo("127068014","1","15").map(new Func1<CommToBean, List<MessageEntitys>>() {
            @Override
            public List<MessageEntitys> call(CommToBean commToBean) {
                Log.e("flagStr-->",commToBean.flagStr);
                return commToBean.msgListTwo;
            }

        }).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<MessageEntitys>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getActivity(), "加载完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("通用转Bean异常-->",e.getMessage());
                Toast.makeText(getActivity(), "加载异常", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(List<MessageEntitys> s) {
                Toast.makeText(getActivity(), "加载成功", Toast.LENGTH_SHORT).show();
                Log.e("t信息content-->",s.get(0).msgVo.msgTitle);
            }
        });
//        sb = DataGet.getDataGet().getComminfos(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(getActivity(), "完成", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("异常-->",e.getMessage());
//                Toast.makeText(getActivity(), "异常-->"+e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNext(String s) {
//                Toast.makeText(getActivity(), "通用返回信息--->"+s, Toast.LENGTH_SHORT).show();
//                unsubscribe();
//                Log.e("通用返回信息-->",s);
//            }
//        });

        return view;

    }
}
