package com.example.max_code.strongnetwork.NetJSON;

import com.example.max_code.strongnetwork.bean.MessageEntitys;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by max-code on 2016/9/8.
 */
public class CommToBean {
    @SerializedName("totalItem")
    public String totalItem;

    @SerializedName("msgListTwo")
    public List<MessageEntitys> msgListTwo;

    @SerializedName("flagStr")
    public String flagStr;

}
