package com.example.max_code.strongnetwork.NetJSON;

import com.example.max_code.strongnetwork.bean.DataVersion;
import com.example.max_code.strongnetwork.bean.MessageEntitys;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by max-code on 2016/9/5.
 */
public class CssJSON {
    @SerializedName("flagStr")
    public String flagStr;
    @SerializedName("totalItem")
    public String totalItem;
    @SerializedName("msgListTwo")
    public List<MessageEntitys> msgBeanList;
    @SerializedName("dataversion")
    public DataVersion dataversion;
}
