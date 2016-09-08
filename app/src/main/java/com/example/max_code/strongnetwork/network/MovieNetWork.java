package com.example.max_code.strongnetwork.network;

import com.example.max_code.strongnetwork.NetJSON.MovieJSON;
import com.example.max_code.strongnetwork.api.MovieInterface;
import com.example.max_code.strongnetwork.bean.MovieBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by max-code on 2016/9/5.
 */
public class MovieNetWork {


    public MovieNetWork() {
    }

    public static MovieNetWork getMovieNetWork() {
        return movieNetWork;
    }

    private static MovieNetWork movieNetWork = new MovieNetWork();

    public Call getMovieInfo(String baseUrl){
        Retrofit retrofit = new Retrofit.
                Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        MovieInterface movieInterface = retrofit.create(MovieInterface.class);
        Call<MovieJSON> call = movieInterface.getMovielist(0,10);
        return call;
    }
}
