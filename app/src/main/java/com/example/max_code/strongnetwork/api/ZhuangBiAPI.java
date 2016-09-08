package com.example.max_code.strongnetwork.api;

import com.example.max_code.strongnetwork.bean.ZhuangBiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by max-code on 2016/9/5.
 */
public interface ZhuangBiAPI {
    @GET("search")
    Observable<List<ZhuangBiBean>> getZhuangInfo(@Query("q") String key);
}
