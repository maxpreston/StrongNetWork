package com.example.max_code.strongnetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.max_code.strongnetwork.Base.BaseFragment;
import com.example.max_code.strongnetwork.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by max-code on 2016/9/4.
 */
public class MainFragment6 extends BaseFragment {
    @Bind(R.id.main5_tx)
    TextView tx;
    StringBuffer stringBuffer = new StringBuffer();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fraglayout5,container,false);
        ButterKnife.bind(this,view);
        String[] strs = new String[]{"String","Integer","boolean","char","long"};
        Observable.
                from(strs).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("完成-->","");
                Toast.makeText(getActivity(), "已完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("异常-->",e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.e("数据-->",s);
                stringBuffer.append(s);
                Toast.makeText(getActivity(), "哈哈来啦-->"+s, Toast.LENGTH_SHORT).show();
                unsubscribe();
                Log.e("stringbuffer-->",stringBuffer.toString());
            }
        });
        tx.setText("数据集齐："+stringBuffer.toString());
        return view;

    }
}
