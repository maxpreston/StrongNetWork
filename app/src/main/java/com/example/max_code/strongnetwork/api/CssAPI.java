package com.example.max_code.strongnetwork.api;

import com.example.max_code.strongnetwork.NetJSON.CssJSON;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by max-code on 2016/9/5.
 */
public interface CssAPI {
    @GET("callService.do?URL=/mobile/service/noticeApply.do?reqCode=getMsgList")
    Observable<CssJSON> getCSSJSON(@Query("userid") String userid, @Query("startItem") String startItem, @Query("endItem") String endItem);

}
