package com.example.max_code.strongnetwork.api;

import com.example.max_code.strongnetwork.NetJSON.NetJSONStr;
import com.example.max_code.strongnetwork.bean.GankBeauty;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by max-code on 2016/9/4.
 */
public interface GankAPI {
    //此接口为网络数据请求名以及参数
    @GET("data/福利/{number}/{page}")
    Observable<NetJSONStr> getGankBeauties(@Path("number") int number,@Path("page") int page);
}
