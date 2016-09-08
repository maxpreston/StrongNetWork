package com.example.max_code.strongnetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.AndroidCharacter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.max_code.strongnetwork.Adapter.Rev5Adapter;
import com.example.max_code.strongnetwork.Base.BaseFragment;
import com.example.max_code.strongnetwork.DataSource.DataGet;
import com.example.max_code.strongnetwork.R;
import com.example.max_code.strongnetwork.api.NetWorkAPI;
import com.example.max_code.strongnetwork.bean.MsgBean;
import com.example.max_code.strongnetwork.bean.ZhuangBiBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by max-code on 2016/9/4.
 */
public class MainFragment5 extends BaseFragment {
    @Bind(R.id.main5_rev)
    RecyclerView rev;
    Rev5Adapter read5 = new Rev5Adapter();
    Observer<List<ZhuangBiBean>> observe = new Observer<List<ZhuangBiBean>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(getActivity(), "异常-->"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(List<ZhuangBiBean> zhuangBiBeen) {
            read5.setItems(zhuangBiBeen);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fraglayout4,container,false);
        ButterKnife.bind(this,view);
        rev.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rev.setAdapter(read5);
        return view;

    }
    @OnCheckedChanged({R.id.main5_group_ka,R.id.main5_group_md,R.id.main5_group_zb,R.id.main5_group_gx})
    public void checkChange(RadioButton rb,boolean checked){
        if(checked){
            unsubscribe();
            search(rb.getText().toString());
        }
    }

    public void search(String key){
        sb = NetWorkAPI.
                getNetWorkAPI().
                getZhuangBi().
                getZhuangInfo(key).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observe);
    }
}
