package com.example.max_code.strongnetwork.api;

import com.example.max_code.strongnetwork.NetJSON.CommToBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by max-code on 2016/9/6.
 */
public interface CommInfoAPI {
    @GET("callService.do?URL=/mobile/service/noticeApply.do?reqCode=getMsgList")
    Observable<CommToBean> getCommInfo(@Query("userid") String userid, @Query("startItem") String startItem, @Query("endItem") String endItem);
}
