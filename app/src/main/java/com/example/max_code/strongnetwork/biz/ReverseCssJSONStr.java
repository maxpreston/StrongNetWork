package com.example.max_code.strongnetwork.biz;

import android.util.Log;

import com.example.max_code.strongnetwork.NetJSON.CommToBean;
import com.example.max_code.strongnetwork.NetJSON.CssJSON;

import java.util.List;

import rx.functions.Func1;

/**
 * Created by max-code on 2016/9/5.
 */
public class ReverseCssJSONStr implements Func1<CssJSON,List<CommToBean.MessageEntitys>> {
    private  static ReverseCssJSONStr cssJSONStr = new ReverseCssJSONStr();

    public ReverseCssJSONStr() {
    }

    public static ReverseCssJSONStr getCssJSONStr() {
        return cssJSONStr;
    }

    @Override
    public List<CommToBean.MessageEntitys> call(CssJSON cssJSON) {
        Log.e("cssjson-->",cssJSON.toString());
        List<CommToBean.MessageEntitys> msgBeanList = cssJSON.msgBeanList;
        return msgBeanList;
    }
}
