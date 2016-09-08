package com.example.max_code.strongnetwork.biz;

import com.example.max_code.strongnetwork.NetJSON.NetJSONStr;
import com.example.max_code.strongnetwork.bean.GankBeauty;
import com.example.max_code.strongnetwork.bean.ImageEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.functions.Func1;

/**
 * Created by max-code on 2016/9/4.
 */
public class ReverseJSONStr implements Func1<NetJSONStr, List<ImageEntity>> {
    private static ReverseJSONStr reverseJSONStr = new ReverseJSONStr();

    public ReverseJSONStr() {
        super();
    }

    public static ReverseJSONStr getReverseJSONStr() {
        return reverseJSONStr;
    }
    //将网络数据进行处理并返回
    @Override
    public List<ImageEntity> call(NetJSONStr netJSONStr) {
        List<GankBeauty> listNet = netJSONStr.gankBeautyList;
        List<ImageEntity> listImages = new ArrayList<ImageEntity>();
        //处理时间格式
        SimpleDateFormat innerformat  = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS:'Z'");
        SimpleDateFormat outerformat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for (GankBeauty gb:listNet){
            ImageEntity imageEntity = new ImageEntity();
            try {
                Date date = innerformat.parse(gb.createdAt);
                imageEntity.imgname = outerformat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                imageEntity.imgname = "未知名称";
            }
            imageEntity.imgurl = gb.url;
            listImages.add(imageEntity);
        }
        return listImages;
    }
}
