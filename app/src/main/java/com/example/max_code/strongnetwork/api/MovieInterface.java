package com.example.max_code.strongnetwork.api;

import com.example.max_code.strongnetwork.NetJSON.MovieJSON;
import com.example.max_code.strongnetwork.bean.MovieBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by max-code on 2016/9/5.
 */
public interface MovieInterface {
    @GET("top250")
    Call<MovieJSON> getMovielist(@Query("start") int start, @Query("count") int count);
}
