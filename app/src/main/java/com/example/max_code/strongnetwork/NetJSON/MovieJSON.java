package com.example.max_code.strongnetwork.NetJSON;

import com.example.max_code.strongnetwork.bean.MovieBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by max-code on 2016/9/5.
 */
public class MovieJSON {
    @SerializedName("subjects")
    public List<MovieBean> movieBeanList;

}
