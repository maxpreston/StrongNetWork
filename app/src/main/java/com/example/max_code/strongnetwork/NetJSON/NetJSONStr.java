package com.example.max_code.strongnetwork.NetJSON;

import com.example.max_code.strongnetwork.bean.GankBeauty;
import com.example.max_code.strongnetwork.bean.ImageEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by max-code on 2016/9/4.
 */
public class NetJSONStr {
    //同下
    public @SerializedName("error")
    boolean error;
    //此处存储从网络源拿到的results节点下数据
    public @SerializedName("results")
    List<GankBeauty> gankBeautyList;
}
