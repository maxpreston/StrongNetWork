package com.example.max_code.strongnetwork.api;

import android.content.Context;

import com.example.max_code.strongnetwork.R;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by max-code on 2016/9/4.
 */
public class NetWorkAPI {
    private static NetWorkAPI netWorkAPI = new NetWorkAPI();

    public NetWorkAPI() {
    }

    public static NetWorkAPI getNetWorkAPI() {
        return netWorkAPI;
    }

    private static GankAPI gankAPI;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory cfactory = GsonConverterFactory.create();
    private static CallAdapter.Factory callfactory = RxJavaCallAdapterFactory.create();
    private static CssAPI cssAPI;
    private static CommInfoAPI commInfoAPI;
    private static ZhuangBiAPI zhuangBiAPI;
    //请求网络数据
    public static GankAPI getNetJSON(String baseurl){
        if(gankAPI==null){
            Retrofit retrofit = new Retrofit.
                    Builder().
                    client(okHttpClient).
                    baseUrl("http://gank.io/api/").
                    addConverterFactory(cfactory).
                    addCallAdapterFactory(callfactory).
                    build();
            gankAPI = retrofit.create(GankAPI.class);
        }
        return gankAPI;
    }
    //请求消息列表数据
    public static CssAPI getCssAPI(){
        if(cssAPI==null){
            Retrofit retrofit = new Retrofit.Builder().
                    client(okHttpClient).
                    baseUrl("http://ydbg.jxgs.gov.cn:8888/ydqz/mobileCtrl/").
                    addConverterFactory(cfactory).
                    addCallAdapterFactory(callfactory).build();
            cssAPI = retrofit.create(CssAPI.class);
        }
        return cssAPI;
    }
    //获取通用JSON信息
    public static CommInfoAPI getCommInfo(){
        if(commInfoAPI==null){
            Retrofit retrofit = new Retrofit.Builder().
                    client(okHttpClient).
                    baseUrl("http://ydbg.jxgs.gov.cn:8888/ydqz/mobileCtrl/").addConverterFactory(cfactory).addCallAdapterFactory(callfactory)
                    .build();
            commInfoAPI = retrofit.create(CommInfoAPI.class);
        }
        return commInfoAPI;
    }
    //获取装逼信息
    public static ZhuangBiAPI getZhuangBi(){
        if(zhuangBiAPI==null){
            Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl("http://zhuangbi.info/").addConverterFactory(cfactory).addCallAdapterFactory(callfactory).build();
            zhuangBiAPI = retrofit.create(ZhuangBiAPI.class);

        }
        return zhuangBiAPI;
    }
}
